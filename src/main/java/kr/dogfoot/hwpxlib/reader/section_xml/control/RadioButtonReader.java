package kr.dogfoot.hwpxlib.reader.section_xml.control;

import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.RadioButton;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;

public class RadioButtonReader extends ElementReader {
    private RadioButton radioButton;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.RadioBtn;
    }

    public void radioButton(RadioButton radioButton) {
        this.radioButton = radioButton;
    }

    @Override
    public SwitchableObject switchableObject() {
        return radioButton;
    }
}
