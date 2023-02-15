package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.picture.effects;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;

/**
 * 부드러운 가장자리 효과
 */
public class EffectsSoftEdge extends HWPXObject {
    /**
     * 부드러운 가장자리 크기, 단위는 hwpunit
     */
    private Float radius;

    public EffectsSoftEdge() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_softEdge;
    }

    public Float radius() {
        return radius;
    }

    public void radius(Float radius) {
        this.radius = radius;
    }

    public EffectsSoftEdge radiusAnd(Float radius) {
        this.radius = radius;
        return this;
    }
}
