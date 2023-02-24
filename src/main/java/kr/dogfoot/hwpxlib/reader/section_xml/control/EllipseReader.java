package kr.dogfoot.hwpxlib.reader.section_xml.control;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.common.baseobject.Point;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.ArcType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.Ellipse;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.drawingobject.DrawingObject;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.common.baseobject.XAndYReader;
import kr.dogfoot.hwpxlib.reader.section_xml.control.drawingobject.DrawingObjectReader;
import kr.dogfoot.hwpxlib.reader.util.ValueConvertor;
import kr.dogfoot.hwpxlib.commonstirngs.AttributeNames;
import kr.dogfoot.hwpxlib.commonstirngs.ElementNames;
import org.xml.sax.Attributes;

public class EllipseReader extends DrawingObjectReader {
    private Ellipse ellipse;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.Ellipse;
    }

    @Override
    public DrawingObject drawingObject() {
        return ellipse;
    }

    public void ellipse(Ellipse ellipse) {
        this.ellipse = ellipse;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.intervalDirty:
                ellipse.intervalDirty(ValueConvertor.toBoolean(value));
                break;
            case AttributeNames.hasArcPr:
                ellipse.hasArcPr(ValueConvertor.toBoolean(value));
                break;
            case AttributeNames.arcType:
                ellipse.arcType(ArcType.fromString(value));
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
                ellipse.createCenter();
                point(ellipse.center(), name, attrs);
                break;
            case ElementNames.hc_ax1:
                ellipse.createAx1();
                point(ellipse.ax1(), name, attrs);
                break;
            case ElementNames.hc_ax2:
                ellipse.createAx2();
                point(ellipse.ax2(), name, attrs);
                break;
            case ElementNames.hc_start1:
                ellipse.createStart1();
                point(ellipse.start1(), name, attrs);
                break;
            case ElementNames.hc_end1:
                ellipse.createEnd1();
                point(ellipse.end1(), name, attrs);
                break;
            case ElementNames.hc_start2:
                ellipse.createStart2();
                point(ellipse.start2(), name, attrs);
                break;
            case ElementNames.hc_end2:
                ellipse.createEnd2();
                point(ellipse.end2(), name, attrs);
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
            case ElementNames.hc_start1:
                Point start1 = new Point(ObjectType.hc_start1);
                point(start1, name, attrs);
                return start1;
            case ElementNames.hc_end1:
                Point end1 = new Point(ObjectType.hc_end1);
                point(end1, name, attrs);
                return end1;
            case ElementNames.hc_start2:
                Point start2 = new Point(ObjectType.hc_start2);
                point(start2, name, attrs);
                return start2;
            case ElementNames.hc_end2:
                Point end2 = new Point(ObjectType.hc_end2);
                point(end2, name, attrs);
                return end2;
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
        return ellipse;
    }
}
