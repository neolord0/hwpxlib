package kr.dogfoot.hwpxlib.reader.section_xml.control;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.common.baseobject.Point;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.Rectangle;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.drawingobject.DrawingObject;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.common.baseobject.XAndYReader;
import kr.dogfoot.hwpxlib.reader.section_xml.control.drawingobject.DrawingObjectReader;
import kr.dogfoot.hwpxlib.reader.util.ValueConvertor;
import kr.dogfoot.hwpxlib.commonstirngs.AttributeNames;
import kr.dogfoot.hwpxlib.commonstirngs.ElementNames;
import org.xml.sax.Attributes;

public class RectangleReader extends DrawingObjectReader {
    private Rectangle rectangle;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.Rect;
    }

    @Override
    public DrawingObject drawingObject() {
        return rectangle;
    }

    public void rectangle(Rectangle rectangle) {
        this.rectangle = rectangle;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.ratio:
                rectangle.ratio(ValueConvertor.toShort(value));
                break;
            default:
                super.setAttribute(name, value);
                break;
        }
    }

    @Override
    public void childElement(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.hc_pt0:
                rectangle.createPt0();
                point(rectangle.pt0(), name, attrs);
                break;
            case ElementNames.hc_pt1:
                rectangle.createPt1();
                point(rectangle.pt1(), name, attrs);
                break;
            case ElementNames.hc_pt2:
                rectangle.createPt2();
                point(rectangle.pt2(), name, attrs);
                break;
            case ElementNames.hc_pt3:
                rectangle.createPt3();
                point(rectangle.pt3(), name, attrs);
                break;
            default:
                super.childElement(name, attrs);
                break;
        }
    }

    @Override
    public HWPXObject childElementInSwitch(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.hc_pt0:
                Point pt0 = new Point(ObjectType.hc_pt0);
                point(pt0, name, attrs);
                return pt0;
            case ElementNames.hc_pt1:
                Point pt1 = new Point(ObjectType.hc_pt1);
                point(pt1, name, attrs);
                return pt1;
            case ElementNames.hc_pt2:
                Point pt2 = new Point(ObjectType.hc_pt2);
                point(pt2, name, attrs);
                return pt2;
            case ElementNames.hc_pt3:
                Point pt3 = new Point(ObjectType.hc_pt3);
                point(pt3, name, attrs);
                return pt3;
        }

        return super.childElementInSwitch(name, attrs);
    }

    private void point(Point pt, String name, Attributes attrs) {
        ((XAndYReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.XAndY))
                .xAndY(pt);

        xmlFileReader().startElement(name, attrs);
    }

    @Override
    public SwitchableObject switchableObject() {
        return rectangle;
    }
}
