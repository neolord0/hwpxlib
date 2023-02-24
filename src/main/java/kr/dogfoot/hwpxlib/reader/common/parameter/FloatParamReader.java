package kr.dogfoot.hwpxlib.reader.common.parameter;

import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.common.parameter.FloatParam;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.util.ValueConvertor;
import kr.dogfoot.hwpxlib.commonstirngs.AttributeNames;

public class FloatParamReader extends ElementReader {
    private FloatParam floatParam;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.FloatParam;
    }

    public void floatParam(FloatParam floatParam) {
        this.floatParam = floatParam;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.name:
                floatParam.name(value);
                break;
        }
    }

    @Override
    public void text(String text) {
        floatParam.value(ValueConvertor.toFloat(text));
    }

    @Override
    public SwitchableObject switchableObject() {
        return null;
    }
}
