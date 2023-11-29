package kr.dogfoot.hwpxlib.object.common.parameter;

import kr.dogfoot.hwpxlib.object.common.ObjectType;

public class StringParam extends Param<StringParam> {
    private String value;
    private String xml_space;

    public StringParam() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_stringParam;
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

    public String xml_space() {
        return xml_space;
    }

    public void xml_space(String xml_space) {
        this.xml_space = xml_space;
    }

    public StringParam xml_spaceAnd(String xml_space) {
        this.xml_space = xml_space;
        return this;
    }

    @Override
    public StringParam clone() {
        StringParam cloned = new StringParam();
        cloned.copyFrom(this);
        return cloned;
    }

    public void copyFrom(StringParam from) {
        this.value = from.value;
        this.xml_space = from.xml_space;

        super.copyFrom(from);
    }
}
