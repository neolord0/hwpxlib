package kr.dogfoot.hwpxlib.object.content.header_xml.references.fontface;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.FontFamilyType;

/**
 * 폰트 상세 정보
 */
public class TypeInfo extends HWPXObject {
    /**
     * 폰트 계열
     */
    private FontFamilyType familyType;
    /**
     * 세리프 스타일
     */
    private String serifStyle;
    /**
     * 굵기
     */
    private Integer weight;
    /**
     * 비례
     */
    private Integer proportion;
    /**
     * 대조
     */
    private Integer contrast;
    /**
     * 스트로크 편차
     */
    private Integer strokeVariation;
    /**
     * 자획 유형
     */
    private Boolean armStyle;
    /**
     * 글자형
     */
    private Boolean letterform;
    /**
     * 중간선
     */
    private Boolean midline;
    /**
     * X-높이
     */
    private Integer xHeight;

    public TypeInfo() {
    }

    @Override
    public ObjectType objectType() {
        return ObjectType.TypeInfo;
    }

    public FontFamilyType familyType() {
        return familyType;
    }

    public void familyType(FontFamilyType familyType) {
        this.familyType = familyType;
    }

    public TypeInfo familyTypeAnd(FontFamilyType familyType) {
        this.familyType = familyType;
        return this;
    }

    public String serifStyle() {
        return serifStyle;
    }

    public void serifStyle(String serifStyle) {
        this.serifStyle = serifStyle;
    }

    public TypeInfo serifStyleAnd(String serifStyle) {
        this.serifStyle = serifStyle;
        return this;
    }

    public Integer weight() {
        return weight;
    }

    public void weight(Integer weight) {
        this.weight = weight;
    }

    public TypeInfo weightAnd(Integer weight) {
        this.weight = weight;
        return this;
    }

    public Integer proportion() {
        return proportion;
    }

    public void proportion(Integer proportion) {
        this.proportion = proportion;
    }

    public TypeInfo proportionAnd(Integer proportion) {
        this.proportion = proportion;
        return this;
    }

    public Integer contrast() {
        return contrast;
    }

    public void contrast(Integer contrast) {
        this.contrast = contrast;
    }

    public TypeInfo contrastAnd(Integer contrast) {
        this.contrast = contrast;
        return this;
    }

    public Integer strokeVariation() {
        return strokeVariation;
    }

    public void strokeVariation(Integer strokeVariation) {
        this.strokeVariation = strokeVariation;
    }

    public TypeInfo strokeVariationAnd(Integer strokeVariation) {
        this.strokeVariation = strokeVariation;
        return this;
    }

    public Boolean armStyle() {
        return armStyle;
    }

    public void armStyle(Boolean armStyle) {
        this.armStyle = armStyle;
    }

    public TypeInfo armStyleAnd(Boolean armStyle) {
        this.armStyle = armStyle;
        return this;
    }

    public Boolean letterform() {
        return letterform;
    }

    public void letterform(Boolean letterform) {
        this.letterform = letterform;
    }

    public TypeInfo letterformAnd(Boolean letterform) {
        this.letterform = letterform;
        return this;
    }

    public Boolean midline() {
        return midline;
    }

    public void midline(Boolean midline) {
        this.midline = midline;
    }

    public TypeInfo midlineAnd(Boolean midline) {
        this.midline = midline;
        return this;
    }

    public Integer xHeight() {
        return xHeight;
    }

    public void xHeight(Integer xHeight) {
        this.xHeight = xHeight;
    }

    public TypeInfo xHeightAnd(Integer xHeight) {
        this.xHeight = xHeight;
        return this;
    }
}
