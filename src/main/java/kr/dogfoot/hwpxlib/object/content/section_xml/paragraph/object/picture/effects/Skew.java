package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.picture.effects;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.baseobject.XAndYFloat;

/**
 * 기울기
 */
public class Skew extends XAndYFloat<Skew> {
    public Skew() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_skew;
    }
}
