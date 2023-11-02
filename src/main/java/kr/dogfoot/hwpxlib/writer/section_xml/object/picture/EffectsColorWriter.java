package kr.dogfoot.hwpxlib.writer.section_xml.object.picture;

import kr.dogfoot.hwpxlib.commonstrings.AttributeNames;
import kr.dogfoot.hwpxlib.commonstrings.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.picture.effects.*;
import kr.dogfoot.hwpxlib.writer.common.ElementWriter;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterManager;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterSort;

public class EffectsColorWriter extends ElementWriter {
    public EffectsColorWriter(ElementWriterManager elementWriterManager) {
        super(elementWriterManager);
    }

    @Override
    public ElementWriterSort sort() {
        return ElementWriterSort.EffectsColor;
    }

    @Override
    public void write(HWPXObject object) {
        EffectsColor effectsColor = (EffectsColor) object;
        switchList(effectsColor.switchList());

        xsb()
                .openElement(ElementNames.hp_effectsColor)
                .elementWriter(this)
                .attribute(AttributeNames.type, effectsColor.type())
                .attribute(AttributeNames.schemeIdx, effectsColor.schemeIdx())
                .attribute(AttributeNames.systemIdx, effectsColor.systemIdx())
                .attribute(AttributeNames.presetIdx, effectsColor.presetIdx());

        if (effectsColor.rgb() != null) {
            rgb(effectsColor.rgb());
        }

        if (effectsColor.cmyk() != null) {
            cmyk(effectsColor.cmyk());
        }

        if (effectsColor.scheme() != null) {
            scheme(effectsColor.scheme());
        }

        if (effectsColor.system() != null) {
            system(effectsColor.system());
        }

        for (ColorEffect effect : effectsColor.effects()) {
            effect(effect);
        }

        xsb().closeElement();
        releaseMe();
    }

    private void rgb(ColorRGB rgb) {
        xsb()
                .openElement(ElementNames.hp_rgb)
                .attribute(AttributeNames.r, rgb.r())
                .attribute(AttributeNames.g, rgb.g())
                .attribute(AttributeNames.b, rgb.b())
                .closeElement();
    }

    private void cmyk(ColorCMYK cmyk) {
        xsb()
                .openElement(ElementNames.hp_cmyk)
                .attribute(AttributeNames.c, cmyk.c())
                .attribute(AttributeNames.m, cmyk.m())
                .attribute(AttributeNames.y, cmyk.y())
                .attribute(AttributeNames.k, cmyk.k())
                .closeElement();
    }

    private void scheme(ColorScheme scheme) {
        xsb()
                .openElement(ElementNames.hp_scheme)
                .attribute(AttributeNames.r, scheme.r())
                .attribute(AttributeNames.g, scheme.g())
                .attribute(AttributeNames.b, scheme.b())
                .closeElement();
    }

    private void system(ColorSystem system) {
        xsb()
                .openElement(ElementNames.hp_system)
                .attribute(AttributeNames.h, system.h())
                .attribute(AttributeNames.s, system.s())
                .attribute(AttributeNames.l, system.l())
                .closeElement();
    }

    private void effect(ColorEffect effect) {
        xsb()
                .openElement(ElementNames.hp_effect)
                .attribute(AttributeNames.type, effect.type())
                .attribute(AttributeNames.value, effect.value())
                .closeElement();
    }

    @Override
    protected void childInSwitch(HWPXObject child) {
        switch (child._objectType()) {
            case hp_rgb:
                rgb((ColorRGB) child);
                break;
            case hp_cmyk:
                cmyk((ColorCMYK) child);
                break;
            case hp_scheme:
                scheme((ColorScheme) child);
                break;
            case hp_system:
                system((ColorSystem) child);
                break;
            case hp_effect:
                effect((ColorEffect) child);
                break;
        }
    }

}
