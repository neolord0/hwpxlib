package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.t.inner;

import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.TItem;

/**
 * 변경 추적 요소 형식
 */
public abstract class TrackChangeCore<ChildType> extends TItem {
    /**
     * 아이디
     */
    private String Id;
    /**
     * 변경 추적 아이디 참조 값
     */
    private String TcId;
    /**
     * 문단 끝 포함 여부
     */
    private Boolean paraend;

    public String Id() {
        return Id;
    }

    public void Id(String Id) {
        this.Id = Id;
    }

    public ChildType IdAnd(String Id) {
        this.Id = Id;
        return (ChildType) this;
    }

    public String TcId() {
        return TcId;
    }

    public void TcId(String TcId) {
        this.TcId = TcId;
    }

    public ChildType TcIdAnd(String TcId) {
        this.TcId = TcId;
        return (ChildType) this;
    }


    public Boolean paraend() {
        return paraend;
    }

    public void paraend(Boolean paraend) {
        this.paraend = paraend;
    }

    public ChildType paraendAnd(Boolean paraend) {
        this.paraend = paraend;
        return (ChildType) this;
    }
}
