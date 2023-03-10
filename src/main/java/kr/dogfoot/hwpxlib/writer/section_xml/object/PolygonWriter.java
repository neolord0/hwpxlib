package kr.dogfoot.hwpxlib.writer.section_xml.object;

import kr.dogfoot.hwpxlib.commonstirngs.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.baseobject.Point;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.Polygon;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterManager;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterSort;
import kr.dogfoot.hwpxlib.writer.section_xml.object.drawingobject.DrawingObjectWriter;

public class PolygonWriter extends DrawingObjectWriter {
    public PolygonWriter(ElementWriterManager elementWriterManager) {
        super(elementWriterManager);
    }

    @Override
    public ElementWriterSort sort() {
        return ElementWriterSort.Polygon;
    }

    @Override
    public void write(HWPXObject object) {
        Polygon polygon = (Polygon) object;
        switchObject(polygon.switchObject());

        xsb()
                .openElement(ElementNames.hp_polygon)
                .elementWriter(this);
        writeAttributeForDrawingObject(polygon);

        writeChildrenForDrawingObject(polygon);

        for (Point pt : polygon.pts()) {
            point(ElementNames.hc_pt, pt);
        }

        writeChildrenForShapeObject(polygon);

        xsb().closeElement();
        releaseMe();
    }

    @Override
    protected void childInSwitch(HWPXObject child) {
        switch (child._objectType()) {
            case hc_pt:
                point(ElementNames.hc_pt, (Point) child);
                break;
            default:
                super.childInSwitch(child);
                break;
        }
    }
}
