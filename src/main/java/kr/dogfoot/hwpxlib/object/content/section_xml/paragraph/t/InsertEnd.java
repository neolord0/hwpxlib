package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.t;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.t.inner.TrackChangeCore;

/**
 * 변경 추적 삽입 끝지점
 */
public class InsertEnd extends TrackChangeCore<InsertEnd> {
    public InsertEnd() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_insertEnd;
    }
}
