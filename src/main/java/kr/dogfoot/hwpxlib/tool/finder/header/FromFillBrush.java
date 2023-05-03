package kr.dogfoot.hwpxlib.tool.finder.header;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.borderfill.FillBrush;
import kr.dogfoot.hwpxlib.tool.finder.Parameter;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderBase;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderManager;

public class FromFillBrush extends FinderBase {
    public FromFillBrush(FinderManager finderManager, Parameter parameter) {
        super(finderManager, parameter);
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hc_fillBrush;
    }

    @Override
    public void find(HWPXObject from) throws Exception {
        FillBrush fillBrush = (FillBrush) from;
        pushPath(fillBrush);

        check(fillBrush.winBrush());
        checkWithChildren(fillBrush.gradation());
        checkWithChildren(fillBrush.imgBrush());

        checkSwitchObject(fillBrush.switchObject());
        popPath();
    }
}
