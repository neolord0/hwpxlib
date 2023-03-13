package kr.dogfoot.hwpxlib.writer.section_xml.ctrl;

import kr.dogfoot.hwpxlib.commonstrings.AttributeNames;
import kr.dogfoot.hwpxlib.commonstrings.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.ctrl.inner.HeaderFooterCore;
import kr.dogfoot.hwpxlib.writer.common.ElementWriter;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterManager;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterSort;

public class HeaderFooterWriter extends ElementWriter {
    public HeaderFooterWriter(ElementWriterManager elementWriterManager) {
        super(elementWriterManager);
    }

    @Override
    public ElementWriterSort sort() {
        return ElementWriterSort.HeaderFooter;
    }

    @Override
    public void write(HWPXObject object) {
        HeaderFooterCore headerFooter = (HeaderFooterCore) object;
        switchObject(headerFooter.switchObject());

        switch (headerFooter._objectType()) {
            case hp_header:
                xsb().openElement(ElementNames.hp_header);
                break;
            case hp_footer:
                xsb().openElement(ElementNames.hp_footer);
                break;
        }

        xsb()
                .elementWriter(this)
                .attribute(AttributeNames.id, headerFooter.id())
                .attribute(AttributeNames.applyPageType, headerFooter.applyPageType());

        if (headerFooter.subList() != null) {
            writeChild(ElementWriterSort.SubList, headerFooter.subList());
        }

        xsb().closeElement();
        releaseMe();
    }

    @Override
    protected void childInSwitch(HWPXObject child) {
        switch (child._objectType()) {
            case hp_subList:
                writeChild(ElementWriterSort.SubList, child);
                break;
        }
    }
}
