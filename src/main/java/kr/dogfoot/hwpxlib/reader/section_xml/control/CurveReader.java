package kr.dogfoot.hwpxlib.reader.section_xml.control;

import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.Curve;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;

public class CurveReader extends ElementReader {
    private Curve curve;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.Curve;
    }

    public void curve(Curve curve) {
        this.curve = curve;
    }

    @Override
    public SwitchableObject switchableObject() {
        return curve;
    }
}
