package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.secpr;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.VisibilityOption;

/**
 * 감추기/보여주기 정보
 */
public class Visibility extends HWPXObject {
    /**
     * 첫 페이지에 머리말 감추기 여부
     */
    private Boolean hideFirstHeader;
    /**
     * 첫 페이지에 꼬리말 감추기 여부
     */
    private Boolean hideFirstFooter;
    /**
     * 첫 페이지에 바탕쪽 감추기 여부
     */
    private Boolean hideFirstMasterPage;
    /**
     * 페이지 테두리 보이기 옵션
     */
    private VisibilityOption border;
    /**
     * 페이지 배경 보이기 옵션
     */
    private VisibilityOption fill;
    /**
     * 첫 페이지에서 쪽번호 감추기 여부
     */
    private Boolean hideFirstPageNum;
    /**
     * 첫 페이지에서만 빈 줄 감추기 여부
     */
    private Boolean hideFirstEmptyLine;
    /**
     * 줄번호 보이기 여부
     */
    private Boolean showLineNumber;

    public Visibility() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_visibility;
    }

    public Boolean hideFirstHeader() {
        return hideFirstHeader;
    }

    public void hideFirstHeader(Boolean hideFirstHeader) {
        this.hideFirstHeader = hideFirstHeader;
    }

    public Visibility hideFirstHeaderAnd(Boolean hideFirstHeader) {
        this.hideFirstHeader = hideFirstHeader;
        return this;
    }

    public Boolean hideFirstFooter() {
        return hideFirstFooter;
    }

    public void hideFirstFooter(Boolean hideFirstFooter) {
        this.hideFirstFooter = hideFirstFooter;
    }

    public Visibility hideFirstFooterAnd(Boolean hideFirstFooter) {
        this.hideFirstFooter = hideFirstFooter;
        return this;
    }

    public Boolean hideFirstMasterPage() {
        return hideFirstMasterPage;
    }

    public void hideFirstMasterPage(Boolean hideFirstMasterPage) {
        this.hideFirstMasterPage = hideFirstMasterPage;
    }

    public Visibility hideFirstMasterPageAnd(Boolean hideFirstMasterPage) {
        this.hideFirstMasterPage = hideFirstMasterPage;
        return this;
    }

    public VisibilityOption border() {
        return border;
    }

    public void border(VisibilityOption border) {
        this.border = border;
    }

    public Visibility borderAnd(VisibilityOption border) {
        this.border = border;
        return this;
    }

    public VisibilityOption fill() {
        return fill;
    }

    public void fill(VisibilityOption fill) {
        this.fill = fill;
    }

    public Visibility fillAnd(VisibilityOption fill) {
        this.fill = fill;
        return this;
    }

    public Boolean hideFirstPageNum() {
        return hideFirstPageNum;
    }

    public void hideFirstPageNum(Boolean hideFirstPageNum) {
        this.hideFirstPageNum = hideFirstPageNum;
    }

    public Visibility hideFirstPageNumAnd(Boolean hideFirstPageNum) {
        this.hideFirstPageNum = hideFirstPageNum;
        return this;
    }

    public Boolean hideFirstEmptyLine() {
        return hideFirstEmptyLine;
    }

    public void hideFirstEmptyLine(Boolean hideFirstEmptyLine) {
        this.hideFirstEmptyLine = hideFirstEmptyLine;
    }

    public Visibility hideFirstEmptyLineAnd(Boolean hideFirstEmptyLine) {
        this.hideFirstEmptyLine = hideFirstEmptyLine;
        return this;
    }

    public Boolean showLineNumber() {
        return showLineNumber;
    }

    public void showLineNumber(Boolean showLineNumber) {
        this.showLineNumber = showLineNumber;
    }

    public Visibility showLineNumberAnd(Boolean showLineNumber) {
        this.showLineNumber = showLineNumber;
        return this;
    }

    @Override
    public Visibility clone() {
        Visibility cloned = new Visibility();
        cloned.copyFrom(this);
        return cloned;
    }

    public void copyFrom(Visibility from) {
        this.hideFirstHeader = from.hideFirstHeader;
        this.hideFirstFooter = from.hideFirstFooter;
        this.hideFirstMasterPage = from.hideFirstMasterPage;
        this.border = from.border;
        this.fill = from.fill;
        this.hideFirstPageNum = from.hideFirstPageNum;
        this.hideFirstEmptyLine = from.hideFirstEmptyLine;
        this.showLineNumber = from.showLineNumber;
    }
}
