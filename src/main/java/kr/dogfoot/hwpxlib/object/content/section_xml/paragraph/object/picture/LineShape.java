package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.picture;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.LineType2;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.ArrowSize;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.ArrowType;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.LineCap;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.OutlineStyle;

/**
 * 선 모양
 */
public class LineShape extends HWPXObject {
    /**
     * 선 색
     */
    private String color;
    /**
     * 선 두께, 단위는 hwpunit
     */
    private Integer width;
    /**
     * 선 종류
     */
    private LineType2 style;
    /**
     * 선 끝 처리
     */
    private LineCap endCap;
    /**
     * 시작 화살표 모양
     */
    private ArrowType headStyle;
    /**
     * 끝 화살표 모양
     */
    private ArrowType tailStyle;
    /**
     * 시작 화살표 모양을 채울 것인지 여부 (원, 다이아몬드, 박스)
     */
    private Boolean headfill;
    /**
     * 끝 화살표 모양을 채울 것인지 여부 (원, 다이아몬드, 박스)
     */
    private Boolean tailfill;
    /**
     * 시작 화살표 크기
     */
    private ArrowSize headSz;
    /**
     * 끝 화살표 크기
     */
    private ArrowSize tailSz;
    /**
     * 테두리선 형태
     */
    private OutlineStyle outlineStyle;
    /**
     * 투명도
     */
    private Float alpha;

    public LineShape() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_lineShape;
    }

    public String color() {
        return color;
    }

    public void color(String color) {
        this.color = color;
    }

    public LineShape colorAnd(String color) {
        this.color = color;
        return this;
    }

    public Integer width() {
        return width;
    }

    public void width(Integer width) {
        this.width = width;
    }

    public LineShape widthAnd(Integer width) {
        this.width = width;
        return this;
    }

    public LineType2 style() {
        return style;
    }

    public void style(LineType2 style) {
        this.style = style;
    }

    public LineShape styleAnd(LineType2 style) {
        this.style = style;
        return this;
    }

    public LineCap endCap() {
        return endCap;
    }

    public void endCap(LineCap endCap) {
        this.endCap = endCap;
    }

    public LineShape endCapAnd(LineCap endCap) {
        this.endCap = endCap;
        return this;
    }

    public ArrowType headStyle() {
        return headStyle;
    }

    public void headStyle(ArrowType headStyle) {
        this.headStyle = headStyle;
    }

    public LineShape headStyleAnd(ArrowType headStyle) {
        this.headStyle = headStyle;
        return this;
    }

    public ArrowType tailStyle() {
        return tailStyle;
    }

    public void tailStyle(ArrowType tailStyle) {
        this.tailStyle = tailStyle;
    }

    public LineShape tailStyleAnd(ArrowType tailStyle) {
        this.tailStyle = tailStyle;
        return this;
    }

    public Boolean headfill() {
        return headfill;
    }

    public void headfill(Boolean headfill) {
        this.headfill = headfill;
    }

    public LineShape headfillAnd(Boolean headfill) {
        this.headfill = headfill;
        return this;
    }

    public Boolean tailfill() {
        return tailfill;
    }

    public void tailfill(Boolean tailfill) {
        this.tailfill = tailfill;
    }

    public LineShape tailfillAnd(Boolean tailfill) {
        this.tailfill = tailfill;
        return this;
    }

    public ArrowSize headSz() {
        return headSz;
    }

    public void headSz(ArrowSize headSz) {
        this.headSz = headSz;
    }

    public LineShape headSzAnd(ArrowSize headSz) {
        this.headSz = headSz;
        return this;
    }

    public ArrowSize tailSz() {
        return tailSz;
    }

    public void tailSz(ArrowSize tailSz) {
        this.tailSz = tailSz;
    }

    public LineShape tailSzAnd(ArrowSize tailSz) {
        this.tailSz = tailSz;
        return this;
    }

    public OutlineStyle outlineStyle() {
        return outlineStyle;
    }

    public void outlineStyle(OutlineStyle outlineStyle) {
        this.outlineStyle = outlineStyle;
    }

    public LineShape outlineStyleAnd(OutlineStyle outlineStyle) {
        this.outlineStyle = outlineStyle;
        return this;
    }

    public Float alpha() {
        return alpha;
    }

    public void alpha(Float alpha) {
        this.alpha = alpha;
    }

    public LineShape alphaAnd(Float alpha) {
        this.alpha = alpha;
        return this;
    }
}
