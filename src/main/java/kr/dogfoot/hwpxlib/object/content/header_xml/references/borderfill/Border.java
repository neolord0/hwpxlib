package kr.dogfoot.hwpxlib.object.content.header_xml.references.borderfill;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.LineType2;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.LineWidth;

/**
 * 테두리 정보
 */
public abstract class Border<ChildType> extends HWPXObject {
    /**
     * 선 종류
     */
    private LineType2 type;
    /**
     * 선 두께
     */
    private LineWidth width;
    /**
     * 선 색상
     */
    private String color;

    public LineType2 type() {
        return type;
    }

    public void type(LineType2 type) {
        this.type = type;
    }

    public ChildType typeAnd(LineType2 type) {
        this.type = type;
        return (ChildType) this;
    }

    public LineWidth width() {
        return width;
    }

    public void width(LineWidth width) {
        this.width = width;
    }

    public ChildType widthAnd(LineWidth width) {
        this.width = width;
        return (ChildType) this;
    }

    public String color() {
        return color;
    }

    public void color(String color) {
        this.color = color;
    }

    public ChildType colorAnd(String color) {
        this.color = color;
        return (ChildType) this;
    }
}
