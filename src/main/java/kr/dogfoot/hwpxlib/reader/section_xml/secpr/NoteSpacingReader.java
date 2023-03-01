package kr.dogfoot.hwpxlib.reader.section_xml.secpr;

import kr.dogfoot.hwpxlib.commonstirngs.AttributeNames;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.secpr.notepr.NoteSpacing;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.util.ValueConvertor;

public class NoteSpacingReader extends ElementReader {
    private NoteSpacing noteSpacing;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.NoteSpacing;
    }

    public void noteSpacing(NoteSpacing noteSpacing) {
        this.noteSpacing = noteSpacing;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.betweenNotes:
                noteSpacing.betweenNotes(ValueConvertor.toInteger(value));
                break;
            case AttributeNames.belowLine:
                noteSpacing.belowLine(ValueConvertor.toInteger(value));
                break;
            case AttributeNames.aboveLine:
                noteSpacing.aboveLine(ValueConvertor.toInteger(value));
                break;
        }
    }

    @Override
    public SwitchableObject switchableObject() {
        return null;
    }
}
