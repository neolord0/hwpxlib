package kr.dogfoot.hwpxlib.reader.section_xml.control.etc;

import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.CurveSegmentType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.curve.CurveSegment;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.util.ValueConvertor;
import kr.dogfoot.hwpxlib.object.names.AttributeNames;

public class CurveSegmentReader extends ElementReader {
    private CurveSegment curveSegment;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.CurveSegment;
    }

    public void curveSegment(CurveSegment curveSegment) {
        this.curveSegment = curveSegment;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.type:
                curveSegment.type(CurveSegmentType.fromString(value));
                break;
            case AttributeNames.x1:
                curveSegment.x1(ValueConvertor.toInteger(value));
                break;
            case AttributeNames.y1:
                curveSegment.y1(ValueConvertor.toInteger(value));
                break;
            case AttributeNames.x2:
                curveSegment.x2(ValueConvertor.toInteger(value));
                break;
            case AttributeNames.y2:
                curveSegment.y2(ValueConvertor.toInteger(value));
                break;
        }
    }

    @Override
    public SwitchableObject switchableObject() {
        return null;
    }
}
