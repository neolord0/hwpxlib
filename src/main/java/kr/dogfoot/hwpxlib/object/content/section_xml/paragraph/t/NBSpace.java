package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.t;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.TItem;

/**
 * 묶음 빈칸
 */
public class NBSpace extends TItem {
    public NBSpace() {
    }

    @Override
    public ObjectType objectType() {
        return ObjectType.NBSpace;
    }
}