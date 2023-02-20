package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapecomponent;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;

public class RotationInfo extends HWPXObject {
    /**
     * 회전각
     */
    private Short angle;
    /**
     * 회전 중심의 x좌표
     */
    private Long centerX;
    /**
     * 회전 중심의 y좌표
     */
    private Long centerY;
    /**
     * 이미지 회전 여부
     */
    private Boolean rotateImage;

    public RotationInfo() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_rotationInfo;
    }

    public Short angle() {
        return angle;
    }

    public void angle(Short angle) {
        this.angle = angle;
    }

    public RotationInfo angleAnd(Short angle) {
        this.angle = angle;
        return this;
    }

    public Long centerX() {
        return centerX;
    }

    public void centerX(Long centerX) {
        this.centerX = centerX;
    }

    public RotationInfo centerXAnd(Long centerX) {
        this.centerX = centerX;
        return this;
    }

    public Long centerY() {
        return centerY;
    }

    public void centerY(Long centerY) {
        this.centerY = centerY;
    }

    public RotationInfo centerYAnd(Long centerY) {
        this.centerY = centerY;
        return this;
    }

    public Boolean rotateImage() {
        return rotateImage;
    }

    public void rotateImage(Boolean rotateImage) {
        this.rotateImage = rotateImage;
    }

    public RotationInfo rotateImageAnd(Boolean rotateImage) {
        this.rotateImage = rotateImage;
        return this;
    }
}
