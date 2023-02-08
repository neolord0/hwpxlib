package kr.dogfoot.hwpxlib.object.content.header_xml.references.borderfill;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
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
    public ObjectType objectType() {
        return ObjectType.ImgBrush;
    }

    @Override
    public HWPXObject createChildWithElementName(String name) {
        if (ObjectType.Img.equalElementName(name)) {
            return new Image();
        }
        return null;
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
}
