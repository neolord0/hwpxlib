package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.connectline;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;

/**
 * 시작점
 */
public class ConnectLinePoint extends HWPXObject {
    private final ObjectType objectType;;
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

    public ConnectLinePoint(ObjectType objectType) {
        this.objectType = objectType;
    }

    @Override
    public ObjectType _objectType() {
        return objectType;
    }

    public Integer x() {
        return x;
    }

    public void x(Integer x) {
        this.x = x;
    }

    public ConnectLinePoint xAnd(Integer x) {
        this.x = x;
        return this;
    }

    public Integer y() {
        return y;
    }

    public void y(Integer y) {
        this.y = y;
    }

    public ConnectLinePoint yAnd(Integer y) {
        this.y = y;
        return this;
    }

    public String subjectIDRef() {
        return subjectIDRef;
    }

    public void subjectIDRef(String subjectIDRef) {
        this.subjectIDRef = subjectIDRef;
    }

    public ConnectLinePoint subjectIDRefAnd(String subjectIDRef) {
        this.subjectIDRef = subjectIDRef;
        return this;
    }

    public Short subjectidx() {
        return subjectidx;
    }

    public void subjectidx(Short subjectidx) {
        this.subjectidx = subjectidx;
    }

    public ConnectLinePoint subjectidxAnd(Short subjectidx) {
        this.subjectidx = subjectidx;
        return this;
    }
}
