package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.formobject.ButtonCore;

/**
 * 라디오 버튼
 */
public class RadioButton extends ButtonCore<Button> {
    // 하위 속성,개체 없음

    public RadioButton() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_radioBtn;
    }

    @Override
    public RadioButton clone() {
        RadioButton cloned = new RadioButton();
        cloned.copyFrom(this);
        return cloned;
    }

    public void copyFrom(RadioButton from) {
        super.copyFrom(from);
    }
}
