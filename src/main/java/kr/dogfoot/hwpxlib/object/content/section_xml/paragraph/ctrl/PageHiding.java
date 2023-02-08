package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.ctrl;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.CtrlItem;

/**
 * 감추기
 */
public class PageHiding extends CtrlItem {
    /**
     * 머리말 감추기 여부
     */
    private Boolean hideHeader;
    /**
     * 꼬리말 감추기 여부
     */
    private Boolean hideFooter;
    /**
     * 바탕쪽 감추기 여부
     */
    private Boolean hideMasterPage;
    /**
     * 테두리 감추기 여부
     */
    private Boolean hideBorder;
    /**
     * 배경 감추기 여부
     */
    private Boolean hideFill;
    /**
     * 쪽 번호 감추기 여부
     */
    private Boolean hidePageNum;

    public PageHiding() {
    }

    @Override
    public ObjectType objectType() {
        return ObjectType.PageHiding;
    }

    public Boolean hideHeader() {
        return hideHeader;
    }

    public void hideHeader(Boolean hideHeader) {
        this.hideHeader = hideHeader;
    }

    public PageHiding hideHeaderAnd(Boolean hideHeader) {
        this.hideHeader = hideHeader;
        return this;
    }

    public Boolean hideFooter() {
        return hideFooter;
    }

    public void hideFooter(Boolean hideFooter) {
        this.hideFooter = hideFooter;
    }

    public PageHiding hideFooterAnd(Boolean hideFooter) {
        this.hideFooter = hideFooter;
        return this;
    }

    public Boolean hideMasterPage() {
        return hideMasterPage;
    }

    public void hideMasterPage(Boolean hideMasterPage) {
        this.hideMasterPage = hideMasterPage;
    }

    public PageHiding hideMasterPageAnd(Boolean hideMasterPage) {
        this.hideMasterPage = hideMasterPage;
        return this;
    }

    public Boolean hideBorder() {
        return hideBorder;
    }

    public void hideBorder(Boolean hideBorder) {
        this.hideBorder = hideBorder;
    }

    public PageHiding hideBorderAnd(Boolean hideBorder) {
        this.hideBorder = hideBorder;
        return this;
    }

    public Boolean hideFill() {
        return hideFill;
    }

    public void hideFill(Boolean hideFill) {
        this.hideFill = hideFill;
    }

    public PageHiding hideFillAnd(Boolean hideFill) {
        this.hideFill = hideFill;
        return this;
    }

    public Boolean hidePageNum() {
        return hidePageNum;
    }

    public void hidePageNum(Boolean hidePageNum) {
        this.hidePageNum = hidePageNum;
    }

    public PageHiding hidePageNumAnd(Boolean hidePageNum) {
        this.hidePageNum = hidePageNum;
        return this;
    }
}
