package kr.dogfoot.hwpxlib.writer.section_xml.object;

import kr.dogfoot.hwpxlib.commonstrings.AttributeNames;
import kr.dogfoot.hwpxlib.commonstrings.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.baseobject.Point;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.Arc;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterManager;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterSort;
import kr.dogfoot.hwpxlib.writer.section_xml.object.drawingobject.DrawingObjectWriter;

public class ArcWriter extends DrawingObjectWriter {
    public ArcWriter(ElementWriterManager elementWriterManager) {
        super(elementWriterManager);
    }

    @Override
    public ElementWriterSort sort() {
        return ElementWriterSort.Arc;
    }

    @Override
    public void write(HWPXObject object) {
        Arc arc = (Arc) object;
        switchObject(arc.switchObject());

        xsb()
                .openElement(ElementNames.hp_arc)
                .elementWriter(this);
        writeAttributeForDrawingObject(arc);
        xsb().attribute(AttributeNames.type, arc.type());

        writeChildrenForDrawingObject(arc);

        if (arc.center() != null) {
            point(ElementNames.hc_center, arc.center());
        }

        if (arc.ax1() != null) {
            point(ElementNames.hc_ax1, arc.ax1());
        }

        if (arc.ax2() != null) {
            point(ElementNames.hc_ax2, arc.ax2());
        }
        writeChildrenForShapeObject(arc);

        xsb().closeElement();
        releaseMe();
    }

    @Override
    protected void childInSwitch(HWPXObject child) {
        switch (child._objectType()) {
            case hc_center:
                point(ElementNames.hc_center, (Point) child);
                break;
            case hc_ax1:
                point(ElementNames.hc_ax1, (Point) child);
                break;
            case hc_ax2:
                point(ElementNames.hc_ax2, (Point) child);
                break;
            default:
                super.childInSwitch(child);
                break;
        }
    }
}
