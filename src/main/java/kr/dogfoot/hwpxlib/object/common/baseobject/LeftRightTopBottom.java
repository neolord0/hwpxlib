package kr.dogfoot.hwpxlib.object.common.baseobject;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;

public abstract class LeftRightTopBottom<ChildType> extends HWPXObject {
    private Long left;
    private Long right;
    private Long top;
    private Long bottom;

    public Long left() {
        return left;
    }

    public void left(Long left) {
        this.left = left;
    }

    public ChildType leftAnd(Long left) {
        this.left = left;
        return (ChildType) this;
    }

    public Long right() {
        return right;
    }

    public void right(Long right) {
        this.right = right;
    }

    public ChildType rightAnd(Long right) {
        this.right = right;
        return (ChildType) this;
    }

    public Long top() {
        return top;
    }

    public void top(Long top) {
        this.top = top;
    }

    public ChildType topAnd(Long top) {
        this.top = top;
        return (ChildType) this;
    }

    public Long bottom() {
        return bottom;
    }

    public void bottom(Long bottom) {
        this.bottom = bottom;
    }

    public ChildType bottomAnd(Long bottom) {
        this.bottom = bottom;
        return (ChildType) this;
    }
}
