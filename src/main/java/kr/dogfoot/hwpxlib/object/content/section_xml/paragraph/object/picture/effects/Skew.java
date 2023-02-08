package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.picture.effects;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;

/**
 * 기울기
 */
public class Skew extends HWPXObject {
    /**
     * x축 기울기 각도(0~360)
     */
    private Float x;
    /**
     * y축 기울기 각도(0~360)
     */
    private Float y;

    public Skew() {
    }

    @Override
    public ObjectType objectType() {
        return ObjectType.Skew;
    }

    public Float x() {
        return x;
    }

    public void x(Float x) {
        this.x = x;
    }

    public Skew xAnd(Float x) {
        this.x = x;
        return this;
    }

    public Float y() {
        return y;
    }

    public void y(Float y) {
        this.y = y;
    }

    public Skew yAnd(Float y) {
        this.y = y;
        return this;
    }
}
