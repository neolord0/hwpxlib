package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.curve;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.CurveSegmentType;

public class CurveSegment extends HWPXObject {
    /**
     * 곡선 세그먼트 타입
     */
    private CurveSegmentType type;
    /**
     * x1 좌표, 단위는 hwpunit
     */
    private Integer x1;
    /**
     * y1 좌표, 단위는 hwpunit
     */
    private Integer y1;
    /**
     * x2 좌표, 단위는 hwpunit
     */
    private Integer x2;
    /**
     * y2 좌표, 단위는 hwpunit
     */
    private Integer y2;

    public CurveSegment() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_seg;
    }

    public CurveSegmentType type() {
        return type;
    }

    public void type(CurveSegmentType type) {
        this.type = type;
    }

    public CurveSegment typeAnd(CurveSegmentType type) {
        this.type = type;
        return this;
    }

    public Integer x1() {
        return x1;
    }

    public void x1(Integer x1) {
        this.x1 = x1;
    }

    public CurveSegment x1And(Integer x1) {
        this.x1 = x1;
        return this;
    }

    public Integer y1() {
        return y1;
    }

    public void y1(Integer y1) {
        this.y1 = y1;
    }

    public CurveSegment y1And(Integer y1) {
        this.y1 = y1;
        return this;
    }

    public Integer x2() {
        return x2;
    }

    public void x2(Integer x2) {
        this.x2 = x2;
    }

    public CurveSegment x2And(Integer x2) {
        this.x2 = x2;
        return this;
    }

    public Integer y2() {
        return y2;
    }

    public void y2(Integer y2) {
        this.y2 = y2;
    }

    public CurveSegment y2And(Integer y2) {
        this.y2 = y2;
        return this;
    }

    @Override
    public CurveSegment clone() {
        CurveSegment cloned = new CurveSegment();
        cloned.copyFrom(this);
        return cloned;
    }

    public void copyFrom(CurveSegment from) {
        this.type = from.type;
        this.x1 = from.x1;
        this.y1 = from.y1;
        this.x2 = from.x2;
        this.y2 = from.y2;
    }
}

