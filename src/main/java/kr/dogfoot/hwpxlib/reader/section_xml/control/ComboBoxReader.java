package kr.dogfoot.hwpxlib.reader.section_xml.control;

import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.ComboBox;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;

public class ComboBoxReader extends ElementReader {
    private ComboBox comboBox;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.ComboBox;
    }

    @Override
    public SwitchableObject switchableObject() {
        return comboBox;
    }

    public void comboBox(ComboBox comboBox) {
        this.comboBox = comboBox;
    }
}
