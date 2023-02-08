package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.formobject.ButtonObject;

/**
 * 버튼
 */
public class Button extends ButtonObject<Button> {
    // 하위 속성,개체 없음

    public Button() {
    }

    @Override
    public ObjectType objectType() {
        return ObjectType.Btn;
    }
}
