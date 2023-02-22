package kr.dogfoot.hwpxlib.reader.settings_xml;

import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.root.CaretPosition;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.util.ValueConvertor;
import kr.dogfoot.hwpxlib.object.names.AttributeNames;

public class CaretPositionReader extends ElementReader {
    private CaretPosition caretPosition;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.CaretPosition;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.listIDRef:
                caretPosition.listIDRef(ValueConvertor.toInteger(value));
                break;
            case AttributeNames.paraIDRef:
                caretPosition.paraIDRef(ValueConvertor.toInteger(value));
                break;
            case AttributeNames.pos:
                caretPosition.pos(ValueConvertor.toInteger(value));
                break;
        }
    }

    @Override
    public SwitchableObject switchableObject() {
        return null;
    }

    public void caretPosition(CaretPosition caretPosition) {
        this.caretPosition = caretPosition;
    }
}
