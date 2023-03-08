package kr.dogfoot.hwpxlib.writer.section_xml.object.picture;

import kr.dogfoot.hwpxlib.commonstirngs.AttributeNames;
import kr.dogfoot.hwpxlib.commonstirngs.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.picture.effects.Effects;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.picture.effects.EffectsSoftEdge;
import kr.dogfoot.hwpxlib.writer.common.ElementWriter;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterManager;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterSort;

public class EffectsWriter extends ElementWriter {
    public EffectsWriter(ElementWriterManager elementWriterManager) {
        super(elementWriterManager);
    }

    @Override
    public ElementWriterSort sort() {
        return ElementWriterSort.Effects;
    }

    @Override
    public void write(HWPXObject object) {
        Effects effects = (Effects) object;
        switchObject(effects.switchObject());

        xsb()
                .openElement(ElementNames.hp_effects)
                .elementWriter(this);

        if (effects.shadow() != null) {
            writeChild(ElementWriterSort.EffectsShadow, effects.shadow());
        }

        if (effects.glow() != null) {
            writeChild(ElementWriterSort.EffectsGlow, effects.glow());
        }

        if (effects.softEdge() != null) {
            softEdge(effects.softEdge());
        }

        if (effects.reflection() != null) {
            writeChild(ElementWriterSort.EffectsReflection, effects.reflection());
        }
    }

    private void softEdge(EffectsSoftEdge softEdge) {
        xsb()
                .openElement(ElementNames.hp_softEdge)
                .attribute(AttributeNames.radius, softEdge.radius())
                .closeElement();
    }

    @Override
    protected void childInSwitch(HWPXObject child) {
        switch (child._objectType()) {
            case hp_shadow_for_effects:
                writeChild(ElementWriterSort.EffectsShadow, child);
                break;
            case hp_glow:
                writeChild(ElementWriterSort.EffectsGlow, child);
                break;
            case hp_softEdge:
                softEdge((EffectsSoftEdge) child);
                break;
            case hp_reflection:
                writeChild(ElementWriterSort.EffectsReflection, child);
                break;
        }
    }
}
