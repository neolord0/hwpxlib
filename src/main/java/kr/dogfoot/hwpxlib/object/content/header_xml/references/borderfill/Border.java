package kr.dogfoot.hwpxlib.object.content.header_xml.references.borderfill;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.LineType2;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.LineWidth;

/**
 * 테두리 정보
 */
public class Border extends HWPXObject {
    private final ObjectType _objectType;

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

    public Border(ObjectType _objectType) {
        this._objectType = _objectType;
    }

    @Override
    public ObjectType _objectType() {
        return _objectType;
    }

    public LineType2 type() {
        return type;
    }

    public void type(LineType2 type) {
        this.type = type;
    }

    public Border typeAnd(LineType2 type) {
        this.type = type;
        return this;
    }

    public LineWidth width() {
        return width;
    }

    public void width(LineWidth width) {
        this.width = width;
    }

    public Border widthAnd(LineWidth width) {
        this.width = width;
        return this;
    }

    public String color() {
        return color;
    }

    public void color(String color) {
        this.color = color;
    }

    public Border colorAnd(String color) {
        this.color = color;
        return this;
    }
}
