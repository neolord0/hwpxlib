package kr.dogfoot.hwpxlib.writer.section_xml.object.picture;

import kr.dogfoot.hwpxlib.commonstrings.AttributeNames;
import kr.dogfoot.hwpxlib.commonstrings.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.baseobject.StartAndEndFloat;
import kr.dogfoot.hwpxlib.object.common.baseobject.XAndYFloat;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.picture.effects.EffectsReflection;
import kr.dogfoot.hwpxlib.writer.common.ElementWriter;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterManager;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterSort;

public class EffectsReflectionWriter extends ElementWriter {
    public EffectsReflectionWriter(ElementWriterManager elementWriterManager) {
        super(elementWriterManager);
    }

    @Override
    public ElementWriterSort sort() {
        return ElementWriterSort.EffectsReflection;
    }

    @Override
    public void write(HWPXObject object) {
        EffectsReflection reflection = (EffectsReflection) object;
        switchObject(reflection.switchObject());

        xsb()
                .openElement(ElementNames.hp_reflection)
                .elementWriter(this)
                .attribute(AttributeNames.alignStyle, reflection.alignStyle())
                .attribute(AttributeNames.radius, reflection.radius())
                .attribute(AttributeNames.direction, reflection.direction())
                .attribute(AttributeNames.distance, reflection.distance())
                .attribute(AttributeNames.rotationStyle, reflection.rotationStyle())
                .attribute(AttributeNames.fadeDirection, reflection.fadeDirection());

        if (reflection.skew() != null) {
            xAndYFloat(ElementNames.hp_skew, reflection.skew());
        }

        if (reflection.scale() != null) {
            xAndYFloat(ElementNames.hp_scale, reflection.scale());
        }

        if (reflection.alpha() != null) {
            startAndEnd(ElementNames.hp_alpha, reflection.alpha());
        }

        if (reflection.pos() != null) {
            startAndEnd(ElementNames.hp_pos, reflection.pos());
        }

        xsb().closeElement();
        releaseMe();
    }

    private void startAndEnd(String elementName, StartAndEndFloat startAndEndFloat) {
        xsb()
                .openElement(elementName)
                .attribute(AttributeNames.start, startAndEndFloat.start())
                .attribute(AttributeNames.end, startAndEndFloat.end())
                .closeElement();
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
            case hp_alpha:
                startAndEnd(ElementNames.hp_alpha, (StartAndEndFloat) child);
                break;
            case hp_pos:
                startAndEnd(ElementNames.hp_pos, (StartAndEndFloat) child);
                break;
        }
    }
}
