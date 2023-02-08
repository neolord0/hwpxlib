package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.ctrl;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.ctrl.inner.NoteType;

/**
 * 미주
 */
public class EndNote extends NoteType<EndNote> {
    public EndNote() {
    }

    @Override
    public ObjectType objectType() {
        return ObjectType.EndNote;
    }
}