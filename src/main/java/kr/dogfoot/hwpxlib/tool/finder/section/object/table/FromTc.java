package kr.dogfoot.hwpxlib.tool.finder.section.object.table;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.table.Tc;
import kr.dogfoot.hwpxlib.tool.finder.Parameter;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderBase;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderManager;

public class FromTc extends FinderBase {
    public FromTc(FinderManager finderManager, Parameter parameter) {
        super(finderManager, parameter);
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_tc;
    }

    @Override
    public void find(HWPXObject from) throws Exception {
        Tc tc = (Tc) from;
        pushPath(tc);

        check(tc.cellAddr());
        check(tc.cellSpan());
        check(tc.cellSz());
        check(tc.cellMargin());
        checkWithChildren(tc.subList());

        checkSwitchObject(tc.switchObject());
        popPath();
    }
}
