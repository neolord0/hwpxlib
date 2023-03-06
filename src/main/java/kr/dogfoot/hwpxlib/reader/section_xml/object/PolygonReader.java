package kr.dogfoot.hwpxlib.reader.section_xml.object;

import kr.dogfoot.hwpxlib.commonstirngs.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.common.baseobject.Point;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.Polygon;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.drawingobject.DrawingObject;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.section_xml.object.drawingobject.DrawingObjectReader;
import org.xml.sax.Attributes;

public class PolygonReader extends DrawingObjectReader {
    private Polygon polygon;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.Polygon;
    }

    @Override
    public DrawingObject drawingObject() {
        return polygon;
    }

    public void polygon(Polygon polygon) {
        this.polygon = polygon;
    }

    @Override
    public void childElement(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.hc_pt:
                point(polygon.addNewPt(), name, attrs);
                break;
            default:
                super.childElement(name, attrs);
                break;
        }
    }

    @Override
    public HWPXObject childElementInSwitch(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.hc_pt:
                Point pt = new Point(ObjectType.hc_pt);
                point(pt, name, attrs);
                return pt;
        }

        return super.childElementInSwitch(name, attrs);
    }

    @Override
    public SwitchableObject switchableObject() {
        return polygon;
    }
}
