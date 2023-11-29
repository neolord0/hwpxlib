package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.picture.effects;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;

/**
 * 이미지 효과
 */
public class Effects extends SwitchableObject {
    /**
     * 그림자 효과
     */
    private EffectsShadow shadow;
    /**
     * 네온 효과
     */
    private EffectsGlow glow;
    /**
     * 부드러운 가장자리 효과
     */
    private EffectsSoftEdge softEdge;
    /**
     * 반사 효과
     */
    private EffectsReflection reflection;

    public Effects() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_effects;
    }

    public EffectsShadow shadow() {
        return shadow;
    }

    public void createShadow() {
        shadow = new EffectsShadow();
    }

    public void removeShadow() {
        shadow = null;
    }

    public EffectsGlow glow() {
        return glow;
    }

    public void createGlow() {
        glow = new EffectsGlow();
    }

    public void removeGlow() {
        glow = new EffectsGlow();
    }

    public EffectsSoftEdge softEdge() {
        return softEdge;
    }

    public void createSoftEdge() {
        softEdge = new EffectsSoftEdge();
    }

    public void removeSoftEdge() {
        softEdge = null;
    }

    public EffectsReflection reflection() {
        return reflection;
    }

    public void createReflection() {
        reflection = new EffectsReflection();
    }

    public void removeReflection() {
        reflection = null;
    }

    @Override
    public Effects clone() {
        Effects cloned = new Effects();
        cloned.copyFrom(this);
        return cloned;
    }

    public void copyFrom(Effects from) {
        if (from.shadow != null) {
            shadow = from.shadow.clone();
        } else {
            shadow = null;
        }

        if (from.glow != null) {
            glow = from.glow.clone();
        } else {
            glow = null;
        }

        if  (from.softEdge != null) {
            softEdge = from.softEdge.clone();
        } else {
            softEdge = null;
        }

        if (from.reflection != null) {
            reflection = from.reflection.clone();
        } else {
            reflection = null;
        }

        super.copyFrom(from);
    }
}
