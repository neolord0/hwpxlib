package kr.dogfoot.hwpxlib.tool.finder.header;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.Numbering;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.numbering.ParaHead;
import kr.dogfoot.hwpxlib.tool.finder.Parameter;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderBase;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderManager;

public class FromNumbering extends FinderBase {
    public FromNumbering(FinderManager finderManager, Parameter parameter) {
        super(finderManager, parameter);
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hh_numbering;
    }

    @Override
    public void find(HWPXObject from) throws Exception {
        Numbering numbering = (Numbering) from;
        pushPath(numbering);

        for (ParaHead paraHead : numbering.paraHeads()) {
            check(paraHead);
        }

        checkSwitchObject(numbering.switchObject());
        popPath();
    }
}
