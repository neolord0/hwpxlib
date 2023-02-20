package kr.dogfoot.hwpxlib.reader.common.baseobject;

import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.common.baseobject.WidthAndHeight;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.util.ValueConvertor;
import kr.dogfoot.hwpxlib.util.AttributeNames;

public class WidthAndHeightReader extends ElementReader {
    private WidthAndHeight widthAndHeight;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.WidthAndHeight;
    }

    public void widthAndHeight(WidthAndHeight widthAndHeight) {
        this.widthAndHeight = widthAndHeight;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.width:
                widthAndHeight.width(ValueConvertor.toLong(value));
                break;
            case AttributeNames.height:
                widthAndHeight.height(ValueConvertor.toLong(value));
                break;
        }
    }

    @Override
    public SwitchableObject switchableObject() {
        return null;
    }
}
