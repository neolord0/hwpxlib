package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.ctrl;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.ColumnDirection;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.MultiColumnType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.CtrlItem;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.ctrl.inner.ColLine;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.ctrl.inner.ColSz;

import java.util.ArrayList;

/**
 * 단 정의
 */
public class ColPr extends CtrlItem {
    /**
     * 아이디
     */
    private String id;
    /**
     * 다단 정의
     */
    private MultiColumnType type;
    /**
     * 다단 방향
     */
    private ColumnDirection layout;
    /**
     * 단 개수
     */
    private Integer colCount;
    /**
     * 단 너비 동일하게 지정 여부
     */
    private Boolean sameSz;
    /**
     * 단 너비가 같을 때 단 사이에 간격, 단위는 hwpunit
     */
    private Integer sameGap;
    /**
     * 각 단의 크기 및 사이 간격 리스트
     */
    private final ArrayList<ColSz> colSzList;
    /**
     * 구분선
     */
    private ColLine colLine;

    public ColPr() {
        colSzList = new ArrayList<ColSz>();
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_colPr;
    }

    public String id() {
        return id;
    }

    public void id(String id) {
        this.id = id;
    }

    public ColPr idAnd(String id) {
        this.id = id;
        return this;
    }

    public MultiColumnType type() {
        return type;
    }

    public void type(MultiColumnType type) {
        this.type = type;
    }

    public ColPr typeAnd(MultiColumnType type) {
        this.type = type;
        return this;
    }

    public ColumnDirection layout() {
        return layout;
    }

    public void layout(ColumnDirection layout) {
        this.layout = layout;
    }

    public ColPr layoutAnd(ColumnDirection layout) {
        this.layout = layout;
        return this;
    }

    public Integer colCount() {
        return colCount;
    }

    public void colCount(Integer colCount) {
        this.colCount = colCount;
    }

    public ColPr colCountAnd(Integer colCount) {
        this.colCount = colCount;
        return this;
    }

    public Boolean sameSz() {
        return sameSz;
    }

    public void sameSz(Boolean sameSz) {
        this.sameSz = sameSz;
    }

    public ColPr sameSzAnd(Boolean sameSz) {
        this.sameSz = sameSz;
        return this;
    }

    public Integer sameGap() {
        return sameGap;
    }

    public void sameGap(Integer sameGap) {
        this.sameGap = sameGap;
    }

    public ColPr sameGapAnd(Integer sameGap) {
        this.sameGap = sameGap;
        return this;
    }

    public int countOfColSz() {
        return colSzList.size();
    }

    public ColSz getColSz(int index) {
        return colSzList.get(index);
    }

    public int getColSzIndex(ColSz colSz) {
        int count = colSzList.size();
        for (int index = 0; index < count; index++) {
            if (colSzList.get(index) == colSz) {
                return index;
            }
        }
        return -1;
    }

    public void addColSz(ColSz colSz) {
        colSzList.add(colSz);
    }

    public ColSz addNewColSz() {
        ColSz colSz = new ColSz();
        colSzList.add(colSz);
        return colSz;
    }

    public void insertColSz(ColSz colSz, int position) {
        colSzList.add(position, colSz);
    }

    public void removeColSz(int position) {
        colSzList.remove(position);
    }

    public void removeColSz(ColSz colSz) {
        colSzList.remove(colSz);
    }

    public void removeAllColSz() {
        colSzList.clear();
    }

    public Iterable<ColSz> colSzs() {
        return colSzList;
    }

    public ColLine colLine() {
        return colLine;
    }

    public void createColLine() {
        colLine = new ColLine();
    }

    public void removeColLine() {
        colLine = null;
    }

    @Override
    public ColPr clone() {
        ColPr cloned = new ColPr();
        cloned.copyFrom(this);
        return cloned;
    }

    public void copyFrom(ColPr from) {
        this.id = from.id;
        this.type = from.type;
        this.layout = from.layout;
        this.colCount = from.colCount;
        this.sameSz = from.sameSz;
        this.sameGap = from.sameGap;

        for (ColSz colSz : from.colSzList) {
            colSzList.add(colSz.clone());
        }

        if (from.colLine != null) {
            colLine = from.colLine.clone();
        } else {
            colLine = null;
        }

        super.copyFrom(from);
    }
}
