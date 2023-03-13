package kr.dogfoot.hwpxlib.reader.section_xml.object.picture.effects;

import kr.dogfoot.hwpxlib.commonstrings.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.picture.effects.*;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import org.xml.sax.Attributes;

public class EffectsReader extends ElementReader {
    private Effects effects;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.Effects;
    }

    public void effects(Effects effects) {
        this.effects = effects;
    }

    @Override
    public void childElement(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.hp_shadow:
                effects.createShadow();
                shadow(effects.shadow(), name, attrs);
                break;
            case ElementNames.hp_glow:
                effects.createGlow();
                glow(effects.glow(), name, attrs);
                break;
            case ElementNames.hp_softEdge:
                effects.createSoftEdge();
                softEdge(effects.softEdge(), name, attrs);
                break;
            case ElementNames.hp_reflection:
                effects.createReflection();
                reflection(effects.reflection(), name, attrs);
                break;
        }
    }

    @Override
    public HWPXObject childElementInSwitch(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.hp_shadow:
                EffectsShadow shadow = new EffectsShadow();
                shadow(shadow, name, attrs);
                return shadow;
            case ElementNames.hp_glow:
                EffectsGlow glow = new EffectsGlow();
                glow(glow, name, attrs);
                return glow;
            case ElementNames.hp_softEdge:
                EffectsSoftEdge softEdge = new EffectsSoftEdge();
                softEdge(softEdge, name, attrs);
                return softEdge;
            case ElementNames.hp_reflection:
                EffectsReflection reflection = new EffectsReflection();
                reflection(reflection, name, attrs);
                return reflection;
        }
        return null;
    }

    private void shadow(EffectsShadow shadow, String name, Attributes attrs) {
        ((EffectsShadowReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.EffectsShadow))
                .shadow(shadow);

        xmlFileReader().startElement(name, attrs);
    }

    private void glow(EffectsGlow glow, String name, Attributes attrs) {
        ((EffectsGlowReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.EffectsGlow))
                .glow(glow);

        xmlFileReader().startElement(name, attrs);

    }

    private void softEdge(EffectsSoftEdge softEdge, String name, Attributes attrs) {
        ((EffectsSoftEdgeReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.EffectsSoftEdge))
                .softEdge(softEdge);

        xmlFileReader().startElement(name, attrs);
    }

    private void reflection(EffectsReflection reflection, String name, Attributes attrs) {
        ((EffectsReflectionReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.EffectsReflection))
                .reflection(reflection);

        xmlFileReader().startElement(name, attrs);
    }

    @Override
    public SwitchableObject switchableObject() {
        return effects;
    }
}

