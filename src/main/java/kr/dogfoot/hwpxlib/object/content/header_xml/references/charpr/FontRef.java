package kr.dogfoot.hwpxlib.object.content.header_xml.references.charpr;

import kr.dogfoot.hwpxlib.object.common.ObjectType;

public class FontRef extends ValuesByLanguage<String, FontRef> {
    public FontRef() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hh_fontRef;
    }
}
