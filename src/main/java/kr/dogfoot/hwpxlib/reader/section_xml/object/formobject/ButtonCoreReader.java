package kr.dogfoot.hwpxlib.reader.section_xml.object.formobject;

import kr.dogfoot.hwpxlib.commonstirngs.AttributeNames;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.BackStyle;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.ButtonCheckValue;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.formobject.ButtonCore;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.formobject.FormObject;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.util.ValueConvertor;

public class ButtonCoreReader extends FormObjectReader {
    private ButtonCore buttonCore;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.ButtonCore;
    }

    @Override
    public FormObject formObject() {
        return buttonCore;
    }

    public void buttonCore(ButtonCore buttonCore) {
        this.buttonCore = buttonCore;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.caption:
                buttonCore.captionText(value);
                break;
            case AttributeNames.value:
                buttonCore.value(ButtonCheckValue.fromString(value));
                break;
            case AttributeNames.radioGroupName:
                buttonCore.radioGroupName(value);
                break;
            case AttributeNames.triState:
                buttonCore.triState(ValueConvertor.toBoolean(value));
                break;
            case AttributeNames.backStyle:
                buttonCore.backStyle(BackStyle.fromString(value));
                break;
            default:
                super.setAttribute(name, value);
                break;
        }
    }

    @Override
    public SwitchableObject switchableObject() {
        return buttonCore;
    }
}
