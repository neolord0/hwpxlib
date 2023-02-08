package kr.dogfoot.hwpxlib.reader.section_xml.control;

import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.Dutmal;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;

public class DutmalReader extends ElementReader {
    private Dutmal dutmal;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.Dutmal;
    }

    public void dutmal(Dutmal dutmal) {
        this.dutmal = dutmal;
    }

    @Override
    public SwitchableObject switchableObject() {
        return dutmal;
    }
}
