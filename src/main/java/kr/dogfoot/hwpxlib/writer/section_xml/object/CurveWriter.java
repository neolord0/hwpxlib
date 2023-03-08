package kr.dogfoot.hwpxlib.writer.section_xml.object;

import kr.dogfoot.hwpxlib.commonstirngs.AttributeNames;
import kr.dogfoot.hwpxlib.commonstirngs.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.Curve;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.curve.CurveSegment;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterManager;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterSort;
import kr.dogfoot.hwpxlib.writer.section_xml.object.drawingobject.DrawingObjectWriter;

public class CurveWriter extends DrawingObjectWriter {
    public CurveWriter(ElementWriterManager elementWriterManager) {
        super(elementWriterManager);
    }

    @Override
    public ElementWriterSort sort() {
        return ElementWriterSort.Curve;
    }

    @Override
    public void write(HWPXObject object) {
        Curve curve = (Curve) object;
        switchObject(curve.switchObject());

        xsb()
                .openElement(ElementNames.hp_curve)
                .elementWriter(this);
        writeAttributeForDrawingObject(curve);

        writeChildrenForDrawingObject(curve);

        for (CurveSegment seg : curve.segs()) {
            seg(seg);
        }

        xsb().closeElement();
        releaseMe();
    }

    private void seg(CurveSegment seg) {
        xsb()
                .openElement(ElementNames.hp_seg)
                .attribute(AttributeNames.type, seg.type())
                .attribute(AttributeNames.x1, seg.x1())
                .attribute(AttributeNames.y1, seg.y1())
                .attribute(AttributeNames.x2, seg.x2())
                .attribute(AttributeNames.y2, seg.y2())
                .closeElement();
    }

    @Override
    protected void childInSwitch(HWPXObject child) {
        switch (child._objectType()) {
            case hp_seg:
                seg((CurveSegment) child);
                break;
            default:
                super.childInSwitch(child);
                break;
        }
    }
}
