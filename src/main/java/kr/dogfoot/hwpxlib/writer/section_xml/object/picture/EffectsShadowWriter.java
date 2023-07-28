package kr.dogfoot.hwpxlib.writer.section_xml.object.picture;

import kr.dogfoot.hwpxlib.commonstrings.AttributeNames;
import kr.dogfoot.hwpxlib.commonstrings.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.baseobject.XAndYFloat;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.picture.effects.EffectsShadow;
import kr.dogfoot.hwpxlib.writer.common.ElementWriter;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterManager;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterSort;

public class EffectsShadowWriter extends ElementWriter {
    public EffectsShadowWriter(ElementWriterManager elementWriterManager) {
        super(elementWriterManager);
    }

    @Override
    public ElementWriterSort sort() {
        return ElementWriterSort.EffectsShadow;
    }

    @Override
    public void write(HWPXObject object) {
        EffectsShadow shadow = (EffectsShadow) object;
        switchList(shadow.switchList());

        xsb()
                .openElement(ElementNames.hp_shadow)
                .elementWriter(this)
                .attribute(AttributeNames.style, shadow.style())
                .attribute(AttributeNames.alpha, shadow.alpha())
                .attribute(AttributeNames.radius, shadow.radius())
                .attribute(AttributeNames.direction, shadow.direction())
                .attribute(AttributeNames.distance, shadow.distance())
                .attribute(AttributeNames.alignStyle, shadow.alignStyle())
                .attribute(AttributeNames.rotationStyle, shadow.rotationStyle());

        if (shadow.skew() != null) {
            xAndYFloat(ElementNames.hp_skew, shadow.skew());
        }

        if (shadow.scale() != null) {
            xAndYFloat(ElementNames.hp_scale, shadow.scale());
        }

        if (shadow.effectsColor() != null) {
            writeChild(ElementWriterSort.EffectsColor, shadow.effectsColor());
        }

        xsb().closeElement();
        releaseMe();
    }

    @Override
    protected void childInSwitch(HWPXObject child) {
        switch (child._objectType()) {
            case hp_skew:
                xAndYFloat(ElementNames.hp_skew, (XAndYFloat) child);
                break;
            case hp_scale:
                xAndYFloat(ElementNames.hp_scale, (XAndYFloat) child);
                break;
            case hp_effectsColor:
                writeChild(ElementWriterSort.EffectsColor, child);
                break;
        }
    }
}
