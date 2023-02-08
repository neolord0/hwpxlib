package kr.dogfoot.hwpxlib.object.content.header_xml.references.charpr;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.CharShadowType;

/**
 * 글자 그림자
 */
public class CharShadow extends HWPXObject {
    /**
     * 그림자 종류
     */
    private CharShadowType type;
    /**
     * 그림자 색
     */
    private String color;
    /**
     * 그림자 간격 X, 단위는 %
     */
    private Short offsetX;
    /**
     * 그림자 간격 Y, 단위는 %
     */
    private Short offsetY;

    public CharShadow() {
    }

    @Override
    public ObjectType objectType() {
        return ObjectType.CharShadow;
    }

    public CharShadowType type() {
        return type;
    }

    public void type(CharShadowType type) {
        this.type = type;
    }

    public CharShadow typeAnd(CharShadowType type) {
        this.type = type;
        return this;
    }

    public String color() {
        return color;
    }

    public void color(String color) {
        this.color = color;
    }

    public CharShadow colorAnd(String color) {
        this.color = color;
        return this;
    }

    public Short offsetX() {
        return offsetX;
    }

    public void offsetX(Short offsetX) {
        this.offsetX = offsetX;
    }

    public CharShadow offsetXAnd(Short offsetX) {
        this.offsetX = offsetX;
        return this;
    }

    public Short offsetY() {
        return offsetY;
    }

    public void offsetY(Short offsetY) {
        this.offsetY = offsetY;
    }

    public CharShadow offsetYAnd(Short offsetY) {
        this.offsetY = offsetY;
        return this;
    }
}
