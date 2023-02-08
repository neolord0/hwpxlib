package kr.dogfoot.hwpxlib.reader.section_xml.secpr;

import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.FootNoteNumberingType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.secpr.notepr.FootNoteNumbering;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.util.ValueConvertor;
import kr.dogfoot.hwpxlib.util.AttributeNames;

public class FootNoteNumberingReader extends ElementReader {
    private FootNoteNumbering footNoteNumbering;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.FootNoteNumbering;
    }

    public void footNoteNumbering(FootNoteNumbering footNoteNumbering) {
        this.footNoteNumbering = footNoteNumbering;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.type:
                footNoteNumbering.type(FootNoteNumberingType.fromString(value));
                break;
            case AttributeNames.newNum:
                footNoteNumbering.newNum(ValueConvertor.toInteger(value));
                break;
        }
    }

    @Override
    public SwitchableObject switchableObject() {
        return null;
    }
}
