package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.baseobject.Point;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.ArcType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.drawingobject.DrawingObject;

/**
 * 호
 */
public class Arc extends DrawingObject<Arc> {
    /**
     * 호의 종류
     */
    private ArcType type;
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

    public Arc() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_arc;
    }

    public ArcType type() {
        return type;
    }

    public void type(ArcType type) {
        this.type = type;
    }

    public Arc typeAnd(ArcType type) {
        this.type = type;
        return this;
    }

    public Point center() {
        return center;
    }

    public void createCenter() {
        center = new Point(ObjectType.hc_center);
    }

    public void removeCenter() {
        center = null;
    }

    public Point ax1() {
        return ax1;
    }

    public void createAx1() {
        ax1 = new Point(ObjectType.hc_ax1);
    }

    public void removeAx1() {
        ax1 = null;
    }

    public Point ax2() {
        return ax2;
    }

    public void createAx2() {
        ax2 = new Point(ObjectType.hc_ax2);
    }

    public void removeAx2() {
        ax2 = null;
    }
}
