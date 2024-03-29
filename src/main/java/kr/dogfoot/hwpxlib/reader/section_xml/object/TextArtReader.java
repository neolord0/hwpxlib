package kr.dogfoot.hwpxlib.reader.section_xml.object;

import kr.dogfoot.hwpxlib.commonstrings.AttributeNames;
import kr.dogfoot.hwpxlib.commonstrings.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectList;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.common.baseobject.Point;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.charpr.Outline;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.TextArt;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.drawingobject.DrawingObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.textart.TextArtPr;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.section_xml.object.drawingobject.DrawingObjectReader;
import kr.dogfoot.hwpxlib.reader.section_xml.object.etc.PointListReader;
import kr.dogfoot.hwpxlib.reader.section_xml.object.etc.TextArtPrReader;
import org.xml.sax.Attributes;

public class TextArtReader extends DrawingObjectReader {
    private TextArt textArt;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.TextArt;
    }

    @Override
    public DrawingObject drawingObject() {
        return textArt;
    }

    public void textArt(TextArt textArt) {
        this.textArt = textArt;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.text:
                textArt.text(value);
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
                textArt.createPt0();
                point(textArt.pt0(), name, attrs);
                break;
            case ElementNames.hc_pt1:
                textArt.createPt1();
                point(textArt.pt1(), name, attrs);
                break;
            case ElementNames.hc_pt2:
                textArt.createPt2();
                point(textArt.pt2(), name, attrs);
                break;
            case ElementNames.hc_pt3:
                textArt.createPt3();
                point(textArt.pt3(), name, attrs);
                break;
            case ElementNames.hp_textartPr:
                textArt.createTextartPr();
                textArtPr(textArt.textartPr(), name, attrs);
                break;
            case ElementNames.hp_outline:
                textArt.createOutline();
                outline(textArt.outline(), name, attrs);
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
            case ElementNames.hp_textartPr:
                TextArtPr textArtPr = new TextArtPr();
                textArtPr(textArtPr, name, attrs);
                return textArtPr;
            case ElementNames.hp_outline:
                Outline outline = new Outline();
                outline(textArt.outline(), name, attrs);
                return outline;
        }

        return super.childElementInSwitch(name, attrs);
    }

    private void textArtPr(TextArtPr textArtPr, String name, Attributes attrs) {
        ((TextArtPrReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.TextArtPr))
                .textArtPr(textArtPr);

        xmlFileReader().startElement(name, attrs);
    }

    private void outline(ObjectList<Point> outline, String name, Attributes attrs) {
        ((PointListReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.PointList))
                .pointList(outline);

        xmlFileReader().startElement(name, attrs);
    }

    @Override
    public SwitchableObject switchableObject() {
        return textArt;
    }
}
