package kr.dogfoot.hwpxlib.reader.header_xml.style;

import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.StyleType;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.Style;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.util.ValueConvertor;
import kr.dogfoot.hwpxlib.object.names.AttributeNames;

public class StyleReader extends ElementReader {
    private Style style;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.Style;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.id:
                style.id(value);
                break;
            case AttributeNames.type:
                style.type(StyleType.fromString(value));
                break;
            case AttributeNames.name:
                style.name(value);
                break;
            case AttributeNames.engName:
                style.engName(value);
                break;
            case AttributeNames.paraPrIDRef:
                style.paraPrIDRef(value);
                break;
            case AttributeNames.charPrIDRef:
                style.charPrIDRef(value);
                break;
            case AttributeNames.nextStyleIDRef:
                style.nextStyleIDRef(value);
                break;
            case AttributeNames.langID:
                style.langID(value);
                break;
            case AttributeNames.lockForm:
                style.lockForm(ValueConvertor.toBoolean(value));
                break;
        }
    }


    @Override
    public SwitchableObject switchableObject() {
        return null;
    }

    public void style(Style style) {
        this.style = style;
    }
}
