package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapeobject;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;

public class ShapeComment extends HWPXObject {
    private String text;

    public ShapeComment() {
    }

    @Override
    public ObjectType objectType() {
        return ObjectType.ShapeComment;
    }

    public String text() {
        return text;
    }

    public void text(String text) {
        this.text = text;
    }

    public ShapeComment textAnd(String text) {
        this.text = text;
        return this;
    }
}
