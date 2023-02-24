package kr.dogfoot.hwpxlib.reader.section_xml.secpr;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.secpr.notepr.*;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.commonstirngs.ElementNames;
import org.xml.sax.Attributes;

public class EndNotePrReader extends ElementReader {
    private EndNotePr endNotePr;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.EndNotePr;
    }
    public void endNotePr(EndNotePr endNotePr) {
        this.endNotePr = endNotePr;
    }

    @Override
    public void childElement(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.hp_autoNumFormat:
                endNotePr.createAutoNumFormat();
                autoNumFormat(endNotePr.autoNumFormat(), name, attrs);
                break;
            case ElementNames.hp_noteLine:
                endNotePr.createNoteLine();
                noteLine(endNotePr.noteLine(), name, attrs);
                break;
            case ElementNames.hp_noteSpacing:
                endNotePr.createNoteSpacing();
                noteSpacing(endNotePr.noteSpacing(), name, attrs);
                break;
            case ElementNames.hp_numbering:
                endNotePr.createNumbering();
                numbering(endNotePr.numbering(), name, attrs);
                break;
            case ElementNames.hp_placement:
                endNotePr.createPlacement();
                placement(endNotePr.placement(), name, attrs);
                break;
        }
    }

    @Override
    public HWPXObject childElementInSwitch(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.hp_autoNumFormat:
                AutoNumFormat autoNumFormat = new AutoNumFormat();
                autoNumFormat(autoNumFormat, name, attrs);
                return autoNumFormat;
            case ElementNames.hp_noteLine:
                NoteLine noteLine = new NoteLine();
                noteLine(noteLine, name, attrs);
                return noteLine;
            case ElementNames.hp_noteSpacing:
                NoteSpacing noteSpacing = new NoteSpacing();
                noteSpacing(noteSpacing, name, attrs);
                return noteSpacing;
            case ElementNames.hp_numbering:
                EndNoteNumbering numbering = new EndNoteNumbering();
                numbering(numbering, name, attrs);
                return numbering;
            case ElementNames.hp_placement:
                EndNotePlacement placement = new EndNotePlacement();
                placement(placement, name, attrs);
                return placement;
        }
        return null;
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

    private void numbering(EndNoteNumbering numbering, String name, Attributes attrs) {
        ((EndNoteNumberingReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.EndNoteNumbering))
                .endNoteNumbering(numbering);

        xmlFileReader().startElement(name, attrs);
    }

    private void placement(EndNotePlacement placement, String name, Attributes attrs) {
        ((EndNotePlacementReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.EndNotePlacement))
                .endNotePlacement(placement);

        xmlFileReader().startElement(name, attrs);
    }

    @Override
    public SwitchableObject switchableObject() {
        return endNotePr;
    }
}
