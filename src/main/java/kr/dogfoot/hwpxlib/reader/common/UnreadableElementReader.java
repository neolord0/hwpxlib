package kr.dogfoot.hwpxlib.reader.common;

import kr.dogfoot.hwpxlib.object.common.SwitchableObject;

public class UnreadableElementReader extends ElementReader {
    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.Unreadable;
    }

    @Override
    protected void setAttribute(String name, String value) {
        xmlFileReader().setCurrentElementReader(ElementReaderSort.Unreadable);
    }

    @Override
    public SwitchableObject switchableObject() {
        return null;
    }
}
