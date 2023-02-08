package kr.dogfoot.hwpxlib.reader.section_xml.control;

import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.Edit;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;

public class EditReader extends ElementReader {
    private Edit edit;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.Edit;
    }

    public void edit(Edit edit) {
        this.edit = edit;
    }

    @Override
    public SwitchableObject switchableObject() {
        return edit;
    }
}
