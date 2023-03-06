package kr.dogfoot.hwpxlib.writer.header_xml.reflist.borderfill;

import kr.dogfoot.hwpxlib.commonstirngs.AttributeNames;
import kr.dogfoot.hwpxlib.commonstirngs.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectList;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.BorderFill;
import kr.dogfoot.hwpxlib.writer.common.ElementWriter;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterManager;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterSort;

public class BorderFillsWriter extends ElementWriter {
    public BorderFillsWriter(ElementWriterManager elementWriterManager) {
        super(elementWriterManager);
    }

    @Override
    public ElementWriterSort sort() {
        return ElementWriterSort.BorderFills;
    }

    @Override
    public void write(HWPXObject object) {
        ObjectList<BorderFill> borderFills = (ObjectList<BorderFill>) object;
        switchObject(borderFills.switchObject());
        if (borderFills.count() == 0) {
            return;
        }

        xsb()
                .openElement(ElementNames.hh_borderFills)
                .elementWriter(this)
                .attribute(AttributeNames.itemCnt, borderFills.count());

        for (BorderFill borderFill : borderFills.items()) {
            writeChild(ElementWriterSort.BorderFill, borderFill);
        }

        xsb().closeElement();
        releaseMe();
    }

    @Override
    protected void childInSwitch(HWPXObject child) {
        switch (child._objectType()) {
            case hh_borderFill:
                writeChild(ElementWriterSort.BorderFill, child);
                break;
        }
    }
}
