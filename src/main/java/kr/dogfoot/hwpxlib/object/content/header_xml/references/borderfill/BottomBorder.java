package kr.dogfoot.hwpxlib.object.content.header_xml.references.borderfill;

import kr.dogfoot.hwpxlib.object.common.ObjectType;

public class BottomBorder extends Border<BottomBorder> {
    public BottomBorder() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hh_bottomBorder;
    }
}
