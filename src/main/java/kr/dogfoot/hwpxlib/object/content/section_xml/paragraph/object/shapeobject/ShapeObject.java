package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapeobject;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.baseobject.HasOnlyText;
import kr.dogfoot.hwpxlib.object.common.baseobject.LeftRightTopBottom;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.DropCapStyle;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.NumberingType;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.TextFlowSide;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.TextWrapMethod;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.RunItem;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.table.ParameterSet;

/**
 * Shape Object
 */
public abstract class ShapeObject<ChildType> extends RunItem {
    /**
     * 아이디
     */
    private String id;
    /**
     * z-order
     */
    private Integer zOrder;
    /**
     * 번호 종류
     */
    private NumberingType numberingType;
    /**
     * 본문과의 배치 방법
     */
    private TextWrapMethod textWrap;
    /**
     * 본문 위치
     */
    private TextFlowSide textFlow;
    /**
     * 객체 선택가능 여부
     */
    private Boolean lock;
    /**
     * 첫 글자 장식 방법
     */
    private DropCapStyle dropcapstyle;
    /**
     * 크기
     */
    private ShapeSize sz;
    /**
     * 위치
     */
    private ShapePosition pos;
    /**
     * 바깥 여백
     */
    private LeftRightTopBottom outMargin;
    /**
     * 캡션
     */
    private Caption caption;
    /**
     * 설명문
     */
    private HasOnlyText shapeComment;
    /**
     * parameterset
     */
    private ParameterSet parameterset;

    public String id() {
        return id;
    }

    public void id(String id) {
        this.id = id;
    }

    public ChildType idAnd(String id) {
        this.id = id;
        return (ChildType) this;
    }

    public Integer zOrder() {
        return zOrder;
    }

    public void zOrder(Integer zOrder) {
        this.zOrder = zOrder;
    }

    public ChildType zOrderAnd(Integer zOrder) {
        this.zOrder = zOrder;
        return (ChildType) this;
    }

    public NumberingType numberingType() {
        return numberingType;
    }

    public void numberingType(NumberingType numberingType) {
        this.numberingType = numberingType;
    }

    public ChildType numberingTypeAnd(NumberingType numberingType) {
        this.numberingType = numberingType;
        return (ChildType) this;
    }

    public TextWrapMethod textWrap() {
        return textWrap;
    }

    public void textWrap(TextWrapMethod textWrap) {
        this.textWrap = textWrap;
    }

    public ChildType textWrapAnd(TextWrapMethod textWrap) {
        this.textWrap = textWrap;
        return (ChildType) this;
    }

    public TextFlowSide textFlow() {
        return textFlow;
    }

    public void textFlow(TextFlowSide textFlow) {
        this.textFlow = textFlow;
    }

    public ChildType textFlowAnd(TextFlowSide textFlow) {
        this.textFlow = textFlow;
        return (ChildType) this;
    }

    public Boolean lock() {
        return lock;
    }

    public void lock(Boolean lock) {
        this.lock = lock;
    }

    public ChildType lockAnd(Boolean lock) {
        this.lock = lock;
        return (ChildType) this;
    }

    public DropCapStyle dropcapstyle() {
        return dropcapstyle;
    }

    public void dropcapstyle(DropCapStyle dropcapstyle) {
        this.dropcapstyle = dropcapstyle;
    }

    public ChildType dropcapstyleAnd(DropCapStyle dropcapstyle) {
        this.dropcapstyle = dropcapstyle;
        return (ChildType) this;
    }

    public ShapeSize sz() {
        return sz;
    }

    public void createSZ() {
        sz = new ShapeSize();
    }

    public void removeSZ() {
        sz = null;
    }

    public ShapePosition pos() {
        return pos;
    }

    public void createPos() {
        pos = new ShapePosition();
    }

    public void removePos() {
        pos = null;
    }

    public LeftRightTopBottom outMargin() {
        return outMargin;
    }

    public void createOutMargin() {
        outMargin = new LeftRightTopBottom(ObjectType.hp_outMargin);
    }

    public void removeOutMargin() {
        outMargin = null;
    }

    public Caption caption() {
        return caption;
    }

    public void createCaption() {
        caption = new Caption();
    }

    public void removeCaption() {
        caption = null;
    }

    public HasOnlyText shapeComment() {
        return shapeComment;
    }

    public void createShapeComment() {
        shapeComment = new HasOnlyText(ObjectType.hp_shapeComment);
    }

    public void removeShapeComment() {
        shapeComment = null;
    }

    public ParameterSet parameterset() {
        return parameterset;
    }

    public void createParameterset() {
        parameterset = new ParameterSet();
    }

    public void removeParameterset() {
        parameterset = null;
    }

    protected void copyFrom(ShapeObject from) {
        this.id = from.id;
        this.zOrder = from.zOrder;
        this.numberingType = from.numberingType;
        this.textWrap = from.textWrap;
        this.textFlow = from.textFlow;
        this.lock = from.lock;
        this.dropcapstyle = from.dropcapstyle;

        if (from.sz != null) {
            sz = from.sz.clone();
        } else {
            sz = null;
        }

        if (from.pos != null) {
            pos = from.pos.clone();
        } else {
            pos = null;
        }

        if (from.outMargin != null) {
            outMargin = from.outMargin.clone();
        } else {
            outMargin = null;
        }

        if (from.caption != null) {
            caption = from.caption.clone();
        } else {
            caption = null;
        }

        if (from.shapeComment != null) {
            shapeComment = from.shapeComment.clone();
        } else {
            shapeComment = null;
        }

        if (from.parameterset != null) {
            parameterset = from.parameterset.clone();
        } else {
            parameterset = null;
        }

        super.copyFrom(from);
    }
}
