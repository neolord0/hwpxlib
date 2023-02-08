package kr.dogfoot.hwpxlib.object.common.baseobject;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.ValueUnit2;

public abstract class ValueAndUnit<ChildType> extends HWPXObject {
    private Integer value;
    private ValueUnit2 unit;

    public Integer value() {
        return value;
    }

    public void value(Integer value) {
        this.value = value;
    }

    public ChildType valueAnd(Integer value) {
        this.value = value;
        return (ChildType) this;
    }

    public ValueUnit2 unit() {
        return unit;
    }

    public void unit(ValueUnit2 unit) {
        this.unit = unit;
    }

    public ChildType unitAnd(ValueUnit2 unit) {
        this.unit = unit;
        return (ChildType) this;
    }
}
