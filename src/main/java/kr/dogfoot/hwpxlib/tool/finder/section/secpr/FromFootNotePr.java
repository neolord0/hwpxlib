package kr.dogfoot.hwpxlib.tool.finder.section.secpr;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.secpr.notepr.FootNotePr;
import kr.dogfoot.hwpxlib.tool.finder.Parameter;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderBase;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderManager;

public class FromFootNotePr extends FinderBase {
    public FromFootNotePr(FinderManager finderManager, Parameter parameter) {
        super(finderManager, parameter);
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_footNotePr;
    }

    @Override
    public void find(HWPXObject from) throws Exception {
        FootNotePr footNotePr = (FootNotePr) from;
        pushPath(footNotePr);

        check(footNotePr.autoNumFormat());
        check(footNotePr.noteLine());
        check(footNotePr.noteSpacing());
        check(footNotePr.numbering());
        check(footNotePr.placement());

        checkSwitchObject(footNotePr.switchObject());
        popPath();
    }
}
