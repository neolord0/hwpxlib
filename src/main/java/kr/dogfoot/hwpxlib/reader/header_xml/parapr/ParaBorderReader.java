package kr.dogfoot.hwpxlib.reader.header_xml.parapr;

import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.LineSpacingType;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.ValueUnit2;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.parapr.ParaBorder;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.util.ValueConvertor;
import kr.dogfoot.hwpxlib.util.AttributeNames;

public class ParaBorderReader extends ElementReader {
    private ParaBorder border;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.ParaBorder;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.borderFillIDRef:
                border.borderFillIDRef(value);
                break;
            case AttributeNames.offsetLeft:
                border.offsetLeft(ValueConvertor.toInteger(value));
                break;
            case AttributeNames.offsetRight:
                border.offsetRight(ValueConvertor.toInteger(value));
                break;
            case AttributeNames.offsetTop:
                border.offsetTop(ValueConvertor.toInteger(value));
                break;
            case AttributeNames.offsetBottom:
                border.offsetBottom(ValueConvertor.toInteger(value));
                break;
            case AttributeNames.connect:
                border.connect(ValueConvertor.toBoolean(value));
                break;
            case AttributeNames.ignoreMargin:
                border.ignoreMargin(ValueConvertor.toBoolean(value));
                break;
        }
    }

    @Override
    public SwitchableObject switchableObject() {
        return null;
    }

    public void border(ParaBorder border) {
        this.border = border;
    }
}
