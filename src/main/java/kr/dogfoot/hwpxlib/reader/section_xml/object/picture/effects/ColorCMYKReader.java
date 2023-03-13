package kr.dogfoot.hwpxlib.reader.section_xml.object.picture.effects;

import kr.dogfoot.hwpxlib.commonstrings.AttributeNames;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.picture.effects.ColorCMYK;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.util.ValueConvertor;

public class ColorCMYKReader extends ElementReader {
    private ColorCMYK cmyk;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.ColorCMYK;
    }

    public void cmyk(ColorCMYK cmyk) {
        this.cmyk = cmyk;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.c:
                cmyk.c(ValueConvertor.toShort(value));
                break;
            case AttributeNames.m:
                cmyk.m(ValueConvertor.toShort(value));
                break;
            case AttributeNames.y:
                cmyk.y(ValueConvertor.toShort(value));
                break;
            case AttributeNames.k:
                cmyk.k(ValueConvertor.toShort(value));
                break;
        }
    }


    @Override
    public SwitchableObject switchableObject() {
        return null;
    }
}
