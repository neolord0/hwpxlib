package kr.dogfoot.hwpxlib.object.content.section_xml;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.LineWrapMethod;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.TextDirection;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.VerticalAlign2;

/**
 * 내부 문단 리스트
 */
public class SubList extends ParaListCore {
    /**
     * 아이디
     */
    private String id;
    /**
     * 텍스트 방향
     */
    private TextDirection textDirection;
    /**
     * 경계를 나누는 줄나눔 방식
     */
    private LineWrapMethod lineWrap;
    /**
     * 세로 정렬
     */
    private VerticalAlign2 vertAlign;
    /**
     * ??
     */
    private String linkListIDRef;
    /**
     * ??
     */
    private String linkListNextIDRef;
    /**
     * 텍스트 영역의 폭, 단위는 hwpunit
     */
    private Integer textWidth;
    /**
     * 텍스트 영역의 높이, 단위는 hwpunit
     */
    private Integer textHeight;
    /**
     * 해당 레벨의 텍스트에 대한 참조를 했는지 여부
     */
    private Boolean hasTextRef;
    /**
     * 해당 레벨의 번호에 대한 참조를 했는지 여부
     */
    private Boolean hasNumRef;

    public SubList() {
    }

    @Override
    public ObjectType objectType() {
        return ObjectType.SubList;
    }

    public String id() {
        return id;
    }

    public void id(String id) {
        this.id = id;
    }

    public SubList idAnd(String id) {
        this.id = id;
        return this;
    }

    public TextDirection textDirection() {
        return textDirection;
    }

    public void textDirection(TextDirection textDirection) {
        this.textDirection = textDirection;
    }

    public SubList textDirectionAnd(TextDirection textDirection) {
        this.textDirection = textDirection;
        return this;
    }

    public LineWrapMethod lineWrap() {
        return lineWrap;
    }

    public void lineWrap(LineWrapMethod lineWrap) {
        this.lineWrap = lineWrap;
    }

    public SubList lineWrapAnd(LineWrapMethod lineWrap) {
        this.lineWrap = lineWrap;
        return this;
    }

    public VerticalAlign2 vertAlign() {
        return vertAlign;
    }

    public void vertAlign(VerticalAlign2 vertAlign) {
        this.vertAlign = vertAlign;
    }

    public SubList vertAlignAnd(VerticalAlign2 vertAlign) {
        this.vertAlign = vertAlign;
        return this;
    }

    public String linkListIDRef() {
        return linkListIDRef;
    }

    public void linkListIDRef(String linkListIDRef) {
        this.linkListIDRef = linkListIDRef;
    }

    public SubList linkListIDRefAnd(String linkListIDRef) {
        this.linkListIDRef = linkListIDRef;
        return this;
    }

    public String linkListNextIDRef() {
        return linkListNextIDRef;
    }

    public void linkListNextIDRef(String linkListNextIDRef) {
        this.linkListNextIDRef = linkListNextIDRef;
    }

    public SubList linkListNextIDRefAnd(String linkListNextIDRef) {
        this.linkListNextIDRef = linkListNextIDRef;
        return this;
    }

    public Integer textWidth() {
        return textWidth;
    }

    public void textWidth(Integer textWidth) {
        this.textWidth = textWidth;
    }

    public SubList textWidthAnd(Integer textWidth) {
        this.textWidth = textWidth;
        return this;
    }

    public Integer textHeight() {
        return textHeight;
    }

    public void textHeight(Integer textHeight) {
        this.textHeight = textHeight;
    }

    public SubList textHeightAnd(Integer textHeight) {
        this.textHeight = textHeight;
        return this;
    }

    public Boolean hasTextRef() {
        return hasTextRef;
    }

    public void hasTextRef(Boolean hasTextRef) {
        this.hasTextRef = hasTextRef;
    }

    public SubList hasTextRefAnd(Boolean hasTextRef) {
        this.hasTextRef = hasTextRef;
        return this;
    }

    public Boolean hasNumRef() {
        return hasNumRef;
    }

    public void hasNumRef(Boolean hasNumRef) {
        this.hasNumRef = hasNumRef;
    }

    public SubList hasNumRefAnd(Boolean hasNumRef) {
        this.hasNumRef = hasNumRef;
        return this;
    }
}
