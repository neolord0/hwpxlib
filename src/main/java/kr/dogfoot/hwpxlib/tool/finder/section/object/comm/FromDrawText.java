package kr.dogfoot.hwpxlib.tool.finder.section.object.comm;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.drawingobject.DrawText;
import kr.dogfoot.hwpxlib.tool.finder.Parameter;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderBase;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderManager;

public class FromDrawText extends FinderBase {
    public FromDrawText(FinderManager finderManager, Parameter parameter) {
        super(finderManager, parameter);
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_drawText;
    }

    @Override
    public void find(HWPXObject from) throws Exception {
        DrawText drawText = (DrawText) from;
        pushPath(drawText);

        check(drawText.textMargin());
        checkWithChildren(drawText.subList());

        checkSwitchList(drawText.switchList());
        popPath();
    }
}
