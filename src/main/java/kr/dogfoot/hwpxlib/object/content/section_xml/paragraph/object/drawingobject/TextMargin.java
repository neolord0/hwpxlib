package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.drawingobject;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.baseobject.LeftRightTopBottom;

/**
 * 여백
 */
public class TextMargin extends LeftRightTopBottom {
    public TextMargin() {
    }

    @Override
    public ObjectType objectType() {
        return ObjectType.TextMargin;
    }
}
