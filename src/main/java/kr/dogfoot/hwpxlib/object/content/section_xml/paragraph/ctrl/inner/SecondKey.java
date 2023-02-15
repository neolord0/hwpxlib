package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.ctrl.inner;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.baseobject.HasOnlyText;

public class SecondKey extends HasOnlyText<FirstKey> {
    public SecondKey() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_secondKey;
    }
}