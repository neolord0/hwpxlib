package kr.dogfoot.hwpxlib.reader.section_xml.object;

import kr.dogfoot.hwpxlib.commonstrings.AttributeNames;
import kr.dogfoot.hwpxlib.commonstrings.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectList;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.ConnectLineType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.ConnectLine;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.connectline.ConnectLinePoint;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.connectline.Point;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.drawingobject.DrawingObject;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.section_xml.object.connectline.ConnectLinePointReader;
import kr.dogfoot.hwpxlib.reader.section_xml.object.connectline.ControlPointsReader;
import kr.dogfoot.hwpxlib.reader.section_xml.object.drawingobject.DrawingObjectReader;
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
            case ElementNames.hp_controlPoints:
                connectLine.createControlPoints();
                controlPoints(connectLine.controlPoints(), name, attrs);
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
            case ElementNames.hp_controlPoints:
                ObjectList<Point> controlPoints = new ObjectList<Point>(ObjectType.hp_controlPoints, Point.class);
                controlPoints(controlPoints, name, attrs);
                return controlPoints;
        }

        return super.childElementInSwitch(name, attrs);
    }

    private void connectLinePoint(ConnectLinePoint connectLinePoint, String name, Attributes attrs) {
        ((ConnectLinePointReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.ConnectLinePoint))
                .connectLinePoint(connectLinePoint);

        xmlFileReader().startElement(name, attrs);
    }


    private void controlPoints(ObjectList<Point> controlPoints, String name, Attributes attrs) {
        ((ControlPointsReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.ControlPoints))
                .controlPoints(controlPoints);

        xmlFileReader().startElement(name, attrs);
    }

    @Override
    public SwitchableObject switchableObject() {
        return connectLine;
    }
}
