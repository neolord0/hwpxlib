package kr.dogfoot.hwpxlib.object.common.parameter;

import kr.dogfoot.hwpxlib.object.common.ObjectType;

public class FloatParam extends Param<FloatParam> {
    private Float value;

    public FloatParam() {
    }

    @Override
    public ObjectType objectType() {
        return ObjectType.FloatParam;
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
}
