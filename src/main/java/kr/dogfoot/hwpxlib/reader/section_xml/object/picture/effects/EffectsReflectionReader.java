package kr.dogfoot.hwpxlib.reader.section_xml.object.picture.effects;

import kr.dogfoot.hwpxlib.commonstrings.AttributeNames;
import kr.dogfoot.hwpxlib.commonstrings.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.common.baseobject.StartAndEndFloat;
import kr.dogfoot.hwpxlib.object.common.baseobject.XAndYFloat;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.AlignStyleType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.picture.effects.EffectsReflection;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.common.baseobject.StartAndEndFloatReader;
import kr.dogfoot.hwpxlib.reader.util.ValueConvertor;
import org.xml.sax.Attributes;

public class EffectsReflectionReader extends ElementReader {
    private EffectsReflection reflection;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.EffectsReflection;
    }

    public void reflection(EffectsReflection reflection) {
        this.reflection = reflection;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.alignStyle:
                reflection.alignStyle(AlignStyleType.fromString(value));
                break;
            case AttributeNames.radius:
                reflection.radius(ValueConvertor.toFloat(value));
                break;
            case AttributeNames.direction:
                reflection.direction(ValueConvertor.toInteger(value));
                break;
            case AttributeNames.distance:
                reflection.distance(ValueConvertor.toFloat(value));
                break;
            case AttributeNames.rotationStyle:
                reflection.rotationStyle(ValueConvertor.toBoolean(value));
                break;
            case AttributeNames.fadeDirection:
                reflection.fadeDirection(ValueConvertor.toInteger(value));
                break;
        }
    }


    @Override
    public void childElement(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.hp_skew:
                reflection.createSkew();
                xAndYFloat(reflection.skew(), name, attrs);
                break;
            case ElementNames.hp_scale:
                reflection.createScale();
                xAndYFloat(reflection.scale(), name, attrs);
                break;
            case ElementNames.hp_alpha:
                reflection.createAlpha();
                startAndEndFloat(reflection.alpha(), name, attrs);
                break;
            case ElementNames.hp_pos:
                reflection.createPos();
                startAndEndFloat(reflection.pos(), name, attrs);
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
            case ElementNames.hp_alpha:
                StartAndEndFloat alpha = new StartAndEndFloat(ObjectType.hp_alpha);
                startAndEndFloat(alpha, name, attrs);
                return alpha;
            case ElementNames.hp_pos:
                StartAndEndFloat pos = new StartAndEndFloat(ObjectType.hp_pos);
                startAndEndFloat(pos, name, attrs);
                return pos;
        }
        return null;
    }

    private void startAndEndFloat(StartAndEndFloat startAndEndFloat, String name, Attributes attrs) {
        ((StartAndEndFloatReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.StartAndEndFloat))
                .startAndEndFloat(startAndEndFloat);

        xmlFileReader().startElement(name, attrs);
    }

    @Override
    public SwitchableObject switchableObject() {
        return null;
    }
}
