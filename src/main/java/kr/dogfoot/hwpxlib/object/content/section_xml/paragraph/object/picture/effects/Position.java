package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.picture.effects;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;

public class Position extends HWPXObject {
    /**
     * 시작 위치
     */
    private Float start;
    /**
     * 끝 위치
     */
    private Float end;

    public Position() {
    }

    @Override
    public ObjectType objectType() {
        return ObjectType.Pos;
    }

    public Float start() {
        return start;
    }

    public void start(Float start) {
        this.start = start;
    }

    public Position startAnd(Float start) {
        this.start = start;
        return this;
    }

    public Float end() {
        return end;
    }

    public void end(Float end) {
        this.end = end;
    }

    public Position endAnd(Float end) {
        this.end = end;
        return this;
    }
}
