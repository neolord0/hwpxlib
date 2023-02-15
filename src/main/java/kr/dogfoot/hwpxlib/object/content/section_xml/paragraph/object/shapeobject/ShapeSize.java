package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapeobject;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.HeightRelTo;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.WidthRelTo;

/**
 * 도형 크기
 */
public class ShapeSize extends HWPXObject {
    /**
     * 너비
     */
    private Integer width;
    /**
     * 너비 기준
     */
    private WidthRelTo widthRelTo;
    /**
     * 높이
     */
    private Integer height;
    /**
     * 높이 기준
     */
    private HeightRelTo heightRelTo;
    /**
     * 크기 보호 여부
     */
    private Boolean protect;

    public ShapeSize() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_sz;
    }

    public Integer width() {
        return width;
    }

    public void width(Integer width) {
        this.width = width;
    }

    public ShapeSize widthAnd(Integer width) {
        this.width = width;
        return this;
    }

    public WidthRelTo widthRelTo() {
        return widthRelTo;
    }

    public void widthRelTo(WidthRelTo widthRelTo) {
        this.widthRelTo = widthRelTo;
    }

    public ShapeSize widthRelToAnd(WidthRelTo widthRelTo) {
        this.widthRelTo = widthRelTo;
        return this;
    }

    public Integer height() {
        return height;
    }

    public ShapeSize heightAnd(Integer height) {
        this.height = height;
        return this;
    }

    public void height(Integer height) {
        this.height = height;
    }

    public HeightRelTo heightRelTo() {
        return heightRelTo;
    }

    public void heightRelTo(HeightRelTo heightRelTo) {
        this.heightRelTo = heightRelTo;
    }

    public ShapeSize heightRelToAnd(HeightRelTo heightRelTo) {
        this.heightRelTo = heightRelTo;
        return this;
    }

    public Boolean protect() {
        return protect;
    }

    public void protect(Boolean protect) {
        this.protect = protect;
    }

    public ShapeSize protectAnd(Boolean protect) {
        this.protect = protect;
        return this;
    }
}
