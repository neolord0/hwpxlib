package kr.dogfoot.hwpxlib.writer.section_xml.ctrl;

import kr.dogfoot.hwpxlib.commonstrings.AttributeNames;
import kr.dogfoot.hwpxlib.commonstrings.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.baseobject.HasOnlyText;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.ctrl.FieldBegin;
import kr.dogfoot.hwpxlib.writer.common.ElementWriter;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterManager;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterSort;

public class FieldBeginWriter extends ElementWriter {
    public FieldBeginWriter(ElementWriterManager elementWriterManager) {
        super(elementWriterManager);
    }

    @Override
    public ElementWriterSort sort() {
        return ElementWriterSort.FieldBegin;
    }

    @Override
    public void write(HWPXObject object) {
        FieldBegin fieldBegin = (FieldBegin) object;
        switchList(fieldBegin.switchList());

        xsb()
                .openElement(ElementNames.hp_fieldBegin)
                .elementWriter(this)
                .attribute(AttributeNames.id, fieldBegin.id())
                .attribute(AttributeNames.type, fieldBegin.type())
                .attribute(AttributeNames.name, fieldBegin.name())
                .attribute(AttributeNames.editable, fieldBegin.editable())
                .attribute(AttributeNames.dirty, fieldBegin.dirty())
                .attribute(AttributeNames.zorder, fieldBegin.zorder())
                .attribute(AttributeNames.fieldid, fieldBegin.fieldid());

        if (fieldBegin.parameters() != null) {
            writeChild(ElementWriterSort.ParameterListCore, fieldBegin.parameters());
        }

        if (fieldBegin.subList() != null) {
            writeChild(ElementWriterSort.SubList, fieldBegin.subList());
        }

        if (fieldBegin.metaTag() != null) {
            hasOnlyText(ElementNames.hp_metaTag, fieldBegin.metaTag());
        }

        xsb().closeElement();
        releaseMe();
    }

    @Override
    protected void childInSwitch(HWPXObject child) {
        switch (child._objectType()) {
            case hp_parameters:
                writeChild(ElementWriterSort.ParameterListCore, child);
                break;
            case hp_subList:
                writeChild(ElementWriterSort.SubList, child);
                break;
            case hp_metaTag:
                hasOnlyText(ElementNames.hp_metaTag, (HasOnlyText) child);
                break;
        }
    }
}
