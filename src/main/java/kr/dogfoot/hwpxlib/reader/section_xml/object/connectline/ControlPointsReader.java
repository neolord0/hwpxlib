package kr.dogfoot.hwpxlib.reader.section_xml.object.connectline;

import kr.dogfoot.hwpxlib.commonstrings.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectList;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.connectline.Point;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import org.xml.sax.Attributes;

public class ControlPointsReader extends ElementReader {
    private ObjectList<Point> controlPoints;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.ControlPoints;
    }

    @Override
    public void childElement(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.hp_point:
                point(controlPoints.addNew(), name, attrs);
                break;
        }
    }

    @Override
    public HWPXObject childElementInSwitch(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.hp_point:
                Point point = new Point();
                point(point, name, attrs);
                return point;
        }
        return null;
    }

    private void point(Point point, String name, Attributes attrs) {
        ((PointForControlPointsReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.PointForControlPoints))
                .point(point);

        xmlFileReader().startElement(name, attrs);
    }

    @Override
    public SwitchableObject switchableObject() {
        return controlPoints;
    }

    public void controlPoints(ObjectList<Point> controlPoints) {
        this.controlPoints = controlPoints;
    }
}