package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapeobject;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.baseobject.LeftRightTopBottom;

/**
 * 바깥 여백
 */
public class OutMargin extends LeftRightTopBottom<OutMargin> {
    public OutMargin() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_outMargin;
    }
}
