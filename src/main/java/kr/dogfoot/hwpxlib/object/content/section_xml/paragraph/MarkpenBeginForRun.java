package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph;

import kr.dogfoot.hwpxlib.object.common.ObjectType;

/**
 * 형광펜 시작
 */
public class MarkpenBeginForRun extends RunItem {
    /**
     * 형광펜 색
     */
    private String color;

    public MarkpenBeginForRun() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_markpenBegin;
    }

    public String color() {
        return color;
    }

    public void color(String color) {
        this.color = color;
    }

    public MarkpenBeginForRun colorAnd(String color) {
        this.color = color;
        return this;
    }

    @Override
    public MarkpenBeginForRun clone() {
        MarkpenBeginForRun cloned = new MarkpenBeginForRun();
        cloned.copyFrom(this);
        return cloned;
    }

    public void copyFrom(MarkpenBeginForRun from) {
        this.color = from.color;

        super.copyFrom(from);
    }
}
