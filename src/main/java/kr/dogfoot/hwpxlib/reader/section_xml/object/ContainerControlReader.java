package kr.dogfoot.hwpxlib.reader.section_xml.object;

import kr.dogfoot.hwpxlib.commonstirngs.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.*;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapecomponent.ShapeComponent;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.section_xml.object.shapecomponent.ShapeComponentReader;
import org.xml.sax.Attributes;

public class ContainerControlReader extends ShapeComponentReader {
    private Container container;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.ContainerControl;
    }

    @Override
    public ShapeComponent shapeComponent() {
        return container;
    }

    public void container(Container container) {
        this.container = container;
    }

    @Override
    public void childElement(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.hp_pic:
                pic(container.addNewPicture(), name, attrs);
                break;
            case ElementNames.hp_ole:
                ole(container.addNewOLE(), name, attrs);
                break;
            case ElementNames.hp_container:
                container(container.addNewContainer(), name, attrs);
                break;
            case ElementNames.hp_line:
                line(container.addNewLine(), name, attrs);
                break;
            case ElementNames.hp_rect:
                rect(container.addNewRectangle(), name, attrs);
                break;
            case ElementNames.hp_ellipse:
                ellipse(container.addNewEllipse(), name, attrs);
                break;
            case ElementNames.hp_arc:
                arc(container.addNewArc(), name, attrs);
                break;
            case ElementNames.hp_polygon:
                polygon(container.addNewPolygon(), name, attrs);
                break;
            case ElementNames.hp_curve:
                curve(container.addNewCurve(), name, attrs);
                break;
            case ElementNames.hp_connectLine:
                connectLine(container.addNewConnectLine(), name, attrs);
                break;
            case ElementNames.hp_textart:
                textArt(container.addNewTextArt(), name, attrs);
                break;
            default:
                super.childElement(name, attrs);
        }
    }

    @Override
    public HWPXObject childElementInSwitch(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.hp_pic:
                Picture picture = new Picture();
                pic(picture, name, attrs);
                return picture;
            case ElementNames.hp_ole:
                OLE ole = new OLE();
                ole(ole, name, attrs);
                return ole;
            case ElementNames.hp_container:
                Container container = new Container();
                container(container, name, attrs);
                return container;
            case ElementNames.hp_line:
                Line line = new Line();
                line(line, name, attrs);
                return line;
            case ElementNames.hp_rect:
                Rectangle rectangle = new Rectangle();
                rect(rectangle, name, attrs);
                return rectangle;
            case ElementNames.hp_ellipse:
                Ellipse ellipse = new Ellipse();
                ellipse(ellipse, name, attrs);
                return ellipse;
            case ElementNames.hp_arc:
                Arc arc = new Arc();
                arc(arc, name, attrs);
                return arc;
            case ElementNames.hp_polygon:
                Polygon polygon = new Polygon();
                polygon(polygon, name, attrs);
                return polygon;
            case ElementNames.hp_curve:
                Curve curve = new Curve();
                curve(curve, name, attrs);
                return curve;
            case ElementNames.hp_connectLine:
                ConnectLine connectLine = new ConnectLine();
                connectLine(connectLine, name, attrs);
                return connectLine;
            case ElementNames.hp_textart:
                TextArt textArt = new TextArt();
                textArt(textArt, name, attrs);
                return textArt;
        }
        return childElementInSwitch(name, attrs);
    }

    private void pic(Picture picture, String name, Attributes attrs) {
        ((PictureReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.Pic))
                .picture(picture);

        xmlFileReader().startElement(name, attrs);
    }


    private void container(Container container, String name, Attributes attrs) {
        ((ContainerControlReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.ContainerControl))
                .container(container);

        xmlFileReader().startElement(name, attrs);
    }

    private void ole(OLE ole, String name, Attributes attrs) {
        ((OLEReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.OLE))
                .ole(ole);

        xmlFileReader().startElement(name, attrs);
    }

    private void line(Line line, String name, Attributes attrs) {
        ((LineReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.Line))
                .line(line);

        xmlFileReader().startElement(name, attrs);
    }

    private void rect(Rectangle rectangle, String name, Attributes attrs) {
        ((RectangleReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.Rect))
                .rectangle(rectangle);

        xmlFileReader().startElement(name, attrs);
    }

    private void ellipse(Ellipse ellipse, String name, Attributes attrs) {
        ((EllipseReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.Ellipse))
                .ellipse(ellipse);

        xmlFileReader().startElement(name, attrs);
    }

    private void arc(Arc arc, String name, Attributes attrs) {
        ((ArcReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.Arc))
                .arc(arc);

        xmlFileReader().startElement(name, attrs);
    }

    private void polygon(Polygon polygon, String name, Attributes attrs) {
        ((PolygonReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.Polygon))
                .polygon(polygon);

        xmlFileReader().startElement(name, attrs);
    }

    private void curve(Curve curve, String name, Attributes attrs) {
        ((CurveReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.Curve))
                .curve(curve);

        xmlFileReader().startElement(name, attrs);
    }

    private void connectLine(ConnectLine connectLine, String name, Attributes attrs) {
        ((ConnectLineReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.ConnectLine))
                .connectLine(connectLine);

        xmlFileReader().startElement(name, attrs);
    }

    private void textArt(TextArt textArt, String name, Attributes attrs) {
        ((TextArtReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.TextArt))
                .textArt(textArt);

        xmlFileReader().startElement(name, attrs);
    }

    @Override
    public SwitchableObject switchableObject() {
        return container;
    }
}
