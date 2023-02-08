package kr.dogfoot.hwpxlib.reader.header_xml.compatibledocument;

import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.header_xml.LayoutCompatibilityItem;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;

public class LayoutCompatibilityItemReader extends ElementReader {
    private LayoutCompatibilityItem item;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.LayoutCompatibilityItem;
    }

    @Override
    public void text(String text) {
        item.text(text);
    }

    @Override
    public SwitchableObject switchableObject() {
        return null;
    }

    public void layoutCompatibilityItem(LayoutCompatibilityItem item) {
        this.item  = item;
    }
}
