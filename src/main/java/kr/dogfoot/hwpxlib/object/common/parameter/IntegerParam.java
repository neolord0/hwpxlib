package kr.dogfoot.hwpxlib.object.common.parameter;

import kr.dogfoot.hwpxlib.object.common.ObjectType;

public class IntegerParam extends Param<IntegerParam> {
    private Integer value;

    public IntegerParam() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_integerParam;
    }

    public Integer value() {
        return value;
    }

    public void value(Integer value) {
        this.value = value;
    }

    public IntegerParam valueAnd(Integer value) {
        this.value = value;
        return this;
    }

    @Override
    public IntegerParam clone() {
        IntegerParam cloned = new IntegerParam();
        cloned.copyFrom(this);
        return cloned;
    }

    public void copyFrom(IntegerParam from) {
        this.value = from.value;

        super.copyFrom(from);
    }
}
