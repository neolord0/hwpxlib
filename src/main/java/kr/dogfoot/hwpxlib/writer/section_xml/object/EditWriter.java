package kr.dogfoot.hwpxlib.writer.section_xml.object;

import kr.dogfoot.hwpxlib.commonstrings.AttributeNames;
import kr.dogfoot.hwpxlib.commonstrings.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.baseobject.HasOnlyText;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.Edit;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterManager;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterSort;
import kr.dogfoot.hwpxlib.writer.section_xml.object.formobject.FormObjectWriter;

public class EditWriter extends FormObjectWriter {
    public EditWriter(ElementWriterManager elementWriterManager) {
        super(elementWriterManager);
    }

    @Override
    public ElementWriterSort sort() {
        return ElementWriterSort.Edit;
    }

    @Override
    public void write(HWPXObject object) {
        Edit edit = (Edit) object;
        switchObject(edit.switchObject());

        xsb()
                .openElement(ElementNames.hp_edit)
                .elementWriter(this)
                .attribute(AttributeNames.multiLine, edit.multiLine())
                .attribute(AttributeNames.passwordChar, edit.passwordChar())
                .attribute(AttributeNames.maxLength, edit.maxLength())
                .attribute(AttributeNames.scrollBars, edit.scrollBars())
                .attribute(AttributeNames.tabKeyBehavior, edit.tabKeyBehavior())
                .attribute(AttributeNames.numOnly, edit.numOnly())
                .attribute(AttributeNames.readOnly, edit.readOnly())
                .attribute(AttributeNames.alignText, edit.alignText());
        writeAttributeForFormObject(edit);

        writeChildrenForFormObject(edit);

        if (edit.text() != null) {
            hasOnlyText(ElementNames.hp_text, edit.text());
        }

        writeChildrenForShapeObject(edit);

        xsb().closeElement();
        releaseMe();
    }

    @Override
    protected void childInSwitch(HWPXObject child) {
        switch (child._objectType()) {
            case hp_text:
                hasOnlyText(ElementNames.hp_text, (HasOnlyText) child);
                break;
            default:
                super.childInSwitch(child);
                break;
        }
    }
}
