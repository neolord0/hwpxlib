package kr.dogfoot.hwpxlib.reader.section_xml.secpr;

import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.EndNoteNumberingType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.secpr.notepr.EndNoteNumbering;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.util.ValueConvertor;
import kr.dogfoot.hwpxlib.commonstirngs.AttributeNames;

public class EndNoteNumberingReader extends ElementReader {
    private EndNoteNumbering endNoteNumbering;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.EndNoteNumbering;
    }

    public void endNoteNumbering(EndNoteNumbering endNoteNumbering) {
        this.endNoteNumbering = endNoteNumbering;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.type:
                endNoteNumbering.type(EndNoteNumberingType.fromString(value));
                break;
            case AttributeNames.newNum:
                endNoteNumbering.newNum(ValueConvertor.toInteger(value));
                break;
        }
    }

    @Override
    public SwitchableObject switchableObject() {
        return null;
    }
}
