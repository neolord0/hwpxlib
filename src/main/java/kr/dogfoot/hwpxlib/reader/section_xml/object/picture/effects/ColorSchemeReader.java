package kr.dogfoot.hwpxlib.reader.section_xml.object.picture.effects;

import kr.dogfoot.hwpxlib.commonstrings.AttributeNames;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.picture.effects.ColorScheme;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.util.ValueConvertor;

public class ColorSchemeReader extends ElementReader {
    private ColorScheme scheme;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.ColorScheme;
    }

    public void scheme(ColorScheme scheme) {
        this.scheme = scheme;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.r:
                scheme.r(ValueConvertor.toShort(value));
                break;
            case AttributeNames.g:
                scheme.g(ValueConvertor.toShort(value));
                break;
            case AttributeNames.b:
                scheme.b(ValueConvertor.toShort(value));
                break;
        }
    }

    @Override
    public SwitchableObject switchableObject() {
        return null;
    }
}
