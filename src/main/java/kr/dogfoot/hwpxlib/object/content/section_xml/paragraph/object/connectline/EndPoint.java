package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.connectline;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;

/**
 * 끝점
 */
public class EndPoint extends HWPXObject {
    /**
     * x 좌표, 단위는 hwpunit
     */
    private Integer x;
    /**
     * y 좌표, 단위는 hwpunit
     */
    private Integer y;
    /**
     * 참조 개체의 instid
     */
    private String subjectIDRef;
    /**
     * 연결선이 붙은 위치 (0 :  위쪽,  1:오른쪽, 2: 아래쪽, 3 왼쪽)
     */
    private Short subjectidx;

    public EndPoint() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hc_endPt;
    }

    public Integer x() {
        return x;
    }

    public void x(Integer x) {
        this.x = x;
    }

    public EndPoint xAnd(Integer x) {
        this.x = x;
        return this;
    }

    public Integer y() {
        return y;
    }

    public void y(Integer y) {
        this.y = y;
    }

    public EndPoint yAnd(Integer y) {
        this.y = y;
        return this;
    }

    public String subjectIDRef() {
        return subjectIDRef;
    }

    public void subjectIDRef(String subjectIDRef) {
        this.subjectIDRef = subjectIDRef;
    }

    public EndPoint subjectIDRefAnd(String subjectIDRef) {
        this.subjectIDRef = subjectIDRef;
        return this;
    }

    public Short subjectidx() {
        return subjectidx;
    }

    public void subjectidx(Short subjectidx) {
        this.subjectidx = subjectidx;
    }

    public EndPoint subjectidxAnd(Short subjectidx) {
        this.subjectidx = subjectidx;
        return this;
    }
}

