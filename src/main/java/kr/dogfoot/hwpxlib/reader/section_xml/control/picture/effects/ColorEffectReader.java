package kr.dogfoot.hwpxlib.reader.section_xml.control.picture.effects;

import kr.dogfoot.hwpxlib.commonstirngs.AttributeNames;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.ColorEffectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.picture.effects.ColorEffect;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;

public class ColorEffectReader extends ElementReader {
    private ColorEffect effect;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.ColorEffect;
    }

    public void effect(ColorEffect effect) {
        this.effect = effect;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.type:
                effect.type(ColorEffectType.fromString(value));
                break;
            case AttributeNames.value:
                effect.value(value);
                break;
        }
    }

    @Override
    public SwitchableObject switchableObject() {
        return null;
    }
}
