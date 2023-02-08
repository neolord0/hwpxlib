package kr.dogfoot.hwpxlib.object.common.parameter;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;

public class StringParam extends Param<StringParam> {
    private String value;

    public StringParam() {
    }

    @Override
    public ObjectType objectType() {
        return ObjectType.StringParam;
    }

    @Override
    public HWPXObject createChildWithElementName(String name) {
        return null;    // no child
    }

    public String value() {
        return value;
    }

    public void value(String value) {
        this.value = value;
    }

    public StringParam valueAnd(String value) {
        this.value = value;
        return this;
    }
}
