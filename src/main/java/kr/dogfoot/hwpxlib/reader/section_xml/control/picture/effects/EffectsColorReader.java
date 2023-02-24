package kr.dogfoot.hwpxlib.reader.section_xml.control.picture.effects;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.ColorType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.picture.effects.*;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.util.ValueConvertor;
import kr.dogfoot.hwpxlib.commonstirngs.AttributeNames;
import kr.dogfoot.hwpxlib.commonstirngs.ElementNames;
import org.xml.sax.Attributes;

public class EffectsColorReader extends ElementReader {
    private EffectsColor effectsColor;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.EffectsColor;
    }

    public void effectsColor(EffectsColor effectsColor) {
        this.effectsColor = effectsColor;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.type:
                effectsColor.type(ColorType.fromString(value));
                break;
            case AttributeNames.schemeIdx:
                effectsColor.schemeIdx(ValueConvertor.toInteger(value));
                break;
            case AttributeNames.systemIdx:
                effectsColor.systemIdx(ValueConvertor.toInteger(value));
                break;
            case AttributeNames.presetIdx:
                effectsColor.presetIdx(ValueConvertor.toInteger(value));
                break;
        }
    }


    @Override
    public void childElement(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.hp_rgb:
                effectsColor.createRgb();
                rgb(effectsColor.rgb(), name, attrs);
                break;
            case ElementNames.hp_cmyk:
                effectsColor.createCmyk();
                cmyk(effectsColor.cmyk(), name, attrs);
                break;
            case ElementNames.hp_scheme:
                effectsColor.createSchema();
                schema(effectsColor.schema(), name, attrs);
                break;
            case ElementNames.hp_system:
                effectsColor.createSystem();
                system(effectsColor.system(), name, attrs);
                break;
            case ElementNames.hp_effect:
                effectsColor.createEffect();
                effect(effectsColor.effect(), name, attrs);
                break;
        }
    }

    @Override
    public HWPXObject childElementInSwitch(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.hp_rgb:
                ColorRGB rgb = new ColorRGB();
                rgb(rgb, name, attrs);
                return rgb;
            case ElementNames.hp_cmyk:
                ColorCMYK cmyk = new ColorCMYK();
                cmyk(cmyk, name, attrs);
                return cmyk;
            case ElementNames.hp_scheme:
                ColorSchema schema = new ColorSchema();
                schema(schema, name, attrs);
                return schema;
            case ElementNames.hp_system:
                ColorSystem system = new ColorSystem();
                system(system, name, attrs);
                return system;
            case ElementNames.hp_effect:
                ColorEffect effect = new ColorEffect();
                effect(effect, name, attrs);
                return effect;
        }
        return null;
    }

    private void rgb(ColorRGB rgb, String name, Attributes attrs) {
        ((ColorRGBReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.ColorRGB))
                .rgb(rgb);

        xmlFileReader().startElement(name, attrs);
    }

    private void cmyk(ColorCMYK cmyk, String name, Attributes attrs) {
        ((ColorCMYKReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.ColorCMYK))
                .cmyk(cmyk);

        xmlFileReader().startElement(name, attrs);
    }

    private void schema(ColorSchema schema, String name, Attributes attrs) {
        ((ColorSchemaReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.ColorSchema))
                .schema(schema);

        xmlFileReader().startElement(name, attrs);
    }

    private void system(ColorSystem system, String name, Attributes attrs) {
        ((ColorSystemReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.ColorSystem))
                .system(system);

        xmlFileReader().startElement(name, attrs);
    }

    private void effect(ColorEffect effect, String name, Attributes attrs) {
        ((ColorEffectReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.ColorEffect))
                .effect(effect);

        xmlFileReader().startElement(name, attrs);
    }

    @Override
    public SwitchableObject switchableObject() {
        return effectsColor;
    }
}
