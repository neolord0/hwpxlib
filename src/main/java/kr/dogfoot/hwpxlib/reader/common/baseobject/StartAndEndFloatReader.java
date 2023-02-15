package kr.dogfoot.hwpxlib.reader.common.baseobject;

import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.common.baseobject.StartAndEndFloat;
import kr.dogfoot.hwpxlib.object.common.baseobject.WidthAndHeight;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.util.ValueConvertor;
import kr.dogfoot.hwpxlib.util.AttributeNames;

public class StartAndEndFloatReader extends ElementReader {
    private StartAndEndFloat startAndEndFloat;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.StartAndEndFloat;
    }

    public void startAndEndFloat(StartAndEndFloat startAndEndFloat) {
        this.startAndEndFloat = startAndEndFloat;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.start:
                startAndEndFloat.start(ValueConvertor.toFloat(value));
                break;
            case AttributeNames.end:
                startAndEndFloat.end(ValueConvertor.toFloat(value));
                break;
        }
    }

    @Override
    public SwitchableObject switchableObject() {
        return null;
    }
}
