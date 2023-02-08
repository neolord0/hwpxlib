package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.t.inner;

import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.TItem;

/**
 * 변경 추적 요소 형식
 */
public abstract class TrackChangeTag<ChildType> extends TItem {
    /**
     * 아이디
     */
    private String id;
    /**
     * 변경 추적 아이디 참조 값
     */
    private Integer TcId;
    /**
     * 문단 끝 포함 여부
     */
    private Boolean paraEnd;

    public Boolean paraEnd() {
        return paraEnd;
    }

    public void paraEnd(Boolean paraEnd) {
        this.paraEnd = paraEnd;
    }

    public ChildType paraEndAnd(Boolean paraEnd) {
        this.paraEnd = paraEnd;
        return (ChildType) this;
    }

    public Integer TcId() {
        return TcId;
    }

    public void TcId(Integer TcId) {
        this.TcId = TcId;
    }

    public ChildType TcIdAnd(Integer TcId) {
        this.TcId = TcId;
        return (ChildType) this;
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
}
