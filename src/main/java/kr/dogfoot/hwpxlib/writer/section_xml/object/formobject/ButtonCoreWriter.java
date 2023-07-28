package kr.dogfoot.hwpxlib.writer.section_xml.object.formobject;

import kr.dogfoot.hwpxlib.commonstrings.AttributeNames;
import kr.dogfoot.hwpxlib.commonstrings.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.formobject.ButtonCore;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterManager;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterSort;

public class ButtonCoreWriter extends FormObjectWriter {
    public ButtonCoreWriter(ElementWriterManager elementWriterManager) {
        super(elementWriterManager);
    }

    @Override
    public ElementWriterSort sort() {
        return ElementWriterSort.ButtonCore;
    }

    @Override
    public void write(HWPXObject object) {
        ButtonCore buttonCore = (ButtonCore) object;
        switchList(buttonCore.switchList());

        switch (buttonCore._objectType()) {
            case hp_btn:
                xsb().openElement(ElementNames.hp_btn);
                break;
            case hp_checkBtn:
                xsb().openElement(ElementNames.hp_checkBtn);
                break;
            case hp_radioBtn:
                xsb().openElement(ElementNames.hp_radioBtn);
                break;
        }
        xsb().elementWriter(this);
        xsb()
                .attribute(AttributeNames.caption, buttonCore.captionText())
                .attribute(AttributeNames.value, buttonCore.value())
                .attribute(AttributeNames.radioGroupName, buttonCore.radioGroupName())
                .attribute(AttributeNames.triState, buttonCore.triState())
                .attribute(AttributeNames.backStyle, buttonCore.backStyle());
        writeAttributeForFormObject(buttonCore);

        writeChildrenForFormObject(buttonCore);

        writeChildrenForShapeObject(buttonCore);

        xsb().closeElement();
        releaseMe();
    }
}
