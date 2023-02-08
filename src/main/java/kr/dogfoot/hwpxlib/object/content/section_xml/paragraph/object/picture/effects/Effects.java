package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.picture.effects;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;

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
    public ObjectType objectType() {
        return ObjectType.Effects;
    }

    @Override
    public HWPXObject createChildWithElementName(String name) {
        if (ObjectType.EffectsShadow.equalElementName(name)) {
            return new EffectsShadow();
        } else if (ObjectType.EffectsGlow.equalElementName(name)) {
            return new EffectsGlow();
        } else if (ObjectType.EffectsSoftEdge.equalElementName(name)) {
            return new EffectsSoftEdge();
        } else if (ObjectType.EffectsReflection.equalElementName(name)) {
            return new EffectsReflection();
        }
        return null;
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
}
