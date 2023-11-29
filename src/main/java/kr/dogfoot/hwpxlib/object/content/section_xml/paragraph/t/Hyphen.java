package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.t;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.TItem;

/**
 * 하이픈
 */
public class Hyphen extends TItem {
    public Hyphen() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_hyphen;
    }

    @Override
    public Hyphen clone() {
        Hyphen cloned = new Hyphen();
        cloned.copyFrom(this);
        return cloned;
    }

    public void copyFrom(Hyphen from) {
        // nothing
    }
}
