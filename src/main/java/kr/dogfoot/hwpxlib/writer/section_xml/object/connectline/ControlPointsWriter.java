package kr.dogfoot.hwpxlib.writer.section_xml.object.connectline;

import kr.dogfoot.hwpxlib.commonstrings.AttributeNames;
import kr.dogfoot.hwpxlib.commonstrings.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectList;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.connectline.Point;
import kr.dogfoot.hwpxlib.writer.common.ElementWriter;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterManager;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterSort;

public class ControlPointsWriter extends ElementWriter {
    public ControlPointsWriter(ElementWriterManager elementWriterManager) {
        super(elementWriterManager);
    }

    @Override
    public ElementWriterSort sort() {
        return ElementWriterSort.ControlPoints;
    }

    @Override
    public void write(HWPXObject object) {
        ObjectList<Point> controlPoints = (ObjectList<Point>) object;
        switchList(controlPoints.switchList());

        xsb()
                .openElement(ElementNames.hp_controlPoints)
                .elementWriter(this);

        for (Point point : controlPoints.items()) {
            point(point);
        }

        xsb().closeElement();
        releaseMe();
    }

    private void point(Point point) {
        xsb()
                .openElement(ElementNames.hp_point)
                .attribute(AttributeNames.x, point.x())
                .attribute(AttributeNames.y, point.y())
                .attribute(AttributeNames.type, point.type())
                .closeElement();
    }

    @Override
    protected void childInSwitch(HWPXObject child) {
        switch (child._objectType()) {
            case hp_point:
                point((Point) child);
                break;
        }
    }
}
