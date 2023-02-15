package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.ctrl;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.ctrl.inner.NoteType;

/**
 * 미주
 */
public class EndNote extends NoteType<EndNote> {
    public EndNote() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_endNote;
    }
}
