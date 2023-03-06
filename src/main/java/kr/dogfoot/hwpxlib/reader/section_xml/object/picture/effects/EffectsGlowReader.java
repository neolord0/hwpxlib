package kr.dogfoot.hwpxlib.reader.section_xml.object.picture.effects;

import kr.dogfoot.hwpxlib.commonstirngs.AttributeNames;
import kr.dogfoot.hwpxlib.commonstirngs.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.picture.effects.EffectsColor;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.picture.effects.EffectsGlow;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.util.ValueConvertor;
import org.xml.sax.Attributes;

public class EffectsGlowReader extends ElementReader {
    private EffectsGlow glow;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.EffectsGlow;
    }

    public void glow(EffectsGlow glow) {
        this.glow = glow;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.alpha:
                glow.alpha(ValueConvertor.toFloat(value));
                break;
            case AttributeNames.radius:
                glow.radius(ValueConvertor.toFloat(value));
                break;
        }
    }

    @Override
    public void childElement(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.hp_effectsColor:
                glow.createEffectsColor();
                effectsColor(glow.effectsColor(), name, attrs);
                break;
        }
    }

    @Override
    public HWPXObject childElementInSwitch(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.hp_effectsColor:
                EffectsColor effectsColor = new EffectsColor();
                effectsColor(effectsColor, name, attrs);
                return effectsColor;
        }
        return null;
    }

    private void effectsColor(EffectsColor effectsColor, String name, Attributes attrs) {
        ((EffectsColorReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.EffectsColor))
                .effectsColor(effectsColor);

        xmlFileReader().startElement(name, attrs);
    }


    @Override
    public SwitchableObject switchableObject() {
        return glow;
    }
}
