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
    private Integer centerX;
    /**
     * 회전 중심의 y좌표
     */
    private Integer centerY;
    /**
     * 이미지 회전 여부
     */
    private Boolean rotateImage;

    public RotationInfo() {
    }

    @Override
    public ObjectType objectType() {
        return ObjectType.RotationInfo;
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

    public Integer centerX() {
        return centerX;
    }

    public void centerX(Integer centerX) {
        this.centerX = centerX;
    }

    public RotationInfo centerXAnd(Integer centerX) {
        this.centerX = centerX;
        return this;
    }

    public Integer centerY() {
        return centerY;
    }

    public void centerY(Integer centerY) {
        this.centerY = centerY;
    }

    public RotationInfo centerYAnd(Integer centerY) {
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
