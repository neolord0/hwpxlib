package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.ctrl.inner;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;

/**
 * 단의 크기와 사이 간격
 */
public class ColSz extends HWPXObject {
    /**
     * 단 크기
     */
    private Integer width;
    /**
     * 사이 간격
     */
    private Integer gap;

    public ColSz() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_colSz;
    }

    public Integer width() {
        return width;
    }

    public void width(Integer width) {
        this.width = width;
    }

    public ColSz widthAnd(Integer width) {
        this.width = width;
        return this;
    }

    public Integer gap() {
        return gap;
    }

    public void gap(Integer gap) {
        this.gap = gap;
    }

    public ColSz gapAnd(Integer gap) {
        this.gap = gap;
        return this;
    }
}
