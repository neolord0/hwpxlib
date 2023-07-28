package kr.dogfoot.hwpxlib.writer.section_xml.ctrl;

import kr.dogfoot.hwpxlib.commonstrings.AttributeNames;
import kr.dogfoot.hwpxlib.commonstrings.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.ctrl.inner.AutoNumNewNumCore;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.secpr.notepr.AutoNumFormat;
import kr.dogfoot.hwpxlib.writer.common.ElementWriter;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterManager;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterSort;
import kr.dogfoot.hwpxlib.writer.section_xml.secpr.FootNotePrWriter;

public class AutoNumNewNumWriter extends ElementWriter {
    public AutoNumNewNumWriter(ElementWriterManager elementWriterManager) {
        super(elementWriterManager);
    }

    @Override
    public ElementWriterSort sort() {
        return ElementWriterSort.AutoNumNewNum;
    }

    @Override
    public void write(HWPXObject object) {
        AutoNumNewNumCore autoNumNewNum = (AutoNumNewNumCore) object;
        switchList(autoNumNewNum.switchList());

        switch (autoNumNewNum._objectType()) {
            case hp_autoNum:
                xsb().openElement(ElementNames.hp_autoNum);
                break;
            case hp_newNum:
                xsb().openElement(ElementNames.hp_newNum);
                break;
        }

        xsb()
                .elementWriter(this)
                .attribute(AttributeNames.num, autoNumNewNum.num())
                .attribute(AttributeNames.numType, autoNumNewNum.numType());

        if (autoNumNewNum.autoNumFormat() != null) {
            FootNotePrWriter.autoNumFormat(autoNumNewNum.autoNumFormat(), xsb());
        }

        xsb().closeElement();
        releaseMe();
    }

    @Override
    protected void childInSwitch(HWPXObject child) {
        switch (child._objectType()) {
            case hp_autoNumFormat:
                FootNotePrWriter.autoNumFormat((AutoNumFormat) child, xsb());
                break;
        }
    }
}
