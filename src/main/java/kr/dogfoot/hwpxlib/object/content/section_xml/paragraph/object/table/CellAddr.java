package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.table;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;

/**
 * 셀 주소
 */
public class CellAddr extends HWPXObject {
    /**
     * 열 주소
     */
    private Short colAddr;
    /**
     * 행 주소
     */
    private Short rowAddr;

    public CellAddr() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_cellAddr;
    }

    public Short colAddr() {
        return colAddr;
    }

    public void colAddr(Short colAddr) {
        this.colAddr = colAddr;
    }

    public CellAddr colAddrAnd(Short colAddr) {
        this.colAddr = colAddr;
        return this;
    }

    public Short rowAddr() {
        return rowAddr;
    }

    public void rowAddr(Short rowAddr) {
        this.rowAddr = rowAddr;
    }

    public CellAddr rowAddrAnd(Short rowAddr) {
        this.rowAddr = rowAddr;
        return this;
    }
}
