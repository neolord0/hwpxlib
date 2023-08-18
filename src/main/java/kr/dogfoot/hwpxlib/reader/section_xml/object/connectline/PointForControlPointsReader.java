package kr.dogfoot.hwpxlib.reader.section_xml.object.connectline;

import kr.dogfoot.hwpxlib.commonstrings.AttributeNames;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.connectline.Point;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.util.ValueConvertor;

public class PointForControlPointsReader extends ElementReader {
    private Point point;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.PointForControlPoints;
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
            case AttributeNames.type:
                point.type(ValueConvertor.toInteger(value));
                break;
        }
    }

    @Override
    public SwitchableObject switchableObject() {
        return null;
    }
}
