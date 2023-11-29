package kr.dogfoot.hwpxlib.object.common.baseobject;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;

public class XAndYFloat extends HWPXObject {
    private ObjectType _objectType;
    private Float x;
    private Float y;

    public XAndYFloat(ObjectType _objectType) {
        this._objectType = _objectType;
    }

    @Override
    public ObjectType _objectType() {
        return _objectType;
    }

    public Float x() {
        return x;
    }

    public void x(Float x) {
        this.x = x;
    }

    public XAndYFloat xAnd(Float x) {
        this.x = x;
        return this;
    }

    public Float y() {
        return y;
    }

    public void y(Float y) {
        this.y = y;
    }

    public XAndYFloat yAnd(Float y) {
        this.y = y;
        return this;
    }

    @Override
    public XAndYFloat clone() {
        XAndYFloat cloned = new XAndYFloat(_objectType);
        cloned.copyFrom(this);
        return cloned;
    }

    public void copyFrom(XAndYFloat from) {
        this.x = from.x;
        this.y = from.y;
    }
}
