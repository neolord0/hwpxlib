package kr.dogfoot.hwpxlib.reader.section_xml.control.picture.effects;

import kr.dogfoot.hwpxlib.commonstirngs.AttributeNames;
import kr.dogfoot.hwpxlib.commonstirngs.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.common.baseobject.XAndYFloat;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.AlignStyleType;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.ShadowStyle;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.picture.effects.EffectsColor;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.picture.effects.EffectsShadow;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.util.ValueConvertor;
import org.xml.sax.Attributes;

public class EffectsShadowReader extends ElementReader {
    private EffectsShadow shadow;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.EffectsShadow;
    }

    public void shadow(EffectsShadow shadow) {
        this.shadow = shadow;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.style:
                shadow.style(ShadowStyle.fromString(value));
                break;
            case AttributeNames.alpha:
                shadow.alpha(ValueConvertor.toFloat(value));
                break;
            case AttributeNames.radius:
                shadow.radius(ValueConvertor.toFloat(value));
                break;
            case AttributeNames.direction:
                shadow.direction(ValueConvertor.toShort(value));
                break;
            case AttributeNames.distance:
                shadow.distance(ValueConvertor.toFloat(value));
                break;
            case AttributeNames.alignStyle:
                shadow.alignStyle(AlignStyleType.fromString(value));
                break;
            case AttributeNames.rotationStyle:
                shadow.rotationStyle(ValueConvertor.toBoolean(value));
                break;
        }
    }

    @Override
    public void childElement(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.hp_skew:
                shadow.createSkew();
                xAndYFloat(shadow.skew(), name, attrs);
                break;
            case ElementNames.hp_scale:
                shadow.createScale();
                xAndYFloat(shadow.scale(), name, attrs);
                break;
            case ElementNames.hp_effectsColor:
                shadow.createEffectsColor();
                effectsColor(shadow.effectsColor(), name, attrs);
                break;
        }
    }

    @Override
    public HWPXObject childElementInSwitch(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.hp_skew:
                XAndYFloat skew = new XAndYFloat(ObjectType.hp_skew);
                xAndYFloat(skew, name, attrs);
                return skew;
            case ElementNames.hp_scale:
                XAndYFloat scale = new XAndYFloat(ObjectType.hp_scale);
                xAndYFloat(scale, name, attrs);
                return scale;
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
        return shadow;
    }

}
