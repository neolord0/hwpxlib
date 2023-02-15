package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.secpr.pagepr;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;

/**
 * 페이지 여백
 */
public class PageMargin extends HWPXObject {
    /**
     * 왼쪽 여백
     */
    private Integer left;
    /**
     * 오른쪽 여백
     */
    private Integer right;
    /**
     * 위쪽 여백
     */
    private Integer top;
    /**
     * 아래쪽 여백
     */
    private Integer bottom;
    /**
     * 머리말 여백
     */
    private Integer header;
    /**
     * 꼬리말 여백
     */
    private Integer footer;
    /**
     * 제책 여백
     */
    private Integer gutter;

    public PageMargin() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_margin;
    }

    public Integer left() {
        return left;
    }

    public void left(Integer left) {
        this.left = left;
    }

    public PageMargin leftAnd(Integer left) {
        this.left = left;
        return this;
    }

    public Integer right() {
        return right;
    }

    public void right(Integer right) {
        this.right = right;
    }

    public PageMargin rightAnd(Integer right) {
        this.right = right;
        return this;
    }

    public Integer top() {
        return top;
    }

    public void top(Integer top) {
        this.top = top;
    }

    public PageMargin topAnd(Integer top) {
        this.top = top;
        return this;
    }

    public Integer bottom() {
        return bottom;
    }

    public PageMargin bottom(Integer bottom) {
        this.bottom = bottom;
        return this;
    }

    public PageMargin bottomAnd(Integer bottom) {
        this.bottom = bottom;
        return this;
    }

    public Integer header() {
        return header;
    }

    public void header(Integer header) {
        this.header = header;
    }

    public PageMargin headerAnd(Integer header) {
        this.header = header;
        return this;
    }

    public Integer footer() {
        return footer;
    }

    public void footer(Integer footer) {
        this.footer = footer;
    }

    public PageMargin footerAnd(Integer footer) {
        this.footer = footer;
        return this;
    }

    public Integer gutter() {
        return gutter;
    }

    public void gutter(Integer gutter) {
        this.gutter = gutter;
    }

    public PageMargin gutterAnd(Integer gutter) {
        this.gutter = gutter;
        return this;
    }
}
