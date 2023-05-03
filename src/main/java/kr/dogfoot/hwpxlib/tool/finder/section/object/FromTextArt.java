package kr.dogfoot.hwpxlib.tool.finder.section.object;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.TextArt;
import kr.dogfoot.hwpxlib.tool.finder.Parameter;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderManager;
import kr.dogfoot.hwpxlib.tool.finder.section.object.comm.FromDrawingObject;

public class FromTextArt extends FromDrawingObject {
    public FromTextArt(FinderManager finderManager, Parameter parameter) {
        super(finderManager, parameter);
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_textart;
    }

    @Override
    public void find(HWPXObject from) throws Exception {
        TextArt textArt = (TextArt) from;
        pushPath(textArt);

        checkFromDrawingObject(textArt);

        check(textArt.pt0());
        check(textArt.pt1());
        check(textArt.pt2());
        check(textArt.pt3());
        checkWithChildren(textArt.textartPr());
        checkWithChildren(textArt.outline());

        checkSwitchObject(textArt.switchObject());
        popPath();
    }
}
