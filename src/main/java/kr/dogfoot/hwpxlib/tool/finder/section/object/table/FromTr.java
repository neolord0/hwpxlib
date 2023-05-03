package kr.dogfoot.hwpxlib.tool.finder.section.object.table;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.table.Tc;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.table.Tr;
import kr.dogfoot.hwpxlib.tool.finder.Parameter;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderBase;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderManager;

public class FromTr extends FinderBase {
    public FromTr(FinderManager finderManager, Parameter parameter) {
        super(finderManager, parameter);
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_tr;
    }

    @Override
    public void find(HWPXObject from) throws Exception {
        Tr tr = (Tr) from;
        pushPath(tr);

        for (Tc tc : tr.tcs()) {
            checkWithChildren(tc);
        }

        checkSwitchObject(tr.switchObject());
        popPath();
    }
}
