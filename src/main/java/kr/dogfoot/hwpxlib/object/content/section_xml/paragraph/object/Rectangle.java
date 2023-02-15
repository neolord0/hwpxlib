package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.baseobject.Point;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.drawingobject.DrawingObject;

/**
 * 사각형
 */
public class Rectangle extends DrawingObject<Rectangle> {
    /**
     * 둥근 사각형 비율, 0:직각, 20: 둥근 모양, 50: 반원
     */
    private Short ratio;
    /**
     * 첫번째 좌표, 좌측 상단
     */
    private Point pt0;
    /**
     * 두번째 좌표, 우측 상단
     */
    private Point pt1;
    /**
     * 세번째 좌표, 우측 하단
     */
    private Point pt2;
    /**
     * 네번째 좌표, 좌측 하단
     */
    private Point pt3;

    public Rectangle() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_rect;
    }

    public Short ratio() {
        return ratio;
    }

    public void ratio(Short ratio) {
        this.ratio = ratio;
    }

    public Rectangle ratioAnd(Short ratio) {
        this.ratio = ratio;
        return this;
    }

    public Point pt0() {
        return pt0;
    }

    public void createPt0() {
        pt0 = new Point(ObjectType.hc_pt0);
    }

    public void removePt0() {
        pt0 = null;
    }

    public Point pt1() {
        return pt1;
    }

    public void createPt1() {
        pt1 = new Point(ObjectType.hc_pt1);
    }

    public void removePt1() {
        pt1 = null;
    }

    public Point pt2() {
        return pt2;
    }

    public void createPt2() {
        pt2 = new Point(ObjectType.hc_pt2);
    }

    public void removePt2() {
        pt2 = null;
    }

    public Point pt3() {
        return pt3;
    }

    public void createPt3() {
        pt3 = new Point(ObjectType.hc_pt3);
    }

    public void removePt3() {
        pt3 = null;
    }
}
