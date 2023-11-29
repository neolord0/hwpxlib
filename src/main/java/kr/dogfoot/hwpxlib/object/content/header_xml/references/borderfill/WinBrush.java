package kr.dogfoot.hwpxlib.object.content.header_xml.references.borderfill;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.HatchStyle;

/**
 * 기본 채우기 정보
 */
public class WinBrush extends HWPXObject {
    /**
     * 면 색
     */
    private String faceColor;
    /**
     * 무늬 색
     */
    private String hatchColor;
    /**
     * 무늬 종류
     */
    private HatchStyle hatchStyle;
    /**
     * 투명도
     */
    private Float alpha;

    public WinBrush() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hc_winBrush;
    }

    public String faceColor() {
        return faceColor;
    }

    public void faceColor(String faceColor) {
        this.faceColor = faceColor;
    }

    public WinBrush faceColorAnd(String faceColor) {
        this.faceColor = faceColor;
        return this;
    }

    public String hatchColor() {
        return hatchColor;
    }

    public void hatchColor(String hatchColor) {
        this.hatchColor = hatchColor;
    }

    public WinBrush hatchColorAnd(String hatchColor) {
        this.hatchColor = hatchColor;
        return this;
    }

    public HatchStyle hatchStyle() {
        return hatchStyle;
    }

    public void hatchStyle(HatchStyle hatchStyle) {
        this.hatchStyle = hatchStyle;
    }

    public WinBrush hatchStyleAnd(HatchStyle hatchStyle) {
        this.hatchStyle = hatchStyle;
        return this;
    }

    public Float alpha() {
        return alpha;
    }

    public void alpha(Float alpha) {
        this.alpha = alpha;
    }

    public WinBrush alphaAnd(Float alpha) {
        this.alpha = alpha;
        return this;
    }

    @Override
    public WinBrush clone() {
        WinBrush cloned = new WinBrush();
        cloned.copyFrom(this);
        return cloned;
    }

    public void copyFrom(WinBrush from) {
        this.faceColor = from.faceColor;
        this.hatchColor = from.hatchColor;
        this.hatchStyle = from.hatchStyle;
        this.alpha = from.alpha;
    }
}
