package kr.dogfoot.hwpxlib.reader.header_xml.parapr;

import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.common.baseobject.ValueAndUnit;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.ValueUnit2;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.util.ValueConvertor;
import kr.dogfoot.hwpxlib.object.names.AttributeNames;

public class ValueAndUnitReader extends ElementReader {
    private ValueAndUnit valueAndUnit;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.ValueAndUnit;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.value:
                valueAndUnit.value(ValueConvertor.toInteger(value));
                break;
            case AttributeNames.unit:
                valueAndUnit.unit(ValueUnit2.fromString(value));
                break;
        }
    }

    @Override
    public SwitchableObject switchableObject() {
        return null;
    }

    public void valueAndUnit(ValueAndUnit valueAndUnit) {
        this.valueAndUnit = valueAndUnit;
    }
}
