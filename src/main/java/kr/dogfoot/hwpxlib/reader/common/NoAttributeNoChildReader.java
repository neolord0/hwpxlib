package kr.dogfoot.hwpxlib.reader.common;

import kr.dogfoot.hwpxlib.object.common.SwitchableObject;

public class NoAttributeNoChildReader extends ElementReader {
    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.Empty;
    }

    @Override
    public SwitchableObject switchableObject() {
        return null;
    }
}
