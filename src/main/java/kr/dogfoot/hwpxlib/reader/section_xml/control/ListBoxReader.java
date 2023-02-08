package kr.dogfoot.hwpxlib.reader.section_xml.control;

import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.ListBox;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;

public class ListBoxReader extends ElementReader {
    private ListBox listBox;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.ListBox;
    }

    public void listBox(ListBox listBox) {
        this.listBox = listBox;
    }

    @Override
    public SwitchableObject switchableObject() {
        return null;
    }
}
