package kr.dogfoot.hwpxlib.object.common.baseobject;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;

public abstract class LeftRightTopBottom<ChildType> extends HWPXObject {
    private Integer left;
    private Integer right;
    private Integer top;
    private Integer bottom;

    public Integer left() {
        return left;
    }

    public void left(Integer left) {
        this.left = left;
    }

    public ChildType leftAnd(Integer left) {
        this.left = left;
        return (ChildType) this;
    }

    public Integer right() {
        return right;
    }

    public void right(Integer right) {
        this.right = right;
    }

    public ChildType rightAnd(Integer right) {
        this.right = right;
        return (ChildType) this;
    }

    public Integer top() {
        return top;
    }

    public void top(Integer top) {
        this.top = top;
    }

    public ChildType topAnd(Integer top) {
        this.top = top;
        return (ChildType) this;
    }

    public Integer bottom() {
        return bottom;
    }

    public void bottom(Integer bottom) {
        this.bottom = bottom;
    }

    public ChildType bottomAnd(Integer bottom) {
        this.bottom = bottom;
        return (ChildType) this;
    }
}
