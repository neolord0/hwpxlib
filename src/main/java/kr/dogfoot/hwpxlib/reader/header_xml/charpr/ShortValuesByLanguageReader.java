package kr.dogfoot.hwpxlib.reader.header_xml.charpr;

import kr.dogfoot.hwpxlib.commonstirngs.AttributeNames;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.charpr.ValuesByLanguage;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.util.ValueConvertor;

public class ShortValuesByLanguageReader extends ElementReader {
    private ValuesByLanguage<Short, ?> valuesByLanguage;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.ShortValuesByLanguageReader;
    }

    @Override
    public SwitchableObject switchableObject() {
        return null;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.hangul:
                valuesByLanguage.hangul(ValueConvertor.toShort(value));
                break;
            case AttributeNames.latin:
                valuesByLanguage.latin(ValueConvertor.toShort(value));
                break;
            case AttributeNames.hanja:
                valuesByLanguage.hanja(ValueConvertor.toShort(value));
                break;
            case AttributeNames.japanese:
                valuesByLanguage.japanese(ValueConvertor.toShort(value));
                break;
            case AttributeNames.other:
                valuesByLanguage.other(ValueConvertor.toShort(value));
                break;
            case AttributeNames.symbol:
                valuesByLanguage.symbol(ValueConvertor.toShort(value));
                break;
            case AttributeNames.user:
                valuesByLanguage.user(ValueConvertor.toShort(value));
                break;
        }
    }

    public void shortValuesByLanguage(ValuesByLanguage<Short, ?> valuesByLanguage) {
        this.valuesByLanguage = valuesByLanguage;
    }
}
