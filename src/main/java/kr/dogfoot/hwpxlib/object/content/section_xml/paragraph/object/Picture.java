package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.borderfill.Image;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.picture.ImageClip;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.picture.ImageDim;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.picture.ImageRect;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.picture.LineShape;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.picture.effects.Effects;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapecomponent.ShapeComponent;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.table.InMargin;

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
    private ImageClip imgClip;
    /**
     * 안쪽 여백
     */
    private InMargin inMargin;
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
    public ObjectType objectType() {
        return ObjectType.Pic;
    }

    @Override
    public HWPXObject createChildWithElementName(String name) {
        if (ObjectType.LineShape.equalElementName(name)) {
            return new LineShape();
        } else if (ObjectType.ImgRect.equalElementName(name)) {
            return new ImageRect();
        } else if (ObjectType.ImgClip.equalElementName(name)) {
            return new ImageClip();
        } else if (ObjectType.InMargin.equalElementName(name)) {
            return new InMargin();
        } else if (ObjectType.ImgDim.equalElementName(name)) {
            return new ImageDim();
        } else if (ObjectType.Img.equalElementName(name)) {
            return new Image();
        } else if (ObjectType.Effects.equalElementName(name)) {
            return new Effects();
        }
        return super.createChildWithElementName(name);
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

    public ImageClip imgClip() {
        return imgClip;
    }

    public void createImgClip() {
        imgClip = new ImageClip();
    }

    public void removeImgClip() {
        imgClip = null;
    }

    public InMargin inMargin() {
        return inMargin;
    }

    public void createInMargin() {
        inMargin = new InMargin();
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
}
