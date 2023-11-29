package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.ctrl;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.ctrl.inner.AutoNumNewNumCore;

/**
 * 새 번호
 */
public class NewNum extends AutoNumNewNumCore<NewNum> {
    public NewNum() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_newNum;
    }

    @Override
    public NewNum clone() {
        NewNum cloned = new NewNum();
        cloned.copyFrom(this);
        return cloned;
    }

    public void copyFrom(NewNum from) {
        super.copyFrom(from);
    }
}
