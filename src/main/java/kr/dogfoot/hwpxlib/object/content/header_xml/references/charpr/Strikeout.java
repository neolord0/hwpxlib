package kr.dogfoot.hwpxlib.object.content.header_xml.references.charpr;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.LineType2;

/**
 * 글자 최소선
 */
public class Strikeout extends HWPXObject {
    /**
     * 취소선 모양
     */
    private LineType2 shape;
    /**
     * 취소선 색
     */
    private String color;

    public Strikeout() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hh_strikeout;
    }

    public LineType2 shape() {
        return shape;
    }

    public void shape(LineType2 shape) {
        this.shape = shape;
    }

    public Strikeout shapeAnd(LineType2 shape) {
        this.shape = shape;
        return this;
    }

    public String color() {
        return color;
    }

    public void color(String color) {
        this.color = color;
    }

    public Strikeout colorAnd(String color) {
        this.color = color;
        return this;
    }

    @Override
    public Strikeout clone() {
        Strikeout cloned = new Strikeout();
        cloned.copyFrom(this);
        return cloned;
    }

    public void copyFrom(Strikeout from) {
        this.shape = from.shape;
        this.color = from.color;
    }
}

