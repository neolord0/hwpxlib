package kr.dogfoot.hwpxlib.reader.section_xml.control.formobject;

import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.BackStyle;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.ButtonCheckValue;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.formobject.ButtonObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.formobject.FormObject;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.util.ValueConvertor;
import kr.dogfoot.hwpxlib.object.names.AttributeNames;

public class ButtonObjectReader extends FormObjectReader {
    private ButtonObject buttonObject;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.ButtonObject;
    }

    @Override
    public FormObject formObject() {
        return buttonObject;
    }

    public void buttonObject(ButtonObject buttonObject) {
        this.buttonObject = buttonObject;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.caption:
                buttonObject.captionText(value);
                break;
            case AttributeNames.value:
                buttonObject.value(ButtonCheckValue.fromString(value));
                break;
            case AttributeNames.radioGroupName:
                buttonObject.radioGroupName(value);
                break;
            case AttributeNames.triState:
                buttonObject.triState(ValueConvertor.toBoolean(value));
                break;
            case AttributeNames.backStyle:
                buttonObject.backStyle(BackStyle.fromString(value));
                break;
            default:
                super.setAttribute(name, value);
                break;
        }
    }

    @Override
    public SwitchableObject switchableObject() {
        return buttonObject;
    }
}
