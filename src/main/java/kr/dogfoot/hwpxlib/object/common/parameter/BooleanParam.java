package kr.dogfoot.hwpxlib.object.common.parameter;

import kr.dogfoot.hwpxlib.object.common.ObjectType;

public class BooleanParam extends Param<BooleanParam> {
    private Boolean value;

    public BooleanParam() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_booleanParam;
    }

    public Boolean value() {
        return value;
    }

    public void value(Boolean value) {
        this.value = value;
    }

    public BooleanParam valueAnd(Boolean value) {
        this.value = value;
        return this;
    }

    @Override
    public BooleanParam clone() {
        BooleanParam cloned = new BooleanParam();
        cloned.copyFrom(this);
        return cloned;
    }

    public void copyFrom(BooleanParam from) {
        this.value = from.value;

        super.copyFrom(from);
    }
}
