package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.picture.effects;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;

/**
 * 네온 효과
 */
public class EffectsGlow extends SwitchableObject {
    /**
     * 투명도
     */
    private Float alpha;
    /**
     * 네온 크기, 단위는 hwpunit
     */
    private Float radius;
    /**
     * 네온 색상
     */
    private EffectsColor effectsColor;

    public EffectsGlow() {
    }

    @Override
    public ObjectType objectType() {
        return ObjectType.EffectsGlow;
    }

    public Float alpha() {
        return alpha;
    }

    public void alpha(Float alpha) {
        this.alpha = alpha;
    }

    public EffectsGlow alphaAnd(Float alpha) {
        this.alpha = alpha;
        return this;
    }

    public Float radius() {
        return radius;
    }

    public void radius(Float radius) {
        this.radius = radius;
    }

    public EffectsGlow radiusAnd(Float radius) {
        this.radius = radius;
        return this;
    }

    public EffectsColor effectsColor() {
        return effectsColor;
    }

    public void createEffectsColor() {
        effectsColor = new EffectsColor();
    }

    public void removeEffectsColor() {
        effectsColor = null;
    }
}
