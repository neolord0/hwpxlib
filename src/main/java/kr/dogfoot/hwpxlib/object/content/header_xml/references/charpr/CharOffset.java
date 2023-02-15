package kr.dogfoot.hwpxlib.object.content.header_xml.references.charpr;

import kr.dogfoot.hwpxlib.object.common.ObjectType;

public class CharOffset extends ValuesByLanguage<Short, CharOffset> {
    public CharOffset() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hh_offset;
    }
}