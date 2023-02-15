package kr.dogfoot.hwpxlib.object.content.header_xml;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;

public class LayoutCompatibilityItem extends HWPXObject {
    private String name;
    private String text;

    public LayoutCompatibilityItem() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.each_layoutCompatibilityItem;
    }

    public String name() {
        return name;
    }

    public void name(String name) {
        this.name = name;
    }

    public LayoutCompatibilityItem nameAnd(String name) {
        this.name = name;
        return this;
    }

    public String text() {
        return text;
    }

    public void text(String text) {
        this.text = text;
    }

    public LayoutCompatibilityItem textAnd(String text) {
        this.text = text;
        return this;
    }
}
