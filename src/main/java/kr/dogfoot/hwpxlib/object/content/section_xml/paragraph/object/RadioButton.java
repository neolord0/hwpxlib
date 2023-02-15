package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.formobject.ButtonObject;

/**
 * 라디오 버튼
 */
public class RadioButton extends ButtonObject<Button> {
    // 하위 속성,개체 없음

    public RadioButton() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_radioBtn;
    }
}
