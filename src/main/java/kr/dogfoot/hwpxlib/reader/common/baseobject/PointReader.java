package kr.dogfoot.hwpxlib.reader.common.baseobject;

import kr.dogfoot.hwpxlib.commonstirngs.AttributeNames;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.common.baseobject.Point;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.util.ValueConvertor;


public class PointReader extends ElementReader {
    private Point point;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.Point;
    }

    public void point(Point point) {
        this.point = point;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.x:
                point.x(ValueConvertor.toLong(value));
                break;
            case AttributeNames.y:
                point.y(ValueConvertor.toLong(value));
                break;
        }
    }

    @Override
    public SwitchableObject switchableObject() {
        return null;
    }
}
