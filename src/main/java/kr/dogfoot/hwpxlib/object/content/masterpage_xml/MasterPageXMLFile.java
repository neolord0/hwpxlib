package kr.dogfoot.hwpxlib.object.content.masterpage_xml;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.masterpage_xml.enumtype.MasterPageType;
import kr.dogfoot.hwpxlib.object.content.section_xml.SubList;

public class MasterPageXMLFile extends SwitchableObject {
    /**
     * 바탕쪽 설정 정보 식별자
     */
    private String id;
    /**
     * 바탕쪽이 적용되는 페이지
     */
    private MasterPageType type;
    /**
     * type=OPTIONAL_PAGE 일때 페이지 지정
     */
    private Integer pageNumber;
    /**
     * 기본 바탕쪽과 확장 바탕쪽이 겹쳐질지 여부
     */
    private Boolean pageDuplicate;
    /**
     * 바탕쪽을 앞으로 보내기 여부
     */
    private Boolean pageFront;
    /**
     * 내부 문단 리스트
     */
    private SubList subList;

    public MasterPageXMLFile() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.masterPage;
    }

    public String id() {
        return id;
    }

    public void id(String id) {
        this.id = id;
    }

    public MasterPageXMLFile idAnd(String id) {
        this.id = id;
        return this;
    }

    public MasterPageType type() {
        return type;
    }

    public void type(MasterPageType type) {
        this.type = type;
    }

    public MasterPageXMLFile typeAnd(MasterPageType type) {
        this.type = type;
        return this;
    }

    public Integer pageNumber() {
        return pageNumber;
    }

    public void pageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public MasterPageXMLFile pageNumberAnd(Integer pageNumber) {
        this.pageNumber = pageNumber;
        return this;
    }

    public Boolean pageDuplicate() {
        return pageDuplicate;
    }

    public void pageDuplicate(Boolean pageDuplicate) {
        this.pageDuplicate = pageDuplicate;
    }

    public MasterPageXMLFile pageDuplicateAnd(Boolean pageDuplicate) {
        this.pageDuplicate = pageDuplicate;
        return this;
    }

    public Boolean pageFront() {
        return pageFront;
    }

    public void pageFront(Boolean pageFront) {
        this.pageFront = pageFront;
    }

    public MasterPageXMLFile pageFrontAnd(Boolean pageFront) {
        this.pageFront = pageFront;
        return this;
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
