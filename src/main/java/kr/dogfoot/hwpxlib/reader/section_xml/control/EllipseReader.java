package kr.dogfoot.hwpxlib.reader.section_xml.control;

import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.Ellipse;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;

public class EllipseReader extends ElementReader {
    private Ellipse ellipse;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.Ellipse;
    }

    public void ellipse(Ellipse ellipse) {
        this.ellipse = ellipse;
    }

    @Override
    public SwitchableObject switchableObject() {
        return ellipse;
    }
}
