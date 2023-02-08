package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.secpr;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;

/**
 * 줄맞춤 정보
 */
public class Grid extends HWPXObject {
    /**
     * 줄 간격
     */
    private Integer lineGrid;
    /**
     * 글자 간격
     */
    private Integer charGrid;
    /**
     * 원고지 정서법 적용 여부
     */
    private Boolean wonggojiFormat;

    public Grid() {
    }

    @Override
    public ObjectType objectType() {
        return ObjectType.Grid;
    }

    public Integer lineGrid() {
        return lineGrid;
    }

    public void lineGrid(Integer lineGrid) {
        this.lineGrid = lineGrid;
    }

    public Grid lineGridAnd(Integer lineGrid) {
        this.lineGrid = lineGrid;
        return this;
    }

    public Integer charGrid() {
        return charGrid;
    }

    public void charGrid(Integer charGrid) {
        this.charGrid = charGrid;
    }

    public Grid charGridAnd(Integer charGrid) {
        this.charGrid = charGrid;
        return this;
    }

    public Boolean wonggojiFormat() {
        return wonggojiFormat;
    }

    public void wonggojiFormat(Boolean wonggojiFormat) {
        this.wonggojiFormat = wonggojiFormat;
    }

    public Grid wonggojiFormatAnd(Boolean wonggojiFormat) {
        this.wonggojiFormat = wonggojiFormat;
        return this;
    }
}
