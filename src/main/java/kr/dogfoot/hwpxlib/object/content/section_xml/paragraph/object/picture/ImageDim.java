package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.picture;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;

/**
 * 이미지 크기
 */
public class ImageDim extends HWPXObject {
    /**
     * 너비, pixel * 75
     */
    private Long dimwidth;
    /**
     * 높이, pixel * 75
     */
    private Long dimheight;

    public ImageDim() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_imgDim;
    }

    public Long dimwidth() {
        return dimwidth;
    }

    public void dimwidth(Long dimwidth) {
        this.dimwidth = dimwidth;
    }

    public ImageDim dimwidthAnd(Long dimwidth) {
        this.dimwidth = dimwidth;
        return this;
    }

    public Long dimheight() {
        return dimheight;
    }

    public void dimheight(Long dimheight) {
        this.dimheight = dimheight;
    }

    public ImageDim dimheightAnd(Long dimheight) {
        this.dimheight = dimheight;
        return this;
    }

    @Override
    public ImageDim clone() {
        ImageDim cloned = new ImageDim();
        cloned.copyFrom(this);
        return cloned;
    }

    public void copyFrom(ImageDim from) {
        this.dimwidth = from.dimwidth;
        this.dimheight = from.dimheight;
    }
}
