package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.baseobject.LeftRightTopBottom;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.borderfill.Image;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.picture.ImageDim;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.picture.ImageRect;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.picture.LineShape;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.picture.effects.Effects;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapecomponent.ShapeComponent;

/**
 * 그림
 */
public class Picture extends ShapeComponent<Picture> {
    /**
     * 그림 색상 반전 여부
     */
    private Boolean reverse;
    /**
     * 외곽선 모양
     */
    private LineShape lineShape;
    /**
     * 이미지 좌표
     */
    private ImageRect imgRect;
    /**
     * 이미지 자르기 정보
     */
    private LeftRightTopBottom imgClip;
    /**
     * 안쪽 여백
     */
    private LeftRightTopBottom inMargin;
    /**
     * 이미지 크기
     */
    private ImageDim imgDim;
    /**
     * 이미지 데이터
     */
    private Image img;
    /**
     * 이미지 효과
     */
    private Effects effects;

    public Picture() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_pic;
    }

    public Boolean reverse() {
        return reverse;
    }

    public void reverse(Boolean reverse) {
        this.reverse = reverse;
    }

    public Picture reverseAnd(Boolean reverse) {
        this.reverse = reverse;
        return this;
    }

    public LineShape lineShape() {
        return lineShape;
    }

    public void createLineShape() {
        lineShape = new LineShape();
    }

    public void removeLineShape() {
        lineShape = null;
    }

    public ImageRect imgRect() {
        return imgRect;
    }

    public void createImgRect() {
        imgRect = new ImageRect();
    }

    public void removeImgRect() {
        imgRect = null;
    }

    public LeftRightTopBottom imgClip() {
        return imgClip;
    }

    public void createImgClip() {
        imgClip = new LeftRightTopBottom(ObjectType.hp_imgClip);
    }

    public void removeImgClip() {
        imgClip = null;
    }

    public LeftRightTopBottom inMargin() {
        return inMargin;
    }

    public void createInMargin() {
        inMargin = new LeftRightTopBottom(ObjectType.hp_inMargin);
    }

    public void removeInMargin() {
        inMargin = null;
    }

    public ImageDim imgDim() {
        return imgDim;
    }

    public void createImgDim() {
        imgDim = new ImageDim();
    }

    public void removeImgDim() {
        imgDim = null;
    }

    public Image img() {
        return img;
    }

    public void createImg() {
        img = new Image();
    }

    public void removeImg() {
        img = null;
    }

    public Effects effects() {
        return effects;
    }

    public void createEffects() {
        effects = new Effects();
    }

    public void removeEffects() {
        effects = null;
    }

    @Override
    public Picture clone() {
        Picture cloned = new Picture();
        cloned.copyFrom(this);
        return cloned;
    }

    public void copyFrom(Picture from) {
        this.reverse = from.reverse;

        if (from.lineShape != null) {
            lineShape = from.lineShape.clone();
        } else {
            lineShape = null;
        }

        if (from.imgRect != null) {
            imgRect = from.imgRect.clone();
        } else {
            imgRect = null;
        }

        if (from.imgClip != null) {
            imgClip = from.imgClip.clone();
        } else {
            imgClip = null;
        }

        if (from.inMargin != null) {
            inMargin = from.inMargin.clone();
        } else {
            inMargin = null;
        }

        if (from.imgDim != null) {
            imgDim = from.imgDim.clone();
        } else {
            imgDim = null;
        }

        if (from.img != null) {
            img = from.img.clone();
        } else {
            img = null;
        }

        if (from.effects != null) {
            effects = from.effects.clone();
        } else {
            effects = null;
        }

        super.copyFrom(from);
    }
}

