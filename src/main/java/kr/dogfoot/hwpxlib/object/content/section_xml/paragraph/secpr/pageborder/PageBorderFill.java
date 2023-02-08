package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.secpr.pageborder;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.ApplyPageType;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.PageBorderPositionCriterion;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.PageFillArea;

/**
 * 쪽 테두리/배경 정보
 */
public class PageBorderFill extends SwitchableObject {
    /**
     * 적용되는 페이지 타입
     */
    private ApplyPageType type;
    /**
     * 테두리/배경 정보 아이디 참조값
     */
    private String borderFillIDRef;
    /**
     * 쪽 테두리 위치 기준
     */
    private PageBorderPositionCriterion textBorder;
    /**
     * 머리말 포함 여부
     */
    private Boolean headerInside;
    /**
     * 꼬리말 포함 여부
     */
    private Boolean footerInside;
    /**
     * 배경 위치 기준
     */
    private PageFillArea fillArea;
    /**
     * 테두리/배경 오프셋
     */
    private PageBorderFillOffset offset;

    public PageBorderFill() {
    }

    @Override
    public ObjectType objectType() {
        return ObjectType.PageBorderFill;
    }

    public ApplyPageType type() {
        return type;
    }

    public void type(ApplyPageType type) {
        this.type = type;
    }

    public PageBorderFill typeAnd(ApplyPageType type) {
        this.type = type;
        return this;
    }

    public String borderFillIDRef() {
        return borderFillIDRef;
    }

    public void borderFillIDRef(String borderFillIDRef) {
        this.borderFillIDRef = borderFillIDRef;
    }

    public PageBorderFill borderFillIDRefAnd(String borderFillIDRef) {
        this.borderFillIDRef = borderFillIDRef;
        return this;
    }

    public PageBorderPositionCriterion textBorder() {
        return textBorder;
    }

    public void textBorder(PageBorderPositionCriterion textBorder) {
        this.textBorder = textBorder;
    }

    public PageBorderFill textBorderAnd(PageBorderPositionCriterion textBorder) {
        this.textBorder = textBorder;
        return this;
    }

    public Boolean headerInside() {
        return headerInside;
    }

    public void headerInside(Boolean headerInside) {
        this.headerInside = headerInside;
    }

    public PageBorderFill headerInsideAnd(Boolean headerInside) {
        this.headerInside = headerInside;
        return this;
    }

    public Boolean footerInside() {
        return footerInside;
    }

    public void footerInside(Boolean footerInside) {
        this.footerInside = footerInside;
    }

    public PageBorderFill footerInsideAnd(Boolean footerInside) {
        this.footerInside = footerInside;
        return this;
    }

    public PageFillArea fillArea() {
        return fillArea;
    }

    public void fillArea(PageFillArea fillArea) {
        this.fillArea = fillArea;
    }

    public PageBorderFill fillAreaAnd(PageFillArea fillArea) {
        this.fillArea = fillArea;
        return this;
    }

    public PageBorderFillOffset offset() {
        return offset;
    }

    public void createOffset() {
        offset = new PageBorderFillOffset();
    }

    public void removeOffset() {
        offset = null;
    }
}
