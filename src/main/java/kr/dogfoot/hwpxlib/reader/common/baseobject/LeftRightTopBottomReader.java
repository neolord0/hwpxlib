package kr.dogfoot.hwpxlib.reader.common.baseobject;

import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.common.baseobject.LeftRightTopBottom;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.util.ValueConvertor;
import kr.dogfoot.hwpxlib.object.names.AttributeNames;

public class LeftRightTopBottomReader extends ElementReader {
    private LeftRightTopBottom leftRightTopBottom;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.LeftRightTopBottom;
    }

    public void leftRightTopBottom(LeftRightTopBottom leftRightTopBottom) {
        this.leftRightTopBottom = leftRightTopBottom;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.left:
                leftRightTopBottom.left(ValueConvertor.toLong(value));
                break;
            case AttributeNames.right:
                leftRightTopBottom.right(ValueConvertor.toLong(value));
                break;
            case AttributeNames.top:
                leftRightTopBottom.top(ValueConvertor.toLong(value));
                break;
            case AttributeNames.bottom:
                leftRightTopBottom.bottom(ValueConvertor.toLong(value));
                break;
        }
    }

    @Override
    public SwitchableObject switchableObject() {
        return null;
    }
}
