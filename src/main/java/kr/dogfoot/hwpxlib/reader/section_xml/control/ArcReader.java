package kr.dogfoot.hwpxlib.reader.section_xml.control;

import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.Arc;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;

public class ArcReader extends ElementReader {
    private Arc arc;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.Arc;
    }

    public void arc(Arc arc) {
        this.arc = arc;
    }

    @Override
    public SwitchableObject switchableObject() {
        return arc;
    }
}
