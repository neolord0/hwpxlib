package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.secpr;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.PageStartON;

/**
 * 시작 번호 정보
 */
public class StartNum extends HWPXObject {
    /**
     * 시작 쪽번호 타입, "사용자 정의" 값이면 이 속성을 표현하지 않음
     */
    private PageStartON pageStartsOn;
    /**
     * 시작 쪽 번호 : pageStartsOn="사용자 정의" 일때만 사용됨, 나머지 값일떄는 0으로 설정함
     */
    private Integer page;
    /**
     * 그림 시작 번호, 0 이면 이어서, 1이상 이면 시작 번호
     */
    private Integer pic;
    /**
     * 표 시작 번호, 0 이면 이어서, 1이상 이면 시작 번호
     */
    private Integer tbl;
    /**
     * 수식 시작 번호,  0 이면 이어서, 1이상이면 시작 번호
     */
    private Integer equation;

    public StartNum() {
    }

    @Override
    public ObjectType objectType() {
        return ObjectType.StartNum;
    }

    public PageStartON pageStartsOn() {
        return pageStartsOn;
    }

    public void pageStartsOn(PageStartON pageStartsOn) {
        this.pageStartsOn = pageStartsOn;
    }

    public StartNum pageStartsOnAnd(PageStartON pageStartsOn) {
        this.pageStartsOn = pageStartsOn;
        return this;
    }

    public Integer page() {
        return page;
    }

    public void page(Integer page) {
        this.page = page;
    }

    public StartNum pageAnd(Integer page) {
        this.page = page;
        return this;
    }

    public Integer pic() {
        return pic;
    }

    public void pic(Integer pic) {
        this.pic = pic;
    }

    public StartNum picAnd(Integer pic) {
        this.pic = pic;
        return this;
    }

    public Integer tbl() {
        return tbl;
    }

    public void tbl(Integer tbl) {
        this.tbl = tbl;
    }

    public StartNum tblAnd(Integer tbl) {
        this.tbl = tbl;
        return this;
    }

    public Integer equation() {
        return equation;
    }

    public void equation(Integer equation) {
        this.equation = equation;
    }

    public StartNum equationAnd(Integer equation) {
        this.equation = equation;
        return this;
    }
}
