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
    private Long width;
    /**
     * 객체와의 간격, 단위는 hwpunit
     */
    private Long gap;
    /**
     * 최대 폭
     */
    private Long lastWidth;
    /**
     * 내부 문단 리스트
     */
    private SubList subList;

    public Caption() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_caption;
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

    public Long width() {
        return width;
    }

    public void width(Long width) {
        this.width = width;
    }

    public Caption widthAnd(Long width) {
        this.width = width;
        return this;
    }

    public Long gap() {
        return gap;
    }

    public void gap(Long gap) {
        this.gap = gap;
    }

    public Caption gapAnd(Long gap) {
        this.gap = gap;
        return this;
    }

    public Long lastWidth() {
        return lastWidth;
    }

    public void lastWidth(Long lastWidth) {
        this.lastWidth = lastWidth;
    }

    public Caption lastWidthAnd(Long lastWidth) {
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

    @Override
    public Caption clone() {
        Caption cloned = new Caption();
        cloned.copyFrom(this);
        return cloned;
    }

    public void copyFrom(Caption from) {
        this.side = from.side;
        this.fullSz = from.fullSz;
        this.width = from.width;
        this.gap = from.gap;
        this.lastWidth = from.lastWidth;

        if (from.subList != null) {
            subList = from.subList.clone();
        } else {
            subList = null;
        }

        super.copyFrom(from);
   }
}

