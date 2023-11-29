package kr.dogfoot.hwpxlib.object.content.header_xml.references.borderfill;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.ImageBrushMode;

/**
 * 이미지 채우기 정보
 */
public class ImgBrush extends SwitchableObject {
    /**
     * 이미지 채우긴 방법
     */
    private ImageBrushMode mode;
    /**
     * 이미지 정보
     */
    private Image img;

    public ImgBrush() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hc_imgBrush;
    }

    public ImageBrushMode mode() {
        return mode;
    }

    public void mode(ImageBrushMode mode) {
        this.mode = mode;
    }

    public ImgBrush modeAnd(ImageBrushMode mode) {
        this.mode = mode;
        return this;
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

    @Override
    public ImgBrush clone() {
        ImgBrush cloned = new ImgBrush();
        cloned.copyFrom(this);
        return cloned;
    }

    public void copyFrom(ImgBrush from) {
        this.mode = from.mode;

        if (from.img != null) {
            img = from.img.clone();
        } else {
            img = null;
        }

        super.copyFrom(from);
    }
}
