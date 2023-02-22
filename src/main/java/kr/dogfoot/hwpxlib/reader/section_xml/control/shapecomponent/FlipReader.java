package kr.dogfoot.hwpxlib.reader.section_xml.control.shapecomponent;

import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapecomponent.Flip;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.util.ValueConvertor;
import kr.dogfoot.hwpxlib.object.names.AttributeNames;

public class FlipReader extends ElementReader {
    private Flip flip;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.Flip;
    }

    public void flip(Flip flip) {
        this.flip = flip;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.horizontal:
                flip.horizontal(ValueConvertor.toBoolean(value));
                break;
            case AttributeNames.vertical:
                flip.vertical(ValueConvertor.toBoolean(value));
                break;
        }
    }

    @Override
    public SwitchableObject switchableObject() {
        return null;
    }
}
