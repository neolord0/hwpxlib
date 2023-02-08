package kr.dogfoot.hwpxlib.reader.section_xml.control;

import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.Line;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;

public class LineReader extends ElementReader {
    private Line line;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.Line;
    }

    public void line(Line line) {
        this.line = line;
    }

    @Override
    public SwitchableObject switchableObject() {
        return line;
    }
}
