package kr.dogfoot.hwpxlib.writer.section_xml.secpr;

import kr.dogfoot.hwpxlib.commonstrings.AttributeNames;
import kr.dogfoot.hwpxlib.commonstrings.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.secpr.notepr.*;
import kr.dogfoot.hwpxlib.writer.common.ElementWriter;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterManager;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterSort;

public class EndNotePrWriter extends ElementWriter {
    public EndNotePrWriter(ElementWriterManager elementWriterManager) {
        super(elementWriterManager);
    }

    @Override
    public ElementWriterSort sort() {
        return ElementWriterSort.EndNotePr;
    }

    @Override
    public void write(HWPXObject object) {
        EndNotePr endNotePr = (EndNotePr) object;
        switchList(endNotePr.switchList());

        xsb()
                .openElement(ElementNames.hp_endNotePr)
                .elementWriter(this);

        if (endNotePr.autoNumFormat() != null) {
            FootNotePrWriter.autoNumFormat(endNotePr.autoNumFormat(), xsb());
        }

        if (endNotePr.noteLine() != null) {
            FootNotePrWriter.noteLine(endNotePr.noteLine(), xsb());
        }

        if (endNotePr.noteSpacing() != null) {
            FootNotePrWriter.noteSpacing(endNotePr.noteSpacing(), xsb());
        }

        if (endNotePr.numbering() != null) {
            numbering(endNotePr.numbering());
        }

        if (endNotePr.placement() != null) {
            placement(endNotePr.placement());
        }

        xsb().closeElement();
        releaseMe();
    }

    private void numbering(EndNoteNumbering numbering) {
        xsb()
                .openElement(ElementNames.hp_numbering)
                .attribute(AttributeNames.type, numbering.type())
                .attribute(AttributeNames.newNum, numbering.newNum())
                .closeElement();
    }

    private void placement(EndNotePlacement placement) {
        xsb()
                .openElement(ElementNames.hp_placement)
                .attribute(AttributeNames.place, placement.place())
                .attribute(AttributeNames.beneathText, placement.beneathText())
                .closeElement();
    }

    @Override
    protected void childInSwitch(HWPXObject child) {
        switch (child._objectType()) {
            case hp_autoNumFormat:
                FootNotePrWriter.autoNumFormat((AutoNumFormat) child, xsb());
                break;
            case hp_noteLine:
                FootNotePrWriter.noteLine((NoteLine) child, xsb());
                break;
            case hp_noteSpacing:
                FootNotePrWriter.noteSpacing((NoteSpacing) child, xsb());
                break;
            case hp_numbering_for_endnote:
                numbering((EndNoteNumbering) child);
                break;
            case hp_placement_for_endnote:
                placement((EndNotePlacement) child);
                break;
        }
    }
}


