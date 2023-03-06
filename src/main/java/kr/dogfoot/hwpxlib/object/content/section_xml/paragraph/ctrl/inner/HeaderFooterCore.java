package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.ctrl.inner;

import kr.dogfoot.hwpxlib.object.content.section_xml.SubList;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.ApplyPageType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.CtrlItem;

/**
 * 머리말/꼬리말
 */
public abstract class HeaderFooterCore<ChildType> extends CtrlItem {
    /**
     * 머리말/꼬리말을 식별하는 아이디
     */
    private String id;
    /**
     * 적용되는 페이지 타입
     */
    private ApplyPageType applyPageType;
    /**
     * 내부 문단 리스트
     */
    private SubList subList;

    public HeaderFooterCore() {
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

    public ApplyPageType applyPageType() {
        return applyPageType;
    }

    public void applyPageType(ApplyPageType applyPageType) {
        this.applyPageType = applyPageType;
    }

    public ChildType applyPageTypeAnd(ApplyPageType applyPageType) {
        this.applyPageType = applyPageType;
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
}
