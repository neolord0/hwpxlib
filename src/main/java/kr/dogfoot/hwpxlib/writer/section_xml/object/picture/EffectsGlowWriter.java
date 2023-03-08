package kr.dogfoot.hwpxlib.writer.section_xml.object.picture;

import kr.dogfoot.hwpxlib.commonstirngs.AttributeNames;
import kr.dogfoot.hwpxlib.commonstirngs.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.picture.effects.EffectsGlow;
import kr.dogfoot.hwpxlib.writer.common.ElementWriter;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterManager;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterSort;

public class EffectsGlowWriter extends ElementWriter {
    public EffectsGlowWriter(ElementWriterManager elementWriterManager) {
        super(elementWriterManager);
    }

    @Override
    public ElementWriterSort sort() {
        return ElementWriterSort.EffectsGlow;
    }

    @Override
    public void write(HWPXObject object) {
        EffectsGlow glow = (EffectsGlow) object;
        switchObject(glow.switchObject());

        xsb()
                .openElement(ElementNames.hp_glow)
                .elementWriter(this)
                .attribute(AttributeNames.alpha, glow.alpha())
                .attribute(AttributeNames.radius, glow.radius());

        if (glow.effectsColor() != null) {
            writeChild(ElementWriterSort.EffectsColor, glow.effectsColor());
        }

        xsb().closeElement();
        releaseMe();
    }

    @Override
    protected void childInSwitch(HWPXObject child) {
        switch (child._objectType()) {
            case hp_effectsColor:
                writeChild(ElementWriterSort.EffectsColor, child);
                break;
        }
    }
}
