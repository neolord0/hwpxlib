package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.ctrl.inner;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.LineType2;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.LineWidth;

public class ColLine extends HWPXObject {
    private LineType2 type;
    private LineWidth width;
    private String color;

    public ColLine() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_colLine;
    }

    public LineType2 type() {
        return type;
    }

    public void type(LineType2 type) {
        this.type = type;
    }

    public ColLine typeAnd(LineType2 type) {
        this.type = type;
        return this;
    }

    public LineWidth width() {
        return width;
    }

    public void width(LineWidth width) {
        this.width = width;
    }

    public ColLine widthAnd(LineWidth width) {
        this.width = width;
        return this;
    }

    public String color() {
        return color;
    }

    public void color(String color) {
        this.color = color;
    }

    public ColLine colorAnd(String color) {
        this.color = color;
        return this;
    }
}
