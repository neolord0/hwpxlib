package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.formobject.ButtonCore;

/**
 * 체크 버튼
 */
public class CheckButton extends ButtonCore<Button> {
    // 하위 속성,개체 없음

    public CheckButton() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_checkBtn;
    }
}
