package kr.dogfoot.hwpxlib.object.content.header_xml.references.borderfill;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.ImageEffect;

/**
 * 이미지 정보
 */
public class Image extends HWPXObject {
    /**
     * BinDataItem 요소의 아이디 참조값
     */
    private String binaryItemIDRef;
    /**
     * 밝기
     */
    private Integer bright;
    /**
     * 명암
     */
    private Integer contrast;
    /**
     * 효과
     */
    private ImageEffect effect;
    /**
     * 투명도
     */
    private Float alpha;

    public Image() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hc_img;
    }

    public String binaryItemIDRef() {
        return binaryItemIDRef;
    }

    public void binaryItemIDRef(String binaryItemIDRef) {
        this.binaryItemIDRef = binaryItemIDRef;
    }

    public Image binaryItemIDRefAnd(String binaryItemIDRef) {
        this.binaryItemIDRef = binaryItemIDRef;
        return this;
    }

    public Integer bright() {
        return bright;
    }

    public void bright(Integer bright) {
        this.bright = bright;
    }

    public Image brightAnd(Integer bright) {
        this.bright = bright;
        return this;
    }

    public Integer contrast() {
        return contrast;
    }

    public void contrast(Integer contrast) {
        this.contrast = contrast;
    }

    public Image contrastAnd(Integer contrast) {
        this.contrast = contrast;
        return this;
    }

    public ImageEffect effect() {
        return effect;
    }

    public void effect(ImageEffect effect) {
        this.effect = effect;
    }

    public Image effectAnd(ImageEffect effect) {
        this.effect = effect;
        return this;
    }

    public Float alpha() {
        return alpha;
    }

    public void alpha(Float alpha) {
        this.alpha = alpha;
    }

    public Image alphaAnd(Float alpha) {
        this.alpha = alpha;
        return this;
    }
}
