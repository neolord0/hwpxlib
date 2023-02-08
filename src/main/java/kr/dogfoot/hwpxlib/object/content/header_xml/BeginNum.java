package kr.dogfoot.hwpxlib.object.content.header_xml;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;

/**
 * 시작 번호 정보
 */
public class BeginNum extends HWPXObject {
    /**
     * 패이지 시작 번호
     */
    private Integer page;
    /**
     * 각주 시작 번호
     */
    private Integer footnote;
    /**
     * 미주 시작 번호
     */
    private Integer endnote;
    /**
     * 그림 시작 번호
     */
    private Integer pic;
    /**
     * 표 시작 번호
     */
    private Integer tbl;
    /**
     * 수식 시작 번호
     */
    private Integer equation;

    public BeginNum() {
    }

    @Override
    public ObjectType objectType() {
        return ObjectType.BeginNum;
    }

    public Integer page() {
        return page;
    }

    public void page(Integer page) {
        this.page = page;
    }

    public BeginNum pageAnd(Integer page) {
        this.page = page;
        return this;
    }

    public Integer footnote() {
        return footnote;
    }

    public void footnote(Integer footnote) {
        this.footnote = footnote;
    }

    public BeginNum footnoteAnd(Integer footnote) {
        this.footnote = footnote;
        return this;
    }

    public Integer endnote() {
        return endnote;
    }

    public void endnote(Integer endnote) {
        this.endnote = endnote;
    }

    public BeginNum endnoteAnd(Integer endnote) {
        this.endnote = endnote;
        return this;
    }

    public Integer pic() {
        return pic;
    }

    public void pic(Integer pic) {
        this.pic = pic;
    }

    public BeginNum picAnd(Integer pic) {
        this.pic = pic;
        return this;
    }

    public Integer tbl() {
        return tbl;
    }

    public void tbl(Integer tbl) {
        this.tbl = tbl;
    }

    public BeginNum tblAnd(Integer tbl) {
        this.tbl = tbl;
        return this;
    }

    public Integer equation() {
        return equation;
    }

    public void equation(Integer equation) {
        this.equation = equation;
    }

    public BeginNum equationAnd(Integer equation) {
        this.equation = equation;
        return this;
    }
}
