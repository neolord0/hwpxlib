package kr.dogfoot.hwpxlib.object.common.parameter;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;

public class BooleanParam extends Param<BooleanParam> {
    private Boolean value;

    public BooleanParam() {
    }

    @Override
    public ObjectType objectType() {
        return ObjectType.BooleanParam;
    }

    @Override
    public HWPXObject createChildWithElementName(String name) {
        return null;    // no child
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
}
