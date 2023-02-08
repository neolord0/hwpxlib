package kr.dogfoot.hwpxlib.reader.section_xml.control;

import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.ScrollBar;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;

public class ScrollBarReader extends ElementReader {
    private ScrollBar scrollBar;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.ScrollBar;
    }

    public void scrollBar(ScrollBar scrollBar) {
        this.scrollBar = scrollBar;
    }

    @Override
    public SwitchableObject switchableObject() {
        return scrollBar;
    }
}
