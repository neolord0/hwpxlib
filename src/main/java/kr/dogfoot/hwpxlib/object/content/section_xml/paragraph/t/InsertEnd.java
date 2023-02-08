package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.t;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.t.inner.TrackChangeTag;

/**
 * 변경 추적 삽입 끝지점
 */
public class InsertEnd extends TrackChangeTag<InsertEnd> {
    public InsertEnd() {
    }

    @Override
    public ObjectType objectType() {
        return ObjectType.InsertEnd;
    }
}
