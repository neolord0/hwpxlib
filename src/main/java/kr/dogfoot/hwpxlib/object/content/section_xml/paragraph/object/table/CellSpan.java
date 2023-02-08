package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.table;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;

/**
 * 셀 병합수
 */
public class CellSpan extends HWPXObject {
    /**
     * 열 병합수
     */
    private Short colSpan;
    /**
     * 행 병합수
     */
    private Short rowSpan;

    public CellSpan() {
    }

    @Override
    public ObjectType objectType() {
        return ObjectType.CellSpan;
    }

    public Short colSpan() {
        return colSpan;
    }

    public void colSpan(Short colSpan) {
        this.colSpan = colSpan;
    }

    public CellSpan colSpanAnd(Short colSpan) {
        this.colSpan = colSpan;
        return this;
    }

    public Short rowSpan() {
        return rowSpan;
    }

    public void rowSpan(Short rowSpan) {
        this.rowSpan = rowSpan;
    }

    public CellSpan rowSpanAnd(Short rowSpan) {
        this.rowSpan = rowSpan;
        return this;
    }
}
