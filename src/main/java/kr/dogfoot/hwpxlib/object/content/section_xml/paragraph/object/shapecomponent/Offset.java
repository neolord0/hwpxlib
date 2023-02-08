package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapecomponent;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.baseobject.XAndY;

public class Offset extends XAndY<Offset> {
    public Offset() {
    }

    @Override
    public ObjectType objectType() {
        return ObjectType.Offset;
    }
}
