package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapeobject;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.SubList;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.CaptionSide;

public class Caption extends SwitchableObject {
    /**
     * 캡션 방향
     */
    private CaptionSide side;
    /**
     * 바깥 여백까지 확대 할 건지 여부
     */
    private Boolean fullSz;
    /**
     * 캡션 폭, 방향이 왼쪽/오른쪽 일때 적용됨, 단위는 hwpunit
     */
    private Integer width;
    /**
     * 객체와의 간격, 단위는 hwpunit
     */
    private Integer gap;
    /**
     * 최대 폭
     */
    private Integer lastWidth;
    /**
     * 내부 문단 리스트
     */
    private SubList subList;

    public Caption() {
    }

    @Override
    public ObjectType objectType() {
        return ObjectType.Caption;
    }

    public CaptionSide side() {
        return side;
    }

    public void side(CaptionSide side) {
        this.side = side;
    }

    public Caption sideAnd(CaptionSide side) {
        this.side = side;
        return this;
    }

    public Boolean fullSz() {
        return fullSz;
    }

    public void fullSz(Boolean fullSz) {
        this.fullSz = fullSz;
    }

    public Caption fullSzAnd(Boolean fullSz) {
        this.fullSz = fullSz;
        return this;
    }

    public Integer width() {
        return width;
    }

    public void width(Integer width) {
        this.width = width;
    }

    public Caption widthAnd(Integer width) {
        this.width = width;
        return this;
    }

    public Integer gap() {
        return gap;
    }

    public void gap(Integer gap) {
        this.gap = gap;
    }

    public Caption gapAnd(Integer gap) {
        this.gap = gap;
        return this;
    }

    public Integer lastWidth() {
        return lastWidth;
    }

    public void lastWidth(Integer lastWidth) {
        this.lastWidth = lastWidth;
    }

    public Caption lastWidthAnd(Integer lastWidth) {
        this.lastWidth = lastWidth;
        return this;
    }

    public SubList subList() {
        return subList;
    }

    public void createSubList() {
        subList = new SubList();
    }

    public void removeSubList() {
        subList = null;
    }
}
