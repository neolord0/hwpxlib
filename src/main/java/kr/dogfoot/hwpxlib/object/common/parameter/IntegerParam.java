package kr.dogfoot.hwpxlib.object.common.parameter;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;

public class IntegerParam extends Param<IntegerParam> {
    private Integer value;

    public IntegerParam() {
    }

    @Override
    public ObjectType objectType() {
        return ObjectType.IntegerParam;
    }

    @Override
    public HWPXObject createChildWithElementName(String name) {
        return null;    // no child
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
}
