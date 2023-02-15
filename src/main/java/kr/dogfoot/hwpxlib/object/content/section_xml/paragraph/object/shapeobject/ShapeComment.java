package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapeobject;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.baseobject.HasOnlyText;

public class ShapeComment extends HasOnlyText<ShapeComment> {
    public ShapeComment() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_shapeComment;
    }
}
