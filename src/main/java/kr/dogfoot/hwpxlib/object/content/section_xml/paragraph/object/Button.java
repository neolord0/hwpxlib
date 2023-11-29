package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.formobject.ButtonCore;

/**
 * 버튼
 */
public class Button extends ButtonCore<Button> {
    // 하위 속성,개체 없음

    public Button() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_btn;
    }

    @Override
    public Button clone() {
        Button cloned = new Button();
        cloned.copyFrom(this);
        return cloned;
    }

    public void copyFrom(Button from) {
        super.copyFrom(from);
    }
}
