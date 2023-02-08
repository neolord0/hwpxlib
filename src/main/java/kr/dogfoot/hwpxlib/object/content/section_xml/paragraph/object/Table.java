package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectList;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.table.ParameterSet;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.TablePageBreak;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapeobject.ShapeObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.table.CellZone;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.table.InMargin;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.table.Tr;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.t.InsertEnd;

import java.util.ArrayList;

/**
 * 표
 */
public class Table extends ShapeObject<Table> {
    /**
     * 쪽 경계에서 나눔
     */
    private TablePageBreak pageBreak;
    /**
     * 제목행 반복 여부
     */
    private Boolean repeatHeader;
    /**
     * 열 개수
     */
    private Short rowCnt;
    /**
     * 행 개수
     */
    private Short colCnt;
    /**
     * 셀 간격, 단위는 hwpunit
     */
    private Integer cellSpacing;
    /**
     * 테두리/배경 아이디 참조
     */
    private String borderFillIDRef;
    /**
     * 셀 너비/높이 값을 최소 단위(1 pt)로 보정 여부
     */
    private Boolean noAdjust;
    /**
     * 안쪽 여백
     */
    private InMargin inMargin;
    /**
     * 셀 테두리/배경 - "하나의 셀처럼 적용"
     */
    private ObjectList<CellZone> cellzoneList;
    /**
     * 열 리스트
     */
    private final ArrayList<Tr> trList;
    /**
     * 라벨 쪽의 표를 위한 정보
     */
    private ParameterSet parameterSet;

    public Table() {
        trList = new ArrayList<Tr>();
    }

    @Override
    public ObjectType objectType() {
        return ObjectType.Tbl;
    }

    @Override
    public HWPXObject createChildWithElementName(String name) {
        if (ObjectType.InMargin.equalElementName(name)) {
            return new InMargin();
        } else if (ObjectType.CellZoneList.equalElementName(name)) {
            return new ObjectList<CellZone>(ObjectType.CellZoneList, CellZone.class);
        } else if (ObjectType.Tr.equalElementName(name)) {
            return new Tr();
        } else if (ObjectType.ParameterSet.equalElementName(name)) {
            return new ParameterSet();
        }
        return super.createChildWithElementName(name);
    }

    public TablePageBreak pageBreak() {
        return pageBreak;
    }

    public void pageBreak(TablePageBreak pageBreak) {
        this.pageBreak = pageBreak;
    }

    public Table pageBreakAnd(TablePageBreak pageBreak) {
        this.pageBreak = pageBreak;
        return this;
    }

    public Boolean repeatHeader() {
        return repeatHeader;
    }

    public void repeatHeader(Boolean repeatHeader) {
        this.repeatHeader = repeatHeader;
    }

    public Table repeatHeaderAnd(Boolean repeatHeader) {
        this.repeatHeader = repeatHeader;
        return this;
    }

    public Short rowCnt() {
        return rowCnt;
    }

    public void rowCnt(Short rowCnt) {
        this.rowCnt = rowCnt;
    }

    public Table rowCntAnd(Short rowCnt) {
        this.rowCnt = rowCnt;
        return this;
    }

    public Short colCnt() {
        return colCnt;
    }

    public void colCnt(Short colCnt) {
        this.colCnt = colCnt;
    }

    public Table colCntAnd(Short colCnt) {
        this.colCnt = colCnt;
        return this;
    }

    public Integer cellSpacing() {
        return cellSpacing;
    }

    public void cellSpacing(Integer cellSpacing) {
        this.cellSpacing = cellSpacing;
    }

    public Table cellSpacingAnd(Integer cellSpacing) {
        this.cellSpacing = cellSpacing;
        return this;
    }

    public String borderFillIDRef() {
        return borderFillIDRef;
    }

    public void borderFillIDRef(String borderFillIDRef) {
        this.borderFillIDRef = borderFillIDRef;
    }

    public Table borderFillIDRefAnd(String borderFillIDRef) {
        this.borderFillIDRef = borderFillIDRef;
        return this;
    }

    public Boolean noAdjust() {
        return noAdjust;
    }

    public void noAdjust(Boolean noAdjust) {
        this.noAdjust = noAdjust;
    }

    public Table noAdjustAnd(Boolean noAdjust) {
        this.noAdjust = noAdjust;
        return this;
    }

    public InMargin inMargin() {
        return inMargin;
    }

    public void createInMargin() {
        inMargin = new InMargin();
    }

    public void removeInMargin() {
        inMargin = null;
    }

    public ObjectList<CellZone> cellzoneList() {
        return cellzoneList;
    }

    public void createCellzoneList() {
        cellzoneList = new ObjectList<CellZone>(ObjectType.CellZoneList, CellZone.class);
    }

    public void removeCellzoneList() {
        cellzoneList = null;
    }

    public int countOfTr() {
        return trList.size();
    }

    public Tr getTr(int index) {
        return trList.get(index);
    }

    public void addTr(Tr tr) {
        trList.add(tr);
    }

    public Tr addNewTr() {
        Tr tr = new Tr();
        trList.add(tr);
        return tr;
    }

    public void insertTr(Tr tr, int position) {
        trList.add(position, tr);
    }

    public void removeTr(int position) {
        trList.remove(position);
    }

    public Iterable<Tr> Trs() {
        return trList;
    }

    public ParameterSet parameterSet() {
        return parameterSet;
    }

    public void createParameterSet() {
        parameterSet = new ParameterSet();
    }

    public void removeParameterSet() {
        parameterSet = null;
    }
}
