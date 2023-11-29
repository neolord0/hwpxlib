package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.t;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.t.inner.TrackChangeCore;

/**
 * 변경 추적 삭제 시작지점
 */
public class DeleteBegin extends TrackChangeCore<DeleteBegin> {
    public DeleteBegin() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_deleteBegin;
    }

    @Override
    public HWPXObject clone() {
        DeleteBegin cloned = new DeleteBegin();
        cloned.copyFrom(this);
        return cloned;
    }

    public void copyFrom(DeleteBegin from) {
        super.copyFrom(from);
    }
}
