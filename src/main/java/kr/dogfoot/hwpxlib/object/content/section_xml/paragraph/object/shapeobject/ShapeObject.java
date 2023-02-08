package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapeobject;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectList;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.DropCapStyle;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.NumberingType;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.TextFlowSide;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.TextWrapMethod;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.RunItem;

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
    private OutMargin outMargin;
    /**
     * 캡션
     */
    private Caption caption;
    /**
     * 설명문
     */
    private ShapeComment shapeComment;

    @Override
    public HWPXObject createChildWithElementName(String name) {
        if (ObjectType.ShapeSz.equalElementName(name)) {
            return new ShapeSize();
        } else if (ObjectType.ShapePos.equalElementName(name)) {
            return new ShapePosition();
        } else if (ObjectType.OutMargin.equalElementName(name)) {
            return new OutMargin();
        } else if (ObjectType.Caption.equalElementName(name)) {
            return new Caption();
        } else if (ObjectType.ShapeComment.equalElementName(name)) {
            return new ShapeComment();
        }
        return null;
    }

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

    public OutMargin outMargin() {
        return outMargin;
    }

    public void createOutMargin() {
        outMargin = new OutMargin();
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

    public ShapeComment shapeComment() {
        return shapeComment;
    }

    public void createShapeComment() {
        shapeComment = new ShapeComment();
    }

    public void removeShapeComment() {
        shapeComment = null;
    }
}
