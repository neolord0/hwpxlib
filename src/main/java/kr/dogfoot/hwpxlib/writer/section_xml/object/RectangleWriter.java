package kr.dogfoot.hwpxlib.writer.section_xml.object;

import kr.dogfoot.hwpxlib.commonstirngs.AttributeNames;
import kr.dogfoot.hwpxlib.commonstirngs.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.baseobject.Point;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.Rectangle;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterManager;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterSort;
import kr.dogfoot.hwpxlib.writer.section_xml.object.drawingobject.DrawingObjectWriter;

public class RectangleWriter extends DrawingObjectWriter {
    public RectangleWriter(ElementWriterManager elementWriterManager) {
        super(elementWriterManager);
    }

    @Override
    public ElementWriterSort sort() {
        return ElementWriterSort.Rectangle;
    }

    @Override
    public void write(HWPXObject object) {
        Rectangle rectangle = (Rectangle) object;
        switchObject(rectangle.switchObject());

        xsb()
                .openElement(ElementNames.hp_rect)
                .elementWriter(this);
        writeAttributeForDrawingObject(rectangle);
        xsb().attribute(AttributeNames.ratio, rectangle.ratio());

        writeChildrenForDrawingObject(rectangle);

        if (rectangle.pt0() != null) {
            point(ElementNames.hc_pt0, rectangle.pt0());
        }

        if (rectangle.pt1() != null) {
            point(ElementNames.hc_pt1, rectangle.pt1());
        }

        if (rectangle.pt2() != null) {
            point(ElementNames.hc_pt2, rectangle.pt2());
        }

        if (rectangle.pt3() != null) {
            point(ElementNames.hc_pt3, rectangle.pt3());
        }

        writeChildrenForShapeObject(rectangle);

        xsb().closeElement();
        releaseMe();
    }

    @Override
    protected void childInSwitch(HWPXObject child) {
        switch (child._objectType()) {
            case hc_pt0:
                point(ElementNames.hc_pt0, (Point) child);
                break;
            case hc_pt1:
                point(ElementNames.hc_pt1, (Point) child);
                break;
            case hc_pt2:
                point(ElementNames.hc_pt2, (Point) child);
                break;
            case hc_pt3:
                point(ElementNames.hc_pt3, (Point) child);
                break;
            default:
                super.childInSwitch(child);
                break;
        }
    }
}
