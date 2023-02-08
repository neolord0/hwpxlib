package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.baseobject.Point;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.drawingobject.DrawingObject;

import java.util.ArrayList;

/**
 * 다각형
 */
public class Polygon extends DrawingObject<Polygon> {
    /**
     * 다각형 상에 좌표
     */
    private final ArrayList<Point> pointList;

    public Polygon() {
        pointList = new ArrayList<Point>();
    }

    @Override
    public ObjectType objectType() {
        return ObjectType.Polygon;
    }

    public int countOfPoint() {
        return pointList.size();
    }

    public Point getPoint(int index) {
        return pointList.get(index);
    }

    public void addPoint(Point point) {
        pointList.add(point);
    }

    public Point addNewPoint() {
        Point point = new Point(ObjectType.Pt);
        pointList.add(point);
        return point;
    }

    public void insertPoint(Point point, int position) {
        pointList.add(position, point);
    }

    public void removePoint(int position) {
        pointList.remove(position);
    }

    public Iterable<Point> points() {
        return pointList;
    }
}
