package kr.dogfoot.hwpxlib.reader.section_xml.control.picture.effects;

import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.picture.effects.ColorSystem;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.util.ValueConvertor;
import kr.dogfoot.hwpxlib.object.names.AttributeNames;

public class ColorSystemReader extends ElementReader {
    private ColorSystem system;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.ColorSystem;
    }

    public void system(ColorSystem system) {
        this.system = system;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.h:
                system.h(ValueConvertor.toShort(value));
                break;
            case AttributeNames.s:
                system.s(ValueConvertor.toShort(value));
                break;
            case AttributeNames.l:
                system.l(ValueConvertor.toShort(value));
                break;
        }
    }

    @Override
    public SwitchableObject switchableObject() {
        return null;
    }

}
