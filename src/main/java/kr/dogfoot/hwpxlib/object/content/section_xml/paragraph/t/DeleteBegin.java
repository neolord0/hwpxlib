package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.t;

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
}
