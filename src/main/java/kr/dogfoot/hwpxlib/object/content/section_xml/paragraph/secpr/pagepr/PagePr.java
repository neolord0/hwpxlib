package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.secpr.pagepr;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.GutterMethod;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.PageDirection;

public class PagePr extends SwitchableObject {
    /**
     * 용지 방향
     */
    private PageDirection landscape;
    /**
     * 가로 크기
     */
    private Integer width;
    /**
     * 세로 크기
     */
    private Integer height;
    /**
     * 제책 방벙(Gutter 여백 종류)
     */
    private GutterMethod gutterType;
    /**
     * 페이지 여벽
     */
    private PageMargin margin;

    public PagePr() {
    }

    @Override
    public ObjectType objectType() {
        return ObjectType.PagePr;
    }

    @Override
    public HWPXObject createChildWithElementName(String name) {
        if (ObjectType.PageMargin.equalElementName(name)) {
            return new PageMargin();
        }
        return null;
    }

    public PageDirection landscape() {
        return landscape;
    }

    public void landscape(PageDirection landscape) {
        this.landscape = landscape;
    }

    public PagePr landscapeAnd(PageDirection landscape) {
        this.landscape = landscape;
        return this;
    }

    public Integer width() {
        return width;
    }

    public void width(Integer width) {
        this.width = width;
    }

    public PagePr widthAnd(Integer width) {
        this.width = width;
        return this;
    }

    public Integer height() {
        return height;
    }

    public void height(Integer height) {
        this.height = height;
    }

    public PagePr heightAnd(Integer height) {
        this.height = height;
        return this;
    }

    public GutterMethod gutterType() {
        return gutterType;
    }

    public void gutterType(GutterMethod gutterType) {
        this.gutterType = gutterType;
    }

    public PagePr gutterTypeAnd(GutterMethod gutterType) {
        this.gutterType = gutterType;
        return this;
    }

    public PageMargin margin() {
        return margin;
    }

    public void createMargin() {
        margin = new PageMargin();
    }

    public void removeMargin() {
        margin = null;
    }
}
