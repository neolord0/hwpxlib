package kr.dogfoot.hwpxlib.object.common.baseobject;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;

public class Point extends HWPXObject {
    private final ObjectType _objectType;
    private Long x;
    private Long y;

    public Point() {
        _objectType = ObjectType.hc_pt;
    }

    public Point(ObjectType objectType) {
        this._objectType = objectType;
    }

    @Override
    public ObjectType _objectType() {
        return _objectType;
    }

    public Long x() {
        return x;
    }

    public void x(Long x) {
        this.x = x;
    }

    public Point xAnd(Long x) {
        this.x = x;
        return this;
    }

    public Long y() {
        return y;
    }

    public void y(Long y) {
        this.y = y;
    }

    public Point yAnd(Long y) {
        this.y = y;
        return this;
    }

    @Override
    public Point clone() {
        Point cloned = new Point(_objectType);
        cloned.copyFrom(this);
        return cloned;
    }

    public void copyFrom(Point from) {
        this.x = from.x;
        this.y = from.y;
    }
}

