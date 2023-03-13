package kr.dogfoot.hwpxlib.writer.section_xml.object;

import kr.dogfoot.hwpxlib.commonstrings.AttributeNames;
import kr.dogfoot.hwpxlib.commonstrings.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.baseobject.Point;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.Line;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterManager;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterSort;
import kr.dogfoot.hwpxlib.writer.section_xml.object.drawingobject.DrawingObjectWriter;

public class LineWriter extends DrawingObjectWriter {
    public LineWriter(ElementWriterManager elementWriterManager) {
        super(elementWriterManager);
    }

    @Override
    public ElementWriterSort sort() {
        return ElementWriterSort.Line;
    }

    @Override
    public void write(HWPXObject object) {
        Line line = (Line) object;
        switchObject(line.switchObject());

        xsb()
                .openElement(ElementNames.hp_line)
                .elementWriter(this);
        writeAttributeForDrawingObject(line);
        xsb().attribute(AttributeNames.isReverseHV, line.isReverseHV());

        writeChildrenForDrawingObject(line);

        if (line.startPt() != null) {
            point(ElementNames.hc_startPt, line.startPt());
        }

        if (line.endPt() != null) {
            point(ElementNames.hc_endPt, line.endPt());
        }

        writeChildrenForShapeObject(line);

        xsb().closeElement();
        releaseMe();
    }

    @Override
    protected void childInSwitch(HWPXObject child) {
        switch (child._objectType()) {
            case hc_startPt:
                point(ElementNames.hc_startPt, (Point) child);
                break;
            case hc_endPt:
                point(ElementNames.hc_endPt, (Point) child);
                break;
            default:
                super.childInSwitch(child);
                break;
        }
    }
}
