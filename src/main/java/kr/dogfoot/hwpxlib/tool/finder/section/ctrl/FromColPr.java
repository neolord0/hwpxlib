package kr.dogfoot.hwpxlib.tool.finder.section.ctrl;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.ctrl.ColPr;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.ctrl.inner.ColSz;
import kr.dogfoot.hwpxlib.tool.finder.Parameter;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderBase;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderManager;

public class FromColPr extends FinderBase {
    public FromColPr(FinderManager finderManager, Parameter parameter) {
        super(finderManager, parameter);
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_colPr;
    }

    @Override
    public void find(HWPXObject from) throws Exception {
        ColPr colPr = (ColPr) from;
        pushPath(colPr);

        for (ColSz colSz : colPr.colSzs()) {
            check(colSz);
        }
        check(colPr.colLine());

        checkSwitchList(colPr.switchList());
        popPath();
    }
}
