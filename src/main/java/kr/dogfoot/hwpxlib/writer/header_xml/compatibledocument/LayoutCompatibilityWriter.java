package kr.dogfoot.hwpxlib.writer.header_xml.compatibledocument;

import kr.dogfoot.hwpxlib.commonstrings.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectList;
import kr.dogfoot.hwpxlib.object.content.header_xml.LayoutCompatibilityItem;
import kr.dogfoot.hwpxlib.writer.common.ElementWriter;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterManager;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterSort;

public class LayoutCompatibilityWriter extends ElementWriter {
    public LayoutCompatibilityWriter(ElementWriterManager elementWriterManager) {
        super(elementWriterManager);
    }

    @Override
    public ElementWriterSort sort() {
        return ElementWriterSort.LayoutCompatibility;
    }

    @Override
    public void write(HWPXObject object) {
        ObjectList<LayoutCompatibilityItem> layoutCompatibility = (ObjectList<LayoutCompatibilityItem>) object;
        switchList(layoutCompatibility.switchList());

        xsb()
                .openElement(ElementNames.hh_layoutCompatibility)
                .elementWriter(this);

        for (LayoutCompatibilityItem item : layoutCompatibility.items()) {
            item(item);
        }

        xsb().closeElement();
        releaseMe();
    }

    private void item(LayoutCompatibilityItem item) {
        xsb()
                .openElement(item.name())
                .text(item.text())
                .closeElement();
    }

    @Override
    protected void childInSwitch(HWPXObject child) {
        switch (child._objectType()) {
            case each_layoutCompatibilityItem:
                item((LayoutCompatibilityItem) child);
                break;
        }
    }
}
