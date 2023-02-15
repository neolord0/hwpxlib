package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.picture.effects;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.baseobject.StartAndEndFloat;

public class Position extends StartAndEndFloat<Position> {
    public Position() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_pos;
    }
}
