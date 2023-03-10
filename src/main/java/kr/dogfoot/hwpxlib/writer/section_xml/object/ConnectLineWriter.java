package kr.dogfoot.hwpxlib.writer.section_xml.object;

import kr.dogfoot.hwpxlib.commonstirngs.AttributeNames;
import kr.dogfoot.hwpxlib.commonstirngs.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.ConnectLine;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.connectline.ConnectLinePoint;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterManager;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterSort;
import kr.dogfoot.hwpxlib.writer.section_xml.object.drawingobject.DrawingObjectWriter;

public class ConnectLineWriter extends DrawingObjectWriter {
    public ConnectLineWriter(ElementWriterManager elementWriterManager) {
        super(elementWriterManager);
    }

    @Override
    public ElementWriterSort sort() {
        return ElementWriterSort.ConnectLine;
    }

    @Override
    public void write(HWPXObject object) {
        ConnectLine connectLine = (ConnectLine) object;
        switchObject(connectLine.switchObject());

        xsb()
                .openElement(ElementNames.hp_connectLine)
                .elementWriter(this);
        writeAttributeForDrawingObject(connectLine);
        xsb().attribute(AttributeNames.type, connectLine.type());

        writeChildrenForDrawingObject(connectLine);

        if (connectLine.startPt() != null) {
            connectLinePoint(ElementNames.hp_startPt, connectLine.startPt());
        }

        if (connectLine.endPt() != null) {
            connectLinePoint(ElementNames.hp_endPt, connectLine.endPt());
        }

        writeChildrenForShapeObject(connectLine);

        xsb().closeElement();
        releaseMe();
    }

    private void connectLinePoint(String elementName, ConnectLinePoint point) {
        xsb()
                .openElement(elementName)
                .attribute(AttributeNames.x, point.x())
                .attribute(AttributeNames.y, point.y())
                .attribute(AttributeNames.subjectIDRef, point.subjectIDRef())
                .attribute(AttributeNames.subjectIdx, point.subjectIdx())
                .closeElement();
    }

    @Override
    protected void childInSwitch(HWPXObject child) {
        switch (child._objectType()) {
            case hp_startPt:
                connectLinePoint(ElementNames.hp_startPt, (ConnectLinePoint) child);
                break;
            case hp_endPt:
                connectLinePoint(ElementNames.hp_endPt, (ConnectLinePoint) child);
                break;
            default:
                super.childInSwitch(child);
                break;
        }
    }
}
