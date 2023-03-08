package kr.dogfoot.hwpxlib.writer.section_xml.ctrl;

import kr.dogfoot.hwpxlib.commonstirngs.AttributeNames;
import kr.dogfoot.hwpxlib.commonstirngs.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.ctrl.inner.FootNoteEndNoteCore;
import kr.dogfoot.hwpxlib.writer.common.ElementWriter;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterManager;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterSort;

public class FootNoteEndNoteWriter extends ElementWriter {
    public FootNoteEndNoteWriter(ElementWriterManager elementWriterManager) {
        super(elementWriterManager);
    }

    @Override
    public ElementWriterSort sort() {
        return ElementWriterSort.FootNoteEndNote;
    }

    @Override
    public void write(HWPXObject object) {
        FootNoteEndNoteCore footNoteEndNote = (FootNoteEndNoteCore) object;
        switchObject(footNoteEndNote.switchObject());

        switch (footNoteEndNote._objectType()) {
            case hp_footNote:
                xsb().openElement(ElementNames.hp_footNote);
                break;
            case hp_endNote:
                xsb().openElement(ElementNames.hp_endNote);
                break;
        }

        xsb()
                .elementWriter(this)
                .attribute(AttributeNames.number, footNoteEndNote.number())
                .attribute(AttributeNames.suffixChar, footNoteEndNote.suffixChar())
                .attribute(AttributeNames.instId, footNoteEndNote.instId());

        if (footNoteEndNote.subList() != null) {
            writeChild(ElementWriterSort.SubList, footNoteEndNote.subList());
        }

        xsb().closeElement();
        releaseMe();
    }

    @Override
    protected void childInSwitch(HWPXObject child) {
        switch (child._objectType()) {
            case hp_subList:
                writeChild(ElementWriterSort.SubList, child);
                break;
        }
    }
}
