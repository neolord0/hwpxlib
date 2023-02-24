package kr.dogfoot.hwpxlib.reader.section_xml.control;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.common.baseobject.Point;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.ArcType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.Arc;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.drawingobject.DrawingObject;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.common.baseobject.XAndYReader;
import kr.dogfoot.hwpxlib.reader.section_xml.control.drawingobject.DrawingObjectReader;
import kr.dogfoot.hwpxlib.commonstirngs.AttributeNames;
import kr.dogfoot.hwpxlib.commonstirngs.ElementNames;
import org.xml.sax.Attributes;

public class ArcReader extends DrawingObjectReader {
    private Arc arc;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.Arc;
    }

    @Override
    public DrawingObject drawingObject() {
        return arc;
    }

    public void arc(Arc arc) {
        this.arc = arc;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.type:
                arc.type(ArcType.fromString(value));
                break;
            default:
                super.setAttribute(name, value);
                break;
        }
    }

    @Override
    public void childElement(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.hc_center:
                arc.createCenter();
                point(arc.center(), name, attrs);
                break;
            case ElementNames.hc_ax1:
                arc.createAx1();
                point(arc.ax1(), name, attrs);
                break;
            case ElementNames.hc_ax2:
                arc.createAx2();
                point(arc.ax2(), name, attrs);
                break;
            default:
                super.childElement(name, attrs);
                break;
        }
    }

    @Override
    public HWPXObject childElementInSwitch(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.hc_center:
                Point center = new Point(ObjectType.hc_center);
                point(center, name, attrs);
                return center;
            case ElementNames.hc_ax1:
                Point ax1 = new Point(ObjectType.hc_ax1);
                point(ax1, name, attrs);
                return ax1;
            case ElementNames.hc_ax2:
                Point ax2 = new Point(ObjectType.hc_ax2);
                point(ax2, name, attrs);
                return ax2;
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
        return arc;
    }
}
