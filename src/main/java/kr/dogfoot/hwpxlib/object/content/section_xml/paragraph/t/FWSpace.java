package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.t;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.TItem;

/**
 * 고정폭 빈칸
 */
public class FWSpace extends TItem {
    public FWSpace() {
    }

    @Override
    public ObjectType objectType() {
        return ObjectType.FWSpace;
    }
}
