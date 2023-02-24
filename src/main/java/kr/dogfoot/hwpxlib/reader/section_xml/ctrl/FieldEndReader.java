package kr.dogfoot.hwpxlib.reader.section_xml.ctrl;

import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.ctrl.FieldEnd;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.commonstirngs.AttributeNames;

public class FieldEndReader extends ElementReader {
    private FieldEnd fieldEnd;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.FieldEnd;
    }

    public void fieldEnd(FieldEnd fieldEnd) {
        this.fieldEnd = fieldEnd;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.beginIDRef:
                fieldEnd.beginIDRef(value);
                break;
            case AttributeNames.fieldid:
                fieldEnd.fieldid(value);
                break;
        }
    }

    @Override
    public SwitchableObject switchableObject() {
        return null;
    }
}
