package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.t;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.t.inner.TrackChangeCore;

/**
 * 변경 추적 삽입 시작지점
 */
public class InsertBegin extends TrackChangeCore<InsertBegin> {
    public InsertBegin() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_insertBegin;
    }
}
