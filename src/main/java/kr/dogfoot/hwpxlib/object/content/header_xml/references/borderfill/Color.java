package kr.dogfoot.hwpxlib.object.content.header_xml.references.borderfill;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;

public class Color extends HWPXObject {
    private String value;

    public Color() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hc_color;
    }

    public String value() {
        return value;
    }

    public void value(String value) {
        this.value = value;
    }

    public Color valueAnd(String value) {
        this.value = value;
        return this;
    }
}
