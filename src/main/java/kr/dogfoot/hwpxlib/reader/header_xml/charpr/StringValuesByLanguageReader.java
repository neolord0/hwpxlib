package kr.dogfoot.hwpxlib.reader.header_xml.charpr;

import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.charpr.ValuesByLanguage;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.object.names.AttributeNames;

public class StringValuesByLanguageReader extends ElementReader {
    private ValuesByLanguage<String, ?> valuesByLanguage;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.StringValuesByLanguageReader;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.hangul:
                valuesByLanguage.hangul(value);
                break;
            case AttributeNames.latin:
                valuesByLanguage.latin(value);
                break;
            case AttributeNames.hanja:
                valuesByLanguage.hanja(value);
                break;
            case AttributeNames.japanese:
                valuesByLanguage.japanese(value);
                break;
            case AttributeNames.other:
                valuesByLanguage.other(value);
                break;
            case AttributeNames.symbol:
                valuesByLanguage.symbol(value);
                break;
            case AttributeNames.user:
                valuesByLanguage.user(value);
                break;
        }
    }

    @Override
    public SwitchableObject switchableObject() {
        return null;
    }

    public void stringValuesByLanguage(ValuesByLanguage<String, ?> valuesByLanguage) {
        this.valuesByLanguage = valuesByLanguage;
    }
}
