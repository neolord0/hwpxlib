package kr.dogfoot.hwpxlib.reader.common.parameter;

import kr.dogfoot.hwpxlib.commonstirngs.AttributeNames;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.common.parameter.BooleanParam;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.util.ValueConvertor;

public class BooleanParamReader extends ElementReader {
    private BooleanParam booleanParam;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.BooleanParam;
    }

    public void booleanParam(BooleanParam booleanParam) {
        this.booleanParam = booleanParam;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.name:
                booleanParam.name(value);
                break;
        }
    }

    @Override
    public void text(String text) {
        booleanParam.value(ValueConvertor.toBooleanText(text));
    }

    @Override
    public SwitchableObject switchableObject() {
        return null;
    }
}
