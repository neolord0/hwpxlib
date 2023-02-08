package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapecomponent.CurrentSize;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapecomponent.ShapeComponent;
import org.omg.PortableServer.POA;

import java.util.ArrayList;

/**
 * 묶음
 */
public class Container extends ShapeComponent<Container> {
    private final ArrayList<ShapeComponent> childList;

    public Container() {
        childList = new ArrayList<ShapeComponent>();
    }

    @Override
    public ObjectType objectType() {
        return ObjectType.Container;
    }

    @Override
    public HWPXObject createChildWithElementName(String name) {
        if (ObjectType.Container.equalElementName(name)) {
            return new Container();
        } else if (ObjectType.Line.equalElementName(name)) {
            return new Line();
        } else if (ObjectType.Rect.equalElementName(name)) {
            return new Rectangle();
        } else if (ObjectType.Ellipse.equalElementName(name)) {
            return new Ellipse();
        } else if (ObjectType.Arc.equalElementName(name)) {
            return new Arc();
        } else if (ObjectType.Polygon.equalElementName(name)) {
            return new Polygon();
        } else if (ObjectType.Curve.equalElementName(name)) {
            return new Curve();
        } else if (ObjectType.ConnectLine.equalElementName(name)) {
            return new ConnectLine();
        } else if (ObjectType.Pic.equalElementName(name)) {
            return new Picture();
        } else if (ObjectType.OLE.equalElementName(name)) {
            return new OLE();
        }
        return super.createChildWithElementName(name);
    }

    public int countOfChild() {
        return childList.size();
    }

    public ShapeComponent getChild(int index) {
        return childList.get(index);
    }

    public void addChild(ShapeComponent child) {
        childList.add(child);
    }

    public Container addNewContainer() {
        Container container = new Container();
        childList.add(container);
        return container;
    }

    public Line addNewLine() {
        Line line = new Line();
        childList.add(line);
        return line;
    }

    public Rectangle addNewRectangle() {
        Rectangle rectangle = new Rectangle();
        childList.add(rectangle);
        return rectangle;
    }

    public Ellipse addNewEllipse() {
        Ellipse ellipse = new Ellipse();
        childList.add(ellipse);
        return ellipse;
    }

    public Arc addNewArc() {
        Arc arc = new Arc();
        childList.add(arc);
        return arc;
    }

    public Polygon addNewPolygon() {
        Polygon polygon = new Polygon();
        childList.add(polygon);
        return polygon;
    }

    public Curve addNewCurve() {
        Curve curve = new Curve();
        childList.add(curve);
        return curve;
    }

    public ConnectLine addNewConnectLine() {
        ConnectLine connectLine = new ConnectLine();
        childList.add(connectLine);
        return connectLine;
    }

    public Picture addNewPicture() {
        Picture picture = new Picture();
        childList.add(picture);
        return picture;
    }

    public OLE addNewOLE() {
        OLE ole = new OLE();
        childList.add(ole);
        return ole;
    }

    public void insertChild(ShapeComponent child, int position) {
        childList.add(position, child);
    }

    public void removeChild(int position) {
        childList.remove(position);
    }

    public Iterable<ShapeComponent> children() {
        return childList;
    }
}
