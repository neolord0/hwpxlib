package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.ctrl.inner;

import kr.dogfoot.hwpxlib.object.content.section_xml.SubList;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.CtrlItem;

/**
 * 각주/미주
 */
public abstract class FootNoteEndNoteCore<ChildType> extends CtrlItem {
    /**
     * 번호
     */
    private Integer number;
    /**
     * 뒤에 오는 문자
     */
    private String suffixChar;
    /**
     * 인스턴스 아이디
     */
    private String instId;
    /**
     * 내부 문단 리스트
     */
    private SubList subList;

    public Integer number() {
        return number;
    }

    public void number(Integer number) {
        this.number = number;
    }

    public ChildType numberAnd(Integer number) {
        this.number = number;
        return (ChildType) this;
    }

    public String suffixChar() {
        return suffixChar;
    }

    public void suffixChar(String suffixChar) {
        this.suffixChar = suffixChar;
    }

    public ChildType suffixCharAnd(String suffixChar) {
        this.suffixChar = suffixChar;
        return (ChildType) this;
    }

    public String instId() {
        return instId;
    }

    public void instId(String instId) {
        this.instId = instId;
    }

    public ChildType instIdAnd(String instId) {
        this.instId = instId;
        return (ChildType) this;
    }

    public SubList subList() {
        return subList;
    }

    public void createSubList() {
        subList = new SubList();
    }

    public void removeSubList() {
        subList = null;
    }

    protected void copyFrom(FootNoteEndNoteCore from) {
        this.number = from.number;
        this.suffixChar = from.suffixChar;
        this.instId = from.instId;

        if (from.subList != null) {
            subList = from.subList.clone();
        } else {
            subList = null;
        }

        super.copyFrom(from);
    }
}
