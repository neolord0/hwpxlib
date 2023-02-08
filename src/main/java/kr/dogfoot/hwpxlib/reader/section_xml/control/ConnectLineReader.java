package kr.dogfoot.hwpxlib.reader.section_xml.control;

import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.ConnectLine;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;

public class ConnectLineReader extends ElementReader {
    private ConnectLine connectLine;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.ConnectLine;
    }

    public void connectLine(ConnectLine connectLine) {
        this.connectLine = connectLine;
    }

    @Override
    public SwitchableObject switchableObject() {
        return connectLine;
    }
}
