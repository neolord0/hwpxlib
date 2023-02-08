package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.baseobject.Point;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.ArcType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.drawingobject.DrawingObject;

/**
 * 타원
 */
public class Ellipse extends DrawingObject<Ellipse> {
    /**
     * 호로 바뀌었을 떄, interval 을 다시 계산해야 할 필요가 있는지 여부
     */
    private Boolean intervalDirty;
    /**
     * 호로 바뀌었는지 여부
     */
    private Boolean hasArcPr;
    /**
     * 호의 종류
     */
    private ArcType arcType;
    /**
     * 중심 좌표
     */
    private Point center;
    /**
     * 제1축 좌표
     */
    private Point ax1;
    /**
     * 제2축 좌표
     */
    private Point ax2;
    /**
     * 시작 지점1 좌표
     */
    private Point start1;
    /**
     * 시작 지점2 좌표
     */
    private Point start2;
    /**
     * 끝 지점1 좌표
     */
    private Point end1;
    /**
     * 끝 지점2 좌표
     */
    private Point end2;

    public Ellipse() {
    }

    @Override
    public ObjectType objectType() {
        return ObjectType.Ellipse;
    }

    public Boolean intervalDirty() {
        return intervalDirty;
    }

    public void intervalDirty(Boolean intervalDirty) {
        this.intervalDirty = intervalDirty;
    }

    public Ellipse intervalDirtyAnd(Boolean intervalDirty) {
        this.intervalDirty = intervalDirty;
        return this;
    }

    public Boolean hasArcPr() {
        return hasArcPr;
    }

    public void hasArcPr(Boolean hasArcPr) {
        this.hasArcPr = hasArcPr;
    }

    public Ellipse hasArcPrAnd(Boolean hasArcPr) {
        this.hasArcPr = hasArcPr;
        return this;
    }

    public ArcType arcType() {
        return arcType;
    }

    public void arcType(ArcType arcType) {
        this.arcType = arcType;
    }

    public Ellipse arcTypeAnd(ArcType arcType) {
        this.arcType = arcType;
        return this;
    }

    public Point center() {
        return center;
    }

    public void createCenter() {
        center = new Point(ObjectType.Center);
    }

    public void removeCenter() {
        center = null;
    }

    public Point ax1() {
        return ax1;
    }

    public void createAx1() {
        ax1 = new Point(ObjectType.Ax1);
    }

    public void removeAx1() {
        ax1 = null;
    }

    public Point ax2() {
        return ax2;
    }

    public void createAx2() {
        ax2 = new Point(ObjectType.Ax2);
    }

    public void removeAx2() {
        ax2 = null;
    }

    public Point start1() {
        return start1;
    }

    public void createStart1() {
        start1 = new Point(ObjectType.Start1);
    }

    public void removeStart1() {
        start1 = null;
    }

    public Point start2() {
        return start2;
    }

    public void createStart2() {
        start2 = new Point(ObjectType.Start2);
    }

    public void removeStart2() {
        start2 = null;
    }

    public Point end1() {
        return end1;
    }

    public void createEnd1() {
        end1 = new Point(ObjectType.End1);
    }

    public void removeEnd1() {
        end1 = null;
    }

    public Point end2() {
        return end2;
    }

    public void createEnd2() {
        end2 = new Point(ObjectType.End2);
    }

    public void removeEnd2() {
        end2 = null;
    }
}
