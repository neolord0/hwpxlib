package kr.dogfoot.hwpxlib.object.common.parameter;

import kr.dogfoot.hwpxlib.object.common.ObjectType;

public class FloatParam extends Param<FloatParam> {
    private Float value;

    public FloatParam() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_floatParam;
    }

    public Float value() {
        return value;
    }

    public void value(Float value) {
        this.value = value;
    }

    public FloatParam valueAnd(Float value) {
        this.value = value;
        return this;
    }

    @Override
    public FloatParam clone() {
        FloatParam cloned = new FloatParam();
        cloned.copyFrom(this);
        return cloned;
    }

    public void copyFrom(FloatParam from) {
        this.value = from.value;

        super.copyFrom(from);
    }
}
