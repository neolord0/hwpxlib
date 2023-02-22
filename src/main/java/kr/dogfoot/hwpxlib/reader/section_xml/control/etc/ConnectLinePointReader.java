package kr.dogfoot.hwpxlib.reader.section_xml.control.etc;

import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.connectline.ConnectLinePoint;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.util.ValueConvertor;
import kr.dogfoot.hwpxlib.object.names.AttributeNames;

public class ConnectLinePointReader extends ElementReader {
    private ConnectLinePoint connectLinePoint;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.ConnectLinePoint;
    }

    public void connectLinePoint(ConnectLinePoint connectLinePoint) {
        this.connectLinePoint = connectLinePoint;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.x:
                connectLinePoint.x(ValueConvertor.toLong(value));
                break;
            case AttributeNames.y:
                connectLinePoint.y(ValueConvertor.toLong(value));
                break;
            case AttributeNames.subjectIDRef:
                connectLinePoint.subjectIDRef(value);
                break;
            case AttributeNames.subjectIdx:
                connectLinePoint.subjectIdx(ValueConvertor.toShort(value));
                break;
        }
    }

    @Override
    public SwitchableObject switchableObject() {
        return null;
    }
}
