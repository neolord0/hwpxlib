package kr.dogfoot.hwpxlib.reader.section_xml.control;

import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.Compose;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;

public class ComposeReader extends ElementReader {
    private Compose compose;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.Compose;
    }

    public void compose(Compose compose) {
        this.compose = compose;
    }

    @Override
    public SwitchableObject switchableObject() {
        return compose;
    }
}
