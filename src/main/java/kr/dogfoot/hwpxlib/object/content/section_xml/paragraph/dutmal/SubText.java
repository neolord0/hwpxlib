package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.dutmal;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.baseobject.HasOnlyText;

public class SubText extends HasOnlyText<SubText> {
    public SubText() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_subText;
    }
}
