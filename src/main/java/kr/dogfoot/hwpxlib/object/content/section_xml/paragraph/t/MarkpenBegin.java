package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.t;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.TItem;

/**
 * 형광펜 시작
 */
public class MarkpenBegin extends TItem {
    /**
     * 형광펜 색
     */
    private String beginColor;

    public MarkpenBegin() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_markpenBegin;
    }

    public String beginColor() {
        return beginColor;
    }

    public void beginColor(String beginColor) {
        this.beginColor = beginColor;
    }

    public MarkpenBegin beginColorAnd(String beginColor) {
        this.beginColor = beginColor;
        return this;
    }

    @Override
    public MarkpenBegin clone() {
        MarkpenBegin cloned = new MarkpenBegin();
        cloned.copyFrom(this);
        return cloned;
    }

    public void copyFrom(MarkpenBegin from) {
        this.beginColor = from.beginColor;
    }
}
