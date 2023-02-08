package kr.dogfoot.hwpxlib.object.root;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;

/**
 * 캐럿 위치
 */
public class CaretPosition extends HWPXObject {
    /**
     * 문단 리스트 아이디
     */
    private Integer listIDRef;
    /**
     * 문단 아이디
     */
    private Integer paraIDRef;
    /**
     * 문단 내부에 글자 위치
     */
    private Integer pos;

    public CaretPosition() {
    }

    @Override
    public ObjectType objectType() {
        return ObjectType.CaretPosition;
    }

    public Integer listIDRef() {
        return listIDRef;
    }

    public void listIDRef(Integer listIDRef) {
        this.listIDRef = listIDRef;
    }

    public CaretPosition listIDRefAnd(Integer listIDRef) {
        this.listIDRef = listIDRef;
        return this;
    }

    public Integer paraIDRef() {
        return paraIDRef;
    }

    public void paraIDRef(Integer paraIDRef) {
        this.paraIDRef = paraIDRef;
    }

    public CaretPosition paraIDRefAnd(Integer paraIDRef) {
        this.paraIDRef = paraIDRef;
        return this;
    }

    public Integer pos() {
        return pos;
    }

    public void pos(Integer pos) {
        this.pos = pos;
    }

    public CaretPosition posAnd(Integer pos) {
        this.pos = pos;
        return this;
    }
}
