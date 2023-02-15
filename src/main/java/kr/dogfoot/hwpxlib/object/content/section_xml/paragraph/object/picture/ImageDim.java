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
    private Integer dimwidth;
    /**
     * 높이, pixel * 75
     */
    private Integer dimheight;

    public ImageDim() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_imgDim;
    }

    public Integer dimwidth() {
        return dimwidth;
    }

    public void dimwidth(Integer dimwidth) {
        this.dimwidth = dimwidth;
    }

    public ImageDim dimwidthAnd(Integer dimwidth) {
        this.dimwidth = dimwidth;
        return this;
    }

    public Integer dimheight() {
        return dimheight;
    }

    public void dimheight(Integer dimheight) {
        this.dimheight = dimheight;
    }

    public ImageDim dimheightAnd(Integer dimheight) {
        this.dimheight = dimheight;
        return this;
    }
}
