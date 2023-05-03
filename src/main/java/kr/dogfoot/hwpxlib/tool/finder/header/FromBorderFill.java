package kr.dogfoot.hwpxlib.tool.finder.header;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.BorderFill;
import kr.dogfoot.hwpxlib.tool.finder.Parameter;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderBase;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderManager;

public class FromBorderFill extends FinderBase {
    public FromBorderFill(FinderManager finderManager, Parameter parameter) {
        super(finderManager, parameter);
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hh_borderFill;
    }

    @Override
    public void find(HWPXObject from) throws Exception {
        BorderFill borderFill = (BorderFill) from;
        pushPath(borderFill);

        check(borderFill.slash());
        check(borderFill.backSlash());
        check(borderFill.leftBorder());
        check(borderFill.rightBorder());
        check(borderFill.topBorder());
        check(borderFill.bottomBorder());
        check(borderFill.diagonal());
        checkWithChildren(borderFill.fillBrush());

        checkSwitchObject(borderFill.switchObject());
        popPath();
    }
}
