package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.ole;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.baseobject.XAndY;

public class Extent extends XAndY<Extent> {
    public Extent() {
    }

    @Override
    public ObjectType objectType() {
        return ObjectType.Extent;
    }
}
