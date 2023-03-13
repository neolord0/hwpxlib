package kr.dogfoot.hwpxlib.reader.header_xml.charpr;

import kr.dogfoot.hwpxlib.commonstrings.AttributeNames;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.CharShadowType;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.charpr.CharShadow;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.util.ValueConvertor;

public class CharShadowReader extends ElementReader {
    private CharShadow charShadow;


    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.CharShadow;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.type:
                charShadow.type(CharShadowType.fromString(value));
                break;
            case AttributeNames.color:
                charShadow.color(value);
                break;
            case AttributeNames.offsetX:
                charShadow.offsetX(ValueConvertor.toShort(value));
                break;
            case AttributeNames.offsetY:
                charShadow.offsetY(ValueConvertor.toShort(value));
                break;
        }
    }

    @Override
    public SwitchableObject switchableObject() {
        return null;
    }

    public void charShadow(CharShadow charShadow) {
        this.charShadow = charShadow;
    }
}
