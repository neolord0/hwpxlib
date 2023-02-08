package kr.dogfoot.hwpxlib.object.content.header_xml.references.charpr;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.LineType3;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.UnderlineType;

/**
 * 글자 밑줄
 */
public class Underline extends HWPXObject {
    /**
     * 밑줄 종류
     */
    private UnderlineType type;
    /**
     * 밑줄 모양
     */
    private LineType3 shape;
    /**
     * 밑줄 색
     */
    private String color;

    public Underline() {
    }

    @Override
    public ObjectType objectType() {
        return ObjectType.Underline;
    }

    public UnderlineType type() {
        return type;
    }

    public void type(UnderlineType type) {
        this.type = type;
    }

    public Underline typeAnd(UnderlineType type) {
        this.type = type;
        return this;
    }

    public LineType3 shape() {
        return shape;
    }

    public void shape(LineType3 shape) {
        this.shape = shape;
    }

    public Underline shapeAnd(LineType3 shape) {
        this.shape = shape;
        return this;
    }

    public String color() {
        return color;
    }

    public void color(String color) {
        this.color = color;
    }

    public Underline colorAnd(String color) {
        this.color = color;
        return this;
    }
}
