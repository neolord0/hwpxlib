package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.picture.effects;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;

/**
 * 확대/축소 비율
 */
public class Scale extends HWPXObject {
    /**
     * x축 확대/축소 비율
     */
    private Float x;
    /**
     * y축 확대/축소 비율
     */
    private Float y;

    public Scale() {
    }

    @Override
    public ObjectType objectType() {
        return ObjectType.Scale;
    }

    public Float x() {
        return x;
    }

    public void x(Float x) {
        this.x = x;
    }

    public Scale xAnd(Float x) {
        this.x = x;
        return this;
    }

    public Float y() {
        return y;
    }

    public void y(Float y) {
        this.y = y;
    }

    public Scale yAnd(Float y) {
        this.y = y;
        return this;
    }
}
