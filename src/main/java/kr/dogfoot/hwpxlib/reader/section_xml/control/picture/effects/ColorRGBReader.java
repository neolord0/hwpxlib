package kr.dogfoot.hwpxlib.reader.section_xml.control.picture.effects;

import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.picture.effects.ColorRGB;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.util.ValueConvertor;
import kr.dogfoot.hwpxlib.object.names.AttributeNames;

public class ColorRGBReader extends ElementReader {
    private ColorRGB rgb;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.ColorRGB;
    }

    public void rgb(ColorRGB rgb) {
        this.rgb = rgb;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.r:
                rgb.r(ValueConvertor.toShort(value));
                break;
            case AttributeNames.g:
                rgb.g(ValueConvertor.toShort(value));
                break;
            case AttributeNames.b:
                rgb.b(ValueConvertor.toShort(value));
                break;
        }
    }

    @Override
    public SwitchableObject switchableObject() {
        return null;
    }
}