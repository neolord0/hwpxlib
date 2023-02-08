package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.picture;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.baseobject.LeftRightTopBottom;

/**
 * 이미지 자르기 정보
 */
public class ImageClip extends LeftRightTopBottom<ImageClip> {
    public ImageClip() {
    }

    @Override
    public ObjectType objectType() {
        return ObjectType.ImgClip;
    }
}
