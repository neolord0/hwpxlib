package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.edit;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.baseobject.HasOnlyText;

public class EditText extends HasOnlyText<EditText> {
    public EditText() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_text;
    }
}
