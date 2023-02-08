package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.drawingobject;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.DrawingShadowType;

/**
 * 객체 그림자 정보
 */
public class DrawingShadow extends HWPXObject {
    /**
     * 그림자 종류
     */
    private DrawingShadowType type;
    /**
     * 그림자 색
     */
    private String color;
    /**
     * 그림자 간격 x, 단위는 hwpunit
     */
    private Integer offsetX;
    /**
     * 그림자 간격 y, 단위는 hwpunit
     */
    private Integer offsetY;
    /**
     * 투명도
     */
    private Float alpha;

    public DrawingShadow() {
    }

    @Override
    public ObjectType objectType() {
        return ObjectType.DrawingShadow;
    }

    public DrawingShadowType type() {
        return type;
    }

    public void type(DrawingShadowType type) {
        this.type = type;
    }

    public DrawingShadow typeAnd(DrawingShadowType type) {
        this.type = type;
        return this;
    }

    public String color() {
        return color;
    }

    public void color(String color) {
        this.color = color;
    }

    public DrawingShadow colorAnd(String color) {
        this.color = color;
        return this;
    }

    public Integer offsetX() {
        return offsetX;
    }

    public void offsetX(Integer offsetX) {
        this.offsetX = offsetX;
    }

    public DrawingShadow offsetXAnd(Integer offsetX) {
        this.offsetX = offsetX;
        return this;
    }

    public Integer offsetY() {
        return offsetY;
    }

    public void offsetY(Integer offsetY) {
        this.offsetY = offsetY;
    }

    public DrawingShadow offsetYAnd(Integer offsetY) {
        this.offsetY = offsetY;
        return this;
    }

    public Float alpha() {
        return alpha;
    }

    public void alpha(Float alpha) {
        this.alpha = alpha;
    }

    public DrawingShadow alphaAnd(Float alpha) {
        this.alpha = alpha;
        return this;
    }
}
