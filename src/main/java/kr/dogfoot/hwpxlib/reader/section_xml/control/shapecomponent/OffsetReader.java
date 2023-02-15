package kr.dogfoot.hwpxlib.reader.section_xml.control.shapecomponent;

import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapecomponent.Offset;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.util.ValueConvertor;
import kr.dogfoot.hwpxlib.util.AttributeNames;

public class OffsetReader extends ElementReader {
    private Offset offset;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.Offset;
    }

    public void offset(Offset offset) {
        this.offset = offset;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.x:
                offset.x(ValueConvertor.toInteger(value));
                break;
            case AttributeNames.y:
                offset.y(ValueConvertor.toInteger(value));
                break;
        }
    }

    @Override
    public SwitchableObject switchableObject() {
        return null;
    }
}
