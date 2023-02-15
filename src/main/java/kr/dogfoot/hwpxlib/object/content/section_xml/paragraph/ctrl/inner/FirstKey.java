package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.ctrl.inner;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.baseobject.HasOnlyText;

public class FirstKey extends HasOnlyText<FirstKey> {
    public FirstKey() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_firstKey;
    }
}
