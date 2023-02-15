package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.t;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.TItem;

/**
 * 형광펜 끝
 */
public class MarkpenEnd extends TItem {
    public MarkpenEnd() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_markpenEnd;
    }
}
