package kr.dogfoot.hwpxlib.tool.finder.header;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.ParaPr;
import kr.dogfoot.hwpxlib.tool.finder.Parameter;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderBase;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderManager;

public class FromParaPr extends FinderBase {
    public FromParaPr(FinderManager finderManager, Parameter parameter) {
        super(finderManager, parameter);
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hh_paraPr;
    }

    @Override
    public void find(HWPXObject from) throws Exception {
        ParaPr paraPr = (ParaPr) from;
        pushPath(paraPr);

        check(paraPr.align());
        check(paraPr.heading());
        check(paraPr.breakSetting());
        checkWithChildren(paraPr.margin());
        check(paraPr.lineSpacing());
        check(paraPr.border());
        check(paraPr.autoSpacing());

        checkSwitchObject(paraPr.switchObject());
        popPath();
    }
}
