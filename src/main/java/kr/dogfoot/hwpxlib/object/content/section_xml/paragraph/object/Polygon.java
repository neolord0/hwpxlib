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
    private final ArrayList<Point> ptList;

    public Polygon() {
        ptList = new ArrayList<Point>();
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_polygon;
    }

    public int countOfPt() {
        return ptList.size();
    }

    public Point getPt(int index) {
        return ptList.get(index);
    }

    public void addPt(Point pt) {
        ptList.add(pt);
    }

    public Point addNewPt() {
        Point pt = new Point(ObjectType.hc_pt);
        ptList.add(pt);
        return pt;
    }

    public void insertPt(Point pt, int position) {
        ptList.add(position, pt);
    }

    public void removePt(int position) {
        ptList.remove(position);
    }

    public Iterable<Point> pts() {
        return ptList;
    }
}
