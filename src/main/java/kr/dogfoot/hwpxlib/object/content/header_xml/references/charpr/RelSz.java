package kr.dogfoot.hwpxlib.object.content.header_xml.references.charpr;

import kr.dogfoot.hwpxlib.object.common.ObjectType;

public class RelSz extends ValuesByLanguage<Short, RelSz> {
    public RelSz() {
    }

    @Override
    public ObjectType objectType() {
        return ObjectType.RelSz;
    }
}