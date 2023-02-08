package kr.dogfoot.hwpxlib.reader.section_xml.control;

import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.Button;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;

public class ButtonReader extends ElementReader {
    private Button button;

    @Override
    public ElementReaderSort sort() {
        return null;
    }

    @Override
    public SwitchableObject switchableObject() {
        return null;
    }

    public void button(Button button) {
        this.button = button;
    }
}
