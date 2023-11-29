package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.t;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.t.inner.TrackChangeCore;

/**
 * 변경 추적 삭제 끝지점
 */
public class DeleteEnd extends TrackChangeCore<DeleteEnd> {
    public DeleteEnd() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_deleteEnd;
    }

    @Override
    public DeleteEnd clone() {
        DeleteEnd cloned = new DeleteEnd();
        cloned.copyFrom(this);
        return cloned;
    }

    public void copyFrom(DeleteEnd from) {
        super.copyFrom(from);
    }
}
