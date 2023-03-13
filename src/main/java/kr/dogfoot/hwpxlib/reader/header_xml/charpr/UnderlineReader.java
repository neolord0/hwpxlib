package kr.dogfoot.hwpxlib.reader.header_xml.charpr;

import kr.dogfoot.hwpxlib.commonstrings.AttributeNames;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.LineType3;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.UnderlineType;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.charpr.Underline;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;

public class UnderlineReader extends ElementReader {
    private Underline underline;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.Underline;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.type:
                underline.type(UnderlineType.fromString(value));
                break;
            case AttributeNames.shape:
                underline.shape(LineType3.fromString(value));
                break;
            case AttributeNames.color:
                underline.color(value);
                break;
        }
    }

    @Override
    public SwitchableObject switchableObject() {
        return null;
    }

    public void underLine(Underline underline) {
        this.underline = underline;
    }
}
