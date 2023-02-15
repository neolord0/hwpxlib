package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.picture.effects;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.ColorEffectType;

/**
 * 색상 효과
 */
public class ColorEffect extends HWPXObject {
    private ColorEffectType type;
    private String value;

    public ColorEffect() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_effect;
    }

    public ColorEffectType type() {
        return type;
    }

    public void type(ColorEffectType type) {
        this.type = type;
    }

    public ColorEffect typeAnd(ColorEffectType type) {
        this.type = type;
        return this;
    }

    public String value() {
        return value;
    }

    public void value(String value) {
        this.value = value;
    }

    public ColorEffect valueAnd(String value) {
        this.value = value;
        return this;
    }
}
