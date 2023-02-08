package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.formobject.ButtonObject;

/**
 * 체크 버튼
 */
public class CheckButton extends ButtonObject<Button> {
    // 하위 속성,개체 없음

    public CheckButton() {
    }

    @Override
    public ObjectType objectType() {
        return ObjectType.CheckBtn;
    }
}
