package kr.dogfoot.hwpxlib.writer.common;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;

public class NothingWriter extends ElementWriter {
    public NothingWriter(ElementWriterManager elementWriterManager) {
        super(elementWriterManager);
    }

    @Override
    public ElementWriterSort sort() {
        return ElementWriterSort.Nothing;
    }

    @Override
    public void write(HWPXObject object) {
        // nothing
    }
}
