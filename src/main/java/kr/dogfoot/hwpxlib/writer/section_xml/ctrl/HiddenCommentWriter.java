package kr.dogfoot.hwpxlib.writer.section_xml.ctrl;

import kr.dogfoot.hwpxlib.commonstirngs.AttributeNames;
import kr.dogfoot.hwpxlib.commonstirngs.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.ctrl.FieldBegin;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.ctrl.HiddenComment;
import kr.dogfoot.hwpxlib.writer.common.ElementWriter;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterManager;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterSort;

public class HiddenCommentWriter extends ElementWriter {
    public HiddenCommentWriter(ElementWriterManager elementWriterManager) {
        super(elementWriterManager);
    }

    @Override
    public ElementWriterSort sort() {
        return ElementWriterSort.HiddenComment;
    }

    @Override
    public void write(HWPXObject object) {
        HiddenComment hiddenComment = (HiddenComment) object;
        switchObject(hiddenComment.switchObject());

        xsb()
                .openElement(ElementNames.hp_fieldBegin)
                .elementWriter(this);

        if (hiddenComment.subList() != null) {
            writeChild(ElementWriterSort.SubList, hiddenComment.subList());
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
