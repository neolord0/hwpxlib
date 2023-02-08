package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapecomponent;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.baseobject.WidthAndHeight;

public class OriginalSize extends WidthAndHeight<OriginalSize> {
    public OriginalSize() {
    }

    @Override
    public ObjectType objectType() {
        return ObjectType.OrgSz;
    }
}
