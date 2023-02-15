package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.t;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.TItem;

/**
 * 강제 줄나눔
 */
public class LineBreak extends TItem {
    public LineBreak() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_lineBreak;
    }
}
