package kr.dogfoot.hwpxlib.reader.section_xml.control;

import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.CheckButton;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;

public class CheckButtonReader extends ElementReader {
    private CheckButton checkButton;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.CheckBtn;
    }

    public void checkButton(CheckButton checkButton) {
        this.checkButton = checkButton;
    }

    @Override
    public SwitchableObject switchableObject() {
        return checkButton;
    }
}
