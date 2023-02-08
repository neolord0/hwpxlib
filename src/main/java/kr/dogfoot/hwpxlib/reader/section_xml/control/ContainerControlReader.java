package kr.dogfoot.hwpxlib.reader.section_xml.control;

import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.Container;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;

public class ContainerControlReader extends ElementReader {
    private Container container;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.ContainerControl;
    }

    public void container(Container container) {
        this.container = container;
    }

    @Override
    public SwitchableObject switchableObject() {
        return container;
    }
}
