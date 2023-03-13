package kr.dogfoot.hwpxlib.writer.section_xml.object;

import kr.dogfoot.hwpxlib.commonstrings.AttributeNames;
import kr.dogfoot.hwpxlib.commonstrings.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.baseobject.Point;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.Ellipse;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterManager;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterSort;
import kr.dogfoot.hwpxlib.writer.section_xml.object.drawingobject.DrawingObjectWriter;

public class EllipseWriter extends DrawingObjectWriter {
    public EllipseWriter(ElementWriterManager elementWriterManager) {
        super(elementWriterManager);
    }

    @Override
    public ElementWriterSort sort() {
        return ElementWriterSort.Ellipse;
    }

    @Override
    public void write(HWPXObject object) {
        Ellipse ellipse = (Ellipse) object;
        switchObject(ellipse.switchObject());

        xsb()
                .openElement(ElementNames.hp_ellipse)
                .elementWriter(this);
        writeAttributeForDrawingObject(ellipse);
        xsb()
                .attribute(AttributeNames.intervalDirty, ellipse.intervalDirty())
                .attribute(AttributeNames.hasArcPr, ellipse.hasArcPr())
                .attribute(AttributeNames.arcType, ellipse.arcType());

        writeChildrenForDrawingObject(ellipse);

        if (ellipse.center() != null) {
            point(ElementNames.hc_center, ellipse.center());
        }

        if (ellipse.ax1() != null) {
            point(ElementNames.hc_ax1, ellipse.ax1());
        }

        if (ellipse.ax2() != null) {
            point(ElementNames.hc_ax2, ellipse.ax2());
        }

        if (ellipse.start1() != null) {
            point(ElementNames.hc_start1, ellipse.start1());
        }

        if (ellipse.end1() != null) {
            point(ElementNames.hc_end1, ellipse.end1());
        }

        if (ellipse.start2() != null) {
            point(ElementNames.hc_start2, ellipse.start2());
        }

        if (ellipse.end2() != null) {
            point(ElementNames.hc_end2, ellipse.end2());
        }

        writeChildrenForShapeObject(ellipse);

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
            case hc_start1:
                point(ElementNames.hc_start1, (Point) child);
                break;
            case hc_start2:
                point(ElementNames.hc_start2, (Point) child);
                break;
            case hc_end1:
                point(ElementNames.hc_end1, (Point) child);
                break;
            case hc_end2:
                point(ElementNames.hc_end2, (Point) child);
                break;
            default:
                super.childInSwitch(child);
                break;
        }
    }
}
