package kr.dogfoot.hwpxlib.reader.section_xml.control;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.ConnectLineType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.ConnectLine;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.connectline.ConnectLinePoint;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.drawingobject.DrawingObject;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.section_xml.control.drawingobject.DrawingObjectReader;
import kr.dogfoot.hwpxlib.reader.section_xml.control.etc.ConnectLinePointReader;
import kr.dogfoot.hwpxlib.util.AttributeNames;
import kr.dogfoot.hwpxlib.util.ElementNames;
import org.xml.sax.Attributes;

public class ConnectLineReader extends DrawingObjectReader {
    private ConnectLine connectLine;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.ConnectLine;
    }

    @Override
    public DrawingObject drawingObject() {
        return connectLine;
    }

    public void connectLine(ConnectLine connectLine) {
        this.connectLine = connectLine;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.type:
                connectLine.type(ConnectLineType.fromString(value));
                break;
            default:
                super.setAttribute(name, value);
                break;
        }
    }

    @Override
    public void childElement(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.hp_startPt:
                connectLine.createStartPt();
                connectLinePoint(connectLine.startPt(), name, attrs);
                break;
            case ElementNames.hp_endPt:
                connectLine.createEndPt();
                connectLinePoint(connectLine.endPt(), name, attrs);
                break;
            default:
                super.childElement(name, attrs);
                break;
        }
    }

    @Override
    public HWPXObject childElementInSwitch(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.hp_startPt:
                ConnectLinePoint startPt = new ConnectLinePoint(ObjectType.hp_startPt);
                connectLinePoint(startPt, name, attrs);
                return startPt;
            case ElementNames.hp_endPt:
                ConnectLinePoint endPt = new ConnectLinePoint(ObjectType.hp_endPt);
                connectLinePoint(endPt, name, attrs);
                return endPt;
        }

        return super.childElementInSwitch(name, attrs);
    }

    private void connectLinePoint(ConnectLinePoint connectLinePoint, String name, Attributes attrs) {
        ((ConnectLinePointReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.ConnectLinePoint))
                .connectLinePoint(connectLinePoint);

        xmlFileReader().startElement(name, attrs);
    }

    @Override
    public SwitchableObject switchableObject() {
        return connectLine;
    }
}
