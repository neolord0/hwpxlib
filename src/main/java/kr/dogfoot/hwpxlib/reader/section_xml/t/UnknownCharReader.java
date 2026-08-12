package kr.dogfoot.hwpxlib.reader.section_xml.t;

import kr.dogfoot.hwpxlib.commonstrings.AttributeNames;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.t.UnknownChar;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.util.ValueConvertor;

public class UnknownCharReader extends ElementReader {
    private UnknownChar unknownChar;

    public UnknownCharReader() {
    }

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.UnknownChar;
    }

    public void unknownChar(UnknownChar unknownChar) {
        this.unknownChar = unknownChar;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.unknownchar:
                unknownChar.unknownChar(ValueConvertor.toLong(value));
                break;
        }
    }

    @Override
    public SwitchableObject switchableObject() {
        return null;
    }
}
