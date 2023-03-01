package kr.dogfoot.hwpxlib.reader.common.parameter;

import kr.dogfoot.hwpxlib.commonstirngs.AttributeNames;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.common.parameter.IntegerParam;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.util.ValueConvertor;

public class IntegerParamReader extends ElementReader {
    private IntegerParam integerParam;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.IntegerParam;
    }

    public void integerParam(IntegerParam integerParam) {
        this.integerParam = integerParam;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.name:
                integerParam.name(value);
                break;
        }
    }

    @Override
    public void text(String text) {
        integerParam.value(ValueConvertor.toInteger(text));
    }

    @Override
    public SwitchableObject switchableObject() {
        return null;
    }
}

