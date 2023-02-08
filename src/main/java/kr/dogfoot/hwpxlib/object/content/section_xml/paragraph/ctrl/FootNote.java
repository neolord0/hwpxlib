package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.ctrl;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.ctrl.inner.NoteType;

/**
 * 각주
 */
public class FootNote extends NoteType<FootNote> {
    public FootNote() {
    }

    @Override
    public ObjectType objectType() {
        return ObjectType.FootNote;
    }
}
