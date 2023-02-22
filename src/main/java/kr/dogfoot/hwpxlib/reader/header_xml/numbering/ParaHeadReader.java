package kr.dogfoot.hwpxlib.reader.header_xml.numbering;

import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.HorizontalAlign1;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.NumberType1;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.ValueUnit1;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.numbering.ParaHead;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.util.ValueConvertor;
import kr.dogfoot.hwpxlib.object.names.AttributeNames;

public class ParaHeadReader extends ElementReader {
    private ParaHead paraHead;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.ParaHead;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.level:
                paraHead.level(ValueConvertor.toByte(value));
                break;
            case AttributeNames.start:
                paraHead.start(ValueConvertor.toInteger(value));
                break;
            case AttributeNames.align:
                paraHead.align(HorizontalAlign1.fromString(value));
                break;
            case AttributeNames.useInstWidth:
                paraHead.useInstWidth(ValueConvertor.toBoolean(value));
                break;
            case AttributeNames.autoIndent:
                paraHead.autoIndent(ValueConvertor.toBoolean(value));
                break;
            case AttributeNames.widthAdjust:
                paraHead.widthAdjust(ValueConvertor.toInteger(value));
                break;
            case AttributeNames.textOffsetType:
                paraHead.textOffsetType(ValueUnit1.fromString(value));
                break;
            case AttributeNames.textOffset:
                paraHead.textOffset(ValueConvertor.toInteger(value));
                break;
            case AttributeNames.numFormat:
                paraHead.numFormat(NumberType1.fromString(value));
                break;
            case AttributeNames.charPrIDRef:
                paraHead.charPrIDRef(value);
                break;
            case AttributeNames.checkable:
                paraHead.checkable(ValueConvertor.toBoolean(value));
                break;
        }
    }

    @Override
    public void text(String text) {
        paraHead.text(text);
    }

    @Override
    public SwitchableObject switchableObject() {
        return null;
    }

    public void paraHead(ParaHead paraHead) {
        this.paraHead = paraHead;
    }
}
