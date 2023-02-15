package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.picture.effects;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.baseobject.XAndYFloat;

/**
 * 확대/축소 비율
 */
public class Scale extends XAndYFloat<Scale> {
    public Scale() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_scale;
    }
}
