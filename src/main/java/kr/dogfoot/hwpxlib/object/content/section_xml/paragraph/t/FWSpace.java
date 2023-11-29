package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.t;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.TItem;

/**
 * 고정폭 빈칸
 */
public class FWSpace extends TItem {
    public FWSpace() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_fwSpace;
    }

    @Override
    public FWSpace clone() {
        FWSpace cloned = new FWSpace();
        cloned.copyFrom(this);
        return null;
    }

    public void copyFrom(FWSpace from) {
        // nothing
    }
}
