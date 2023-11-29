package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.ctrl;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.ctrl.inner.FootNoteEndNoteCore;

/**
 * 미주
 */
public class EndNote extends FootNoteEndNoteCore<EndNote> {
    public EndNote() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_endNote;
    }

    @Override
    public EndNote clone() {
        EndNote cloned = new EndNote();
        cloned.copyFrom(this);
        return cloned;
    }

    public void copyFrom(EndNote from) {
         super.copyFrom(from);
    }
}
