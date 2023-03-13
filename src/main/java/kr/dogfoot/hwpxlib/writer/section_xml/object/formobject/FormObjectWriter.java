package kr.dogfoot.hwpxlib.writer.section_xml.object.formobject;

import kr.dogfoot.hwpxlib.commonstrings.AttributeNames;
import kr.dogfoot.hwpxlib.commonstrings.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.formobject.FormCharPr;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.formobject.FormObject;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterManager;
import kr.dogfoot.hwpxlib.writer.section_xml.object.shapeobject.ShapeObjectWriter;

public abstract class FormObjectWriter extends ShapeObjectWriter {
    protected FormObjectWriter(ElementWriterManager elementWriterManager) {
        super(elementWriterManager);
    }


    protected void writeAttributeForFormObject(FormObject formObject) {
        writeAttributeForShapeObject(formObject);

        xsb()
                .attribute(AttributeNames.name, formObject.name())
                .attribute(AttributeNames.foreColor, formObject.foreColor())
                .attribute(AttributeNames.backColor, formObject.backColor())
                .attribute(AttributeNames.groupName, formObject.groupName())
                .attribute(AttributeNames.tabStop, formObject.tabStop())
                .attribute(AttributeNames.editable, formObject.editable())
                .attribute(AttributeNames.tabOrder, formObject.tabOrder())
                .attribute(AttributeNames.enabled, formObject.enabled())
                .attribute(AttributeNames.borderTypeIDRef, formObject.borderTypeIDRef())
                .attribute(AttributeNames.drawFrame, formObject.drawFrame())
                .attribute(AttributeNames.printable, formObject.printable())
                .attribute(AttributeNames.command, formObject.command());
    }

    protected void writeChildrenForFormObject(FormObject formObject) {
        if (formObject.formCharPr() != null) {
            formCharPr(formObject.formCharPr());
        }
    }

    private void formCharPr(FormCharPr formCharPr) {
        xsb()
                .openElement(ElementNames.hp_formCharPr)
                .attribute(AttributeNames.charPrIDRef, formCharPr.charPrIDRef())
                .attribute(AttributeNames.followContext, formCharPr.followContext())
                .attribute(AttributeNames.autoSz, formCharPr.autoSz())
                .attribute(AttributeNames.wordWrap, formCharPr.wordWrap())
                .closeElement();
    }

    @Override
    protected void childInSwitch(HWPXObject child) {
        switch (child._objectType()) {
            case hp_formCharPr:
                formCharPr((FormCharPr) child);
                break;
            default:
                super.childInSwitch(child);
                break;
        }
    }
}