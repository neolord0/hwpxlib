package kr.dogfoot.hwpxlib.reader.section_xml.control;

import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.OLE;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;

public class OLEReader extends ElementReader {
    private OLE ole;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.OLE;
    }

    public void ole(OLE ole) {
        this.ole = ole;
    }

    @Override
    public SwitchableObject switchableObject() {
        return ole;
    }
}
