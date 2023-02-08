package kr.dogfoot.hwpxlib.reader.section_xml.secpr;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.secpr.notepr.*;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.util.ElementNames;
import org.xml.sax.Attributes;

public class FootNotePrReader extends ElementReader {
    private FootNotePr footNotePr;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.FootNotePr;
    }

    public void footNotePr(FootNotePr footNotePr) {
        this.footNotePr = footNotePr;
    }

    @Override
    public void childElement(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.AutoNumFormat:
                footNotePr.createAutoNumFormat();
                autoNumFormat(footNotePr.autoNumFormat(), name, attrs);
                break;
            case ElementNames.NoteLine:
                footNotePr.createNoteLine();
                noteLine(footNotePr.noteLine(), name, attrs);
                break;
            case ElementNames.NoteSpacing:
                footNotePr.createNoteSpacing();
                noteSpacing(footNotePr.noteSpacing(), name, attrs);
                break;
            case ElementNames.NoteNumbering:
                footNotePr.createNumbering();
                numbering(footNotePr.numbering(), name, attrs);
                break;
            case ElementNames.NotePlacement:
                footNotePr.createPlacement();
                placement(footNotePr.placement(), name, attrs);
                break;
        }
    }

    @Override
    public void childElementInSwitch(HWPXObject child, String name, Attributes attrs) {
        if (child.objectType() == ObjectType.AutoNumFormat) {
            autoNumFormat((AutoNumFormat) child, name, attrs);
        } else if (child.objectType() == ObjectType.NoteLine) {
            noteLine((NoteLine) child, name, attrs);
        } else if (child.objectType() == ObjectType.NoteSpacing) {
            noteSpacing((NoteSpacing) child, name, attrs);
        } else if (child.objectType() == ObjectType.FootNoteNumbering) {
            numbering((FootNoteNumbering) child, name, attrs);
        } else if (child.objectType() == ObjectType.FootNotePlacement) {
            placement((FootNotePlacement) child, name, attrs);
        }
    }

    private void autoNumFormat(AutoNumFormat autoNumFormat, String name, Attributes attrs) {
        ((AutoNumFormatReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.AutoNumFormat))
                .autoNumFormat(autoNumFormat);

        xmlFileReader().startElement(name, attrs);
    }

    private void noteLine(NoteLine noteLine, String name, Attributes attrs) {
        ((NoteLineReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.NoteLine))
                .noteLine(noteLine);

        xmlFileReader().startElement(name, attrs);
    }

    private void noteSpacing(NoteSpacing noteSpacing, String name, Attributes attrs) {
        ((NoteSpacingReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.NoteSpacing))
                .noteSpacing(noteSpacing);

        xmlFileReader().startElement(name, attrs);
    }

    private void numbering(FootNoteNumbering numbering, String name, Attributes attrs) {
        ((FootNoteNumberingReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.FootNoteNumbering))
                .footNoteNumbering(numbering);

        xmlFileReader().startElement(name, attrs);
    }

    private void placement(FootNotePlacement placement, String name, Attributes attrs) {
        ((FootNotePlacementReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.FootNotePlacement))
                .footNotePlacement(placement);

        xmlFileReader().startElement(name, attrs);
    }

    @Override
    public SwitchableObject switchableObject() {
        return footNotePr;
    }
}
