package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object;

import kr.dogfoot.hwpxlib.object.common.ObjectList;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.baseobject.LeftRightTopBottom;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.TablePageBreak;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapeobject.ShapeObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.table.CellZone;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.table.ParameterSet;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.table.Tr;

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
     * 행 개수
     */
    private Short rowCnt;
    /**
     * 열 개수
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
    private LeftRightTopBottom inMargin;
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
    public ObjectType _objectType() {
        return ObjectType.hp_tbl;
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

    public LeftRightTopBottom inMargin() {
        return inMargin;
    }

    public void createInMargin() {
        inMargin = new LeftRightTopBottom(ObjectType.hp_inMargin);
    }

    public void removeInMargin() {
        inMargin = null;
    }

    public ObjectList<CellZone> cellzoneList() {
        return cellzoneList;
    }

    public void createCellzoneList() {
        cellzoneList = new ObjectList<CellZone>(ObjectType.hp_cellzoneList, CellZone.class);
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

    public int getTrIndex(Tr tr) {
        int count = trList.size();
        for (int index = 0; index < count; index++) {
            if (trList.get(index) == tr) {
                return index;
            }
        }
        return -1;
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

    public void removeTr(Tr tr) {
        trList.remove(tr);
    }

    public Iterable<Tr> trs() {
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

    @Override
    public Table clone() {
        Table cloned = new Table();
        cloned.copyFrom(this);
        return cloned;
    }

    public void copyFrom(Table from) {
        this.pageBreak = from.pageBreak;
        this.repeatHeader = from.repeatHeader;
        this.rowCnt = from.rowCnt;
        this.colCnt = from.colCnt;
        this.cellSpacing = from.cellSpacing;
        this.borderFillIDRef = from.borderFillIDRef;
        this.noAdjust = from.noAdjust;

        if (from.inMargin != null) {
            inMargin = from.inMargin.clone();
        } else {
            inMargin = null;
        }

        if (from.cellzoneList != null) {
            createCellzoneList();
            for (CellZone cellZone : from.cellzoneList.items()) {
                cellzoneList.add(cellZone.clone());
            }
        } else {
            removeCellzoneList();
        }

        for (Tr tr : from.trList) {
            trList.add(tr.clone());
        }

        if (from.parameterSet != null) {
            parameterSet = from.parameterSet.clone();
        } else {
            parameterSet = null;
        }

        super.copyFrom(from);
    }
}
