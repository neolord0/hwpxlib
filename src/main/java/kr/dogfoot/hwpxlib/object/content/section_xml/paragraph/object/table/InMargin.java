package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.table;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.baseobject.LeftRightTopBottom;

/**
 * 안쪽 여백
 */
public class InMargin extends LeftRightTopBottom<InMargin> {
    public InMargin() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_inMargin;
    }
}
