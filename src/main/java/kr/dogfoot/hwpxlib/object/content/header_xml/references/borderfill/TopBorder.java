package kr.dogfoot.hwpxlib.object.content.header_xml.references.borderfill;

import kr.dogfoot.hwpxlib.object.common.ObjectType;

public class TopBorder extends Border<TopBorder> {
    public TopBorder() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hh_topBorder;
    }
}
