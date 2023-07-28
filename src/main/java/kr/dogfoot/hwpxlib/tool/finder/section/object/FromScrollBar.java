package kr.dogfoot.hwpxlib.tool.finder.section.object;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.ScrollBar;
import kr.dogfoot.hwpxlib.tool.finder.Parameter;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderManager;
import kr.dogfoot.hwpxlib.tool.finder.section.object.comm.FromFormObject;

public class FromScrollBar extends FromFormObject {
    public FromScrollBar(FinderManager finderManager, Parameter parameter) {
        super(finderManager, parameter);
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_scrollBar;
    }

    @Override
    public void find(HWPXObject from) throws Exception {
        ScrollBar scrollBar = (ScrollBar) from;
        pushPath(scrollBar);

        checkFromFormObject(scrollBar);

        checkSwitchList(scrollBar.switchList());
        popPath();
    }
}
