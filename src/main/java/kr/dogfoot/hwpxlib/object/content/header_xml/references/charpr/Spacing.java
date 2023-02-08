package kr.dogfoot.hwpxlib.object.content.header_xml.references.charpr;

import kr.dogfoot.hwpxlib.object.common.ObjectType;

public class Spacing extends ValuesByLanguage<Short, Spacing> {
    public Spacing() {
    }

    @Override
    public ObjectType objectType() {
        return ObjectType.Spacing;
    }
}