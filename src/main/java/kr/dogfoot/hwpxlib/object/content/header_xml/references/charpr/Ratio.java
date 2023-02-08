package kr.dogfoot.hwpxlib.object.content.header_xml.references.charpr;

import kr.dogfoot.hwpxlib.object.common.ObjectType;

public class Ratio extends ValuesByLanguage<Short, Ratio> {
    public Ratio() {
    }

    @Override
    public ObjectType objectType() {
        return ObjectType.Ratio;
    }
}