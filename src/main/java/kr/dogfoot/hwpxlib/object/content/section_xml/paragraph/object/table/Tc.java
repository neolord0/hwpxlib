package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.table;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.SubList;

/**
 * 셀
 */
public class Tc extends SwitchableObject {
    /**
     * 필드명
     */
    private String name;
    /**
     * 제목셀 인지 여부
     */
    private Boolean header;
    /**
     * 셀 여백을 가지고 있는지 여부
     */
    private Boolean hasMargin;
    /**
     * 사용자 편집을 막을 건지 여부
     */
    private Boolean protect;
    /**
     * 읽기 전용 상태에서 편집 가능한지 여부
     */
    private Boolean editable;
    /**
     * 마지막 업데이트 후에 편집 했는지 여부
     */
    private Boolean dirty;
    /**
     * 테두리/베경 아이디 참조값
     */
    private String borderFillIDRef;
    /**
     * 주소
     */
    private CellAddr cellAddr;
    /**
     * 병합수
     */
    private CellSpan cellSpan;
    /**
     * 크기
     */
    private CellSize cellSz;
    /**
     * 여백
     */
    private CellMargin cellMargin;
    /**
     * 내부 문단 리스트
     */
    private SubList subList;

    public Tc() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_tc;
    }

    public String name() {
        return name;
    }

    public void name(String name) {
        this.name = name;
    }

    public Tc nameAnd(String name) {
        this.name = name;
        return this;
    }

    public Boolean header() {
        return header;
    }

    public void header(Boolean header) {
        this.header = header;
    }

    public Tc headerAnd(Boolean header) {
        this.header = header;
        return this;
    }

    public Boolean hasMargin() {
        return hasMargin;
    }

    public void hasMargin(Boolean hasMargin) {
        this.hasMargin = hasMargin;
    }

    public Tc hasMarginAnd(Boolean hasMargin) {
        this.hasMargin = hasMargin;
        return this;
    }

    public Boolean protect() {
        return protect;
    }

    public void protect(Boolean protect) {
        this.protect = protect;
    }

    public Tc protectAnd(Boolean protect) {
        this.protect = protect;
        return this;
    }

    public Boolean editable() {
        return editable;
    }

    public void editable(Boolean editable) {
        this.editable = editable;
    }

    public Tc editableAnd(Boolean editable) {
        this.editable = editable;
        return this;
    }

    public Boolean dirty() {
        return dirty;
    }

    public void dirty(Boolean dirty) {
        this.dirty = dirty;
    }

    public Tc dirtyAnd(Boolean dirty) {
        this.dirty = dirty;
        return this;
    }

    public String borderFillIDRef() {
        return borderFillIDRef;
    }

    public void borderFillIDRef(String borderFillIDRef) {
        this.borderFillIDRef = borderFillIDRef;
    }

    public Tc borderFillIDRefAnd(String borderFillIDRef) {
        this.borderFillIDRef = borderFillIDRef;
        return this;
    }

    public CellAddr cellAddr() {
        return cellAddr;
    }

    public void createCellAddr() {
        cellAddr = new CellAddr();
    }

    public void removeCellAddr() {
        cellAddr = new CellAddr();
    }

    public CellSpan cellSpan() {
        return cellSpan;
    }

    public void createCellSpan() {
        cellSpan = new CellSpan();
    }

    public void removeCellSpan() {
        cellSpan = null;
    }

    public CellSize cellSz() {
        return cellSz;
    }

    public void createCellSz() {
        cellSz = new CellSize();
    }

    public void removeCellSz() {
        cellSz = null;
    }

    public CellMargin cellMargin() {
        return cellMargin;
    }

    public void createCellMargin() {
        cellMargin = new CellMargin();
    }

    public void removeCellMargin() {
        cellMargin = null;
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
