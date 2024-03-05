package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapecomponent.ShapeComponent;

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
    public ObjectType _objectType() {
        return ObjectType.hp_container;
    }

    public int countOfChild() {
        return childList.size();
    }

    public ShapeComponent getChild(int index) {
        return childList.get(index);
    }

    public int getChildIndex(ShapeComponent child) {
        int count = childList.size();
        for (int index = 0; index < count; index++) {
            if (childList.get(index) == child) {
                return index;
            }
        }
        return -1;
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

    public TextArt addNewTextArt() {
        TextArt textArt = new TextArt();
        childList.add(textArt);
        return textArt;
    }

    public void insertChild(ShapeComponent child, int position) {
        childList.add(position, child);
    }

    public void removeChild(int position) {
        childList.remove(position);
    }

    public void removeChild(ShapeComponent child) {
        childList.remove(child);
    }

    public Iterable<ShapeComponent> children() {
        return childList;
    }

    @Override
    public Container clone() {
        Container cloned = new Container();
        cloned.copyFrom(this);
        return cloned;
    }

    public void copyFrom(Container from) {
        for (ShapeComponent child : from.childList) {
            childList.add((ShapeComponent) child.clone());
        }

        super.copyFrom(from);
    }
}
