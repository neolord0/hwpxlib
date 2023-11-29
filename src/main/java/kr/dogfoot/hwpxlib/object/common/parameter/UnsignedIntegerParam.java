package kr.dogfoot.hwpxlib.object.common.parameter;

import kr.dogfoot.hwpxlib.object.common.ObjectType;

public class UnsignedIntegerParam extends Param<IntegerParam> {
    private Long value;

    public UnsignedIntegerParam() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_unsignedintegerParam;
    }

    public Long value() {
        return value;
    }

    public void value(Long value) {
        this.value = value;
    }

    public UnsignedIntegerParam valueAnd(Long value) {
        this.value = value;
        return this;
    }

    @Override
    public UnsignedIntegerParam clone() {
        UnsignedIntegerParam cloned = new UnsignedIntegerParam();
        cloned.copyFrom(this);
        return cloned;
    }

    public void copyFrom(UnsignedIntegerParam from) {
        this.value = from.value;

        super.copyFrom(from);
    }
}
