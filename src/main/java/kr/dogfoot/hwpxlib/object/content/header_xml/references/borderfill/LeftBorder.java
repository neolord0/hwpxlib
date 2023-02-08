package kr.dogfoot.hwpxlib.object.content.header_xml.references.borderfill;

import kr.dogfoot.hwpxlib.object.common.ObjectType;

public class LeftBorder extends Border<LeftBorder> {
    public LeftBorder() {
    }

    @Override
    public ObjectType objectType() {
        return ObjectType.LeftBorder;
    }
}
