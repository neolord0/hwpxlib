package kr.dogfoot.hwpxlib.object.common.baseobject;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.ValueUnit2;

public class ValueAndUnit extends HWPXObject {
    private final ObjectType _objectType;
    private Integer value;
    private ValueUnit2 unit;

    public ValueAndUnit(ObjectType _objectType) {
        this._objectType = _objectType;
    }

    @Override
    public ObjectType _objectType() {
        return _objectType;
    }

    public Integer value() {
        return value;
    }

    public void value(Integer value) {
        this.value = value;
    }

    public ValueAndUnit valueAnd(Integer value) {
        this.value = value;
        return this;
    }

    public ValueUnit2 unit() {
        return unit;
    }

    public void unit(ValueUnit2 unit) {
        this.unit = unit;
    }

    public ValueAndUnit unitAnd(ValueUnit2 unit) {
        this.unit = unit;
        return this;
    }

    @Override
    public ValueAndUnit clone() {
        ValueAndUnit cloned = new ValueAndUnit(_objectType);
        cloned.copyFrom(this);
        return cloned;
    }

    public void copyFrom(ValueAndUnit from) {
        this.value = from.value;
        this.unit = from.unit;
    }
}
