package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.t;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.TItem;

/**
 * 묶음 빈칸
 */
public class NBSpace extends TItem {
    public NBSpace() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_nbSpace;
    }

    @Override
    public NBSpace clone() {
        NBSpace cloned = new NBSpace();
        cloned.copyFrom(this);
        return cloned;
    }

    public void copyFrom(NBSpace from) {
        // nothing
    }
}
