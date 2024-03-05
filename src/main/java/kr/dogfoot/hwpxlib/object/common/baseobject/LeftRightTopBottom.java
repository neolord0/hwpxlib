package kr.dogfoot.hwpxlib.object.common.baseobject;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;

public class LeftRightTopBottom extends HWPXObject {
    private final ObjectType _objectType;
    private Long left;
    private Long right;
    private Long top;
    private Long bottom;

    public LeftRightTopBottom(ObjectType _objectType) {
        this._objectType = _objectType;
    }

    @Override
    public ObjectType _objectType() {
        return _objectType;
    }

    public Long left() {
        return left;
    }

    public void left(Long left) {
        this.left = left;
    }

    public LeftRightTopBottom leftAnd(Long left) {
        this.left = left;
        return this;
    }

    public Long right() {
        return right;
    }

    public void right(Long right) {
        this.right = right;
    }

    public LeftRightTopBottom rightAnd(Long right) {
        this.right = right;
        return this;
    }

    public Long top() {
        return top;
    }

    public void top(Long top) {
        this.top = top;
    }

    public LeftRightTopBottom topAnd(Long top) {
        this.top = top;
        return this;
    }

    public Long bottom() {
        return bottom;
    }

    public void bottom(Long bottom) {
        this.bottom = bottom;
    }

    public LeftRightTopBottom bottomAnd(Long bottom) {
        this.bottom = bottom;
        return this;
    }

    public void set(Long left, Long right, Long top, Long bottom) {
        this.left = left;
        this.right = right;
        this.top = top;
        this.bottom = bottom;
    }

    @Override
    public LeftRightTopBottom clone() {
        LeftRightTopBottom cloned = new LeftRightTopBottom(_objectType);
        cloned.copyFrom(this);
        return cloned;
    }

    public void copyFrom(LeftRightTopBottom from) {
        this.left = from.left;
        this.right = from.right;
        this.top = from.top;
        this.bottom = from.bottom;
    }
}
