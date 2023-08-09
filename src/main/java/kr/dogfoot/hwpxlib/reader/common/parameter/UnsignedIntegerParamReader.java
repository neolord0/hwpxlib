package kr.dogfoot.hwpxlib.reader.common.parameter;

import kr.dogfoot.hwpxlib.commonstrings.AttributeNames;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.common.parameter.UnsignedIntegerParam;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.util.ValueConvertor;

public class UnsignedIntegerParamReader extends ElementReader {
    private UnsignedIntegerParam unsignedIntegerParam;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.UnsignedIntegerParam;
    }

    public void unsignedIntegerParam(UnsignedIntegerParam unsignedIntegerParam) {
        this.unsignedIntegerParam = unsignedIntegerParam;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.name:
                unsignedIntegerParam.name(value);
                break;
        }
    }

    @Override
    public void text(String text) {
        unsignedIntegerParam.value(ValueConvertor.toLong(text));
    }

    @Override
    public SwitchableObject switchableObject() {
        return null;
    }
}

