package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.picture.effects;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;

/**
 * 투명도
 */
public class Alpha extends HWPXObject {
    /**
     * 시작 위치 투명도
     */
    private Float start;
    /**
     * 끝 위치 투명도
     */
    private Float end;

    public Alpha() {
    }

    @Override
    public ObjectType objectType() {
        return ObjectType.Alpha;
    }

    public Float start() {
        return start;
    }

    public void start(Float start) {
        this.start = start;
    }

    public Alpha startAnd(Float start) {
        this.start = start;
        return this;
    }

    public Float end() {
        return end;
    }

    public void end(Float end) {
        this.end = end;
    }

    public Alpha endAnd(Float end) {
        this.end = end;
        return this;
    }
}
