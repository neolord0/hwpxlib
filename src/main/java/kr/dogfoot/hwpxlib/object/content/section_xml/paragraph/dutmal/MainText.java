package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.dutmal;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.baseobject.HasOnlyText;

public class MainText extends HasOnlyText<SubText> {
    public MainText() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_mainText;
    }
}
