package kr.dogfoot.hwpxlib.writer.section_xml.secpr;

import kr.dogfoot.hwpxlib.commonstrings.AttributeNames;
import kr.dogfoot.hwpxlib.commonstrings.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.secpr.notepr.*;
import kr.dogfoot.hwpxlib.writer.common.ElementWriter;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterManager;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterSort;
import kr.dogfoot.hwpxlib.writer.util.XMLStringBuilder;

public class FootNotePrWriter extends ElementWriter {
    public FootNotePrWriter(ElementWriterManager elementWriterManager) {
        super(elementWriterManager);
    }

    @Override
    public ElementWriterSort sort() {
        return ElementWriterSort.FootNotePr;
    }

    @Override
    public void write(HWPXObject object) {
        FootNotePr footNotePr = (FootNotePr) object;
        switchList(footNotePr.switchList());

        xsb()
                .openElement(ElementNames.hp_footNotePr)
                .elementWriter(this);

        if (footNotePr.autoNumFormat() != null) {
            autoNumFormat(footNotePr.autoNumFormat(), xsb());
        }

        if (footNotePr.noteLine() != null) {
            noteLine(footNotePr.noteLine(), xsb());
        }

        if (footNotePr.noteSpacing() != null) {
            noteSpacing(footNotePr.noteSpacing(), xsb());
        }

        if (footNotePr.numbering() != null) {
            numbering(footNotePr.numbering());
        }

        if (footNotePr.placement() != null) {
            placement(footNotePr.placement());
        }

        xsb().closeElement();
        releaseMe();
    }

    public static void autoNumFormat(AutoNumFormat autoNumFormat, XMLStringBuilder xsb) {
        xsb
                .openElement(ElementNames.hp_autoNumFormat)
                .attribute(AttributeNames.type, autoNumFormat.type())
                .attribute(AttributeNames.userChar, autoNumFormat.userChar())
                .attribute(AttributeNames.prefixChar, autoNumFormat.prefixChar())
                .attribute(AttributeNames.suffixChar, autoNumFormat.suffixChar())
                .attribute(AttributeNames.supscript, autoNumFormat.supscript())
                .closeElement();
    }

    public static void noteLine(NoteLine noteLine, XMLStringBuilder xsb) {
        xsb
                .openElement(ElementNames.hp_noteLine)
                .attribute(AttributeNames.length, noteLine.length())
                .attribute(AttributeNames.type, noteLine.type())
                .attribute(AttributeNames.width, noteLine.width())
                .attribute(AttributeNames.color, noteLine.color())
                .closeElement();
    }

    public static void noteSpacing(NoteSpacing noteSpacing, XMLStringBuilder xsb) {
        xsb
                .openElement(ElementNames.hp_noteSpacing)
                .attribute(AttributeNames.betweenNotes, noteSpacing.betweenNotes())
                .attribute(AttributeNames.belowLine, noteSpacing.belowLine())
                .attribute(AttributeNames.aboveLine, noteSpacing.aboveLine())
                .closeElement();
    }

    private void numbering(FootNoteNumbering numbering) {
        xsb()
                .openElement(ElementNames.hp_numbering)
                .attribute(AttributeNames.type, numbering.type())
                .attribute(AttributeNames.newNum, numbering.newNum())
                .closeElement();
    }

    private void placement(FootNotePlacement placement) {
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
                autoNumFormat((AutoNumFormat) child, xsb());
                break;
            case hp_noteLine:
                noteLine((NoteLine) child, xsb());
                break;
            case hp_noteSpacing:
                noteSpacing((NoteSpacing) child, xsb());
                break;
            case hp_numbering_for_footnote:
                numbering((FootNoteNumbering) child);
                break;
            case hp_placement_for_footnote:
                placement((FootNotePlacement) child);
                break;
        }
    }
}
