package kr.dogfoot.hwpxlib.object.content.header_xml.references.borderfill;

import kr.dogfoot.hwpxlib.object.common.ObjectType;

public class DiagonalBorder extends Border<BottomBorder> {
    public DiagonalBorder() {
    }

    @Override
    public ObjectType objectType() {
        return ObjectType.Diagonal;
    }
}
