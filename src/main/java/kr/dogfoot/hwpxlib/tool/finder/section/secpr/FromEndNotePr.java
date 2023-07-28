package kr.dogfoot.hwpxlib.tool.finder.section.secpr;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.secpr.notepr.EndNotePr;
import kr.dogfoot.hwpxlib.tool.finder.Parameter;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderBase;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderManager;

public class FromEndNotePr extends FinderBase {
    public FromEndNotePr(FinderManager finderManager, Parameter parameter) {
        super(finderManager, parameter);
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_endNotePr;
    }

    @Override
    public void find(HWPXObject from) throws Exception {
        EndNotePr endNotePr = (EndNotePr) from;
        pushPath(endNotePr);

        check(endNotePr.autoNumFormat());
        check(endNotePr.noteLine());
        check(endNotePr.noteSpacing());
        check(endNotePr.numbering());
        check(endNotePr.placement());

        checkSwitchList(endNotePr.switchList());
        popPath();
    }
}
