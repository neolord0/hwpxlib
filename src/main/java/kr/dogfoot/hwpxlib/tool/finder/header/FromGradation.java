package kr.dogfoot.hwpxlib.tool.finder.header;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.borderfill.Color;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.borderfill.Gradation;
import kr.dogfoot.hwpxlib.tool.finder.Parameter;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderBase;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderManager;

public class FromGradation extends FinderBase {
    public FromGradation(FinderManager finderManager, Parameter parameter) {
        super(finderManager, parameter);
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hc_gradation;
    }

    @Override
    public void find(HWPXObject from) throws Exception {
        Gradation gradation = (Gradation) from;
        pushPath(gradation);

        for (Color color : gradation.colors()) {
            check(color);
        }

        checkSwitchObject(gradation.switchObject());
        popPath();
    }
}
