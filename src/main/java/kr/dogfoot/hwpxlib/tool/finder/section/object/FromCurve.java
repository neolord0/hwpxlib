package kr.dogfoot.hwpxlib.tool.finder.section.object;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.Curve;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.curve.CurveSegment;
import kr.dogfoot.hwpxlib.tool.finder.Parameter;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderManager;
import kr.dogfoot.hwpxlib.tool.finder.section.object.comm.FromDrawingObject;

public class FromCurve extends FromDrawingObject {
    public FromCurve(FinderManager finderManager, Parameter parameter) {
        super(finderManager, parameter);
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_curve;
    }

    @Override
    public void find(HWPXObject from) throws Exception {
        Curve curve = (Curve) from;
        pushPath(curve);

        checkFromDrawingObject(curve);

        for (CurveSegment seg : curve.segs()) {
            check(seg);
        }

        checkSwitchList(curve.switchList());
        popPath();
    }
}
