package kr.dogfoot.hwpxlib.reader.section_xml.control;

import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.Polygon;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;

public class PolygonReader extends ElementReader {
    private Polygon polygon;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.Polygon;
    }

    public void polygon(Polygon polygon) {
        this.polygon = polygon;
    }

    @Override
    public SwitchableObject switchableObject() {
        return polygon;
    }
}
