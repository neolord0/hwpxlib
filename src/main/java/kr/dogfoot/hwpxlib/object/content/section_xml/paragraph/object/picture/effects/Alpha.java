package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.picture.effects;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.baseobject.StartAndEndFloat;

/**
 * 투명도
 */
public class Alpha extends StartAndEndFloat {
    public Alpha() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_alpha;
    }
}
