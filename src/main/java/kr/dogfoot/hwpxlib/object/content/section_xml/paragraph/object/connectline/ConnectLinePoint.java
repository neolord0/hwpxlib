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
    private Long x;
    /**
     * y 좌표, 단위는 hwpunit
     */
    private Long y;
    /**
     * 참조 개체의 instid
     */
    private String subjectIDRef;
    /**
     * 연결선이 붙은 위치 (0 :  위쪽,  1:오른쪽, 2: 아래쪽, 3 왼쪽)
     */
    private Short subjectIdx;

    public ConnectLinePoint(ObjectType objectType) {
        this.objectType = objectType;
    }

    @Override
    public ObjectType _objectType() {
        return objectType;
    }

    public Long x() {
        return x;
    }

    public void x(Long x) {
        this.x = x;
    }

    public ConnectLinePoint xAnd(Long x) {
        this.x = x;
        return this;
    }

    public Long y() {
        return y;
    }

    public void y(Long y) {
        this.y = y;
    }

    public ConnectLinePoint yAnd(Long y) {
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

    public Short subjectIdx() {
        return subjectIdx;
    }

    public void subjectIdx(Short subjectIdx) {
        this.subjectIdx = subjectIdx;
    }

    public ConnectLinePoint subjectIdxAnd(Short subjectIdx) {
        this.subjectIdx = subjectIdx;
        return this;
    }
}
