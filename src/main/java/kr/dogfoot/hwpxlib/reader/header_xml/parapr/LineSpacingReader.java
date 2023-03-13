package kr.dogfoot.hwpxlib.reader.header_xml.parapr;

import kr.dogfoot.hwpxlib.commonstrings.AttributeNames;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.LineSpacingType;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.ValueUnit2;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.parapr.LineSpacing;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.util.ValueConvertor;

public class LineSpacingReader extends ElementReader {
    private LineSpacing lineSpacing;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.LineSpacing;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.type:
                lineSpacing.type(LineSpacingType.fromString(value));
                break;
            case AttributeNames.value:
                lineSpacing.value(ValueConvertor.toInteger(value));
                break;
            case AttributeNames.unit:
                lineSpacing.unit(ValueUnit2.fromString(value));
                break;
        }
    }

    @Override
    public SwitchableObject switchableObject() {
        return null;
    }

    public void lineSpacing(LineSpacing lineSpacing) {
        this.lineSpacing = lineSpacing;
    }
}
