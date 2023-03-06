package kr.dogfoot.hwpxlib.writer.section_xml.object;

import com.sun.tools.javac.comp.Check;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.writer.common.ElementWriter;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterManager;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterSort;

public class CheckButtonWriter extends ElementWriter {
    public CheckButtonWriter(ElementWriterManager elementWriterManager) {
        super(elementWriterManager);
    }

    @Override
    public ElementWriterSort sort() {
        return ElementWriterSort.CheckButton;
    }

    @Override
    public void write(HWPXObject object) {

    }
}
