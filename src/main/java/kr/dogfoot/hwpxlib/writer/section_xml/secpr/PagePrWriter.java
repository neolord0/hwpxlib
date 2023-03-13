package kr.dogfoot.hwpxlib.writer.section_xml.secpr;

import kr.dogfoot.hwpxlib.commonstrings.AttributeNames;
import kr.dogfoot.hwpxlib.commonstrings.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.secpr.pagepr.PageMargin;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.secpr.pagepr.PagePr;
import kr.dogfoot.hwpxlib.writer.common.ElementWriter;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterManager;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterSort;

public class PagePrWriter extends ElementWriter {
    public PagePrWriter(ElementWriterManager elementWriterManager) {
        super(elementWriterManager);
    }

    @Override
    public ElementWriterSort sort() {
        return ElementWriterSort.PagePr;
    }

    @Override
    public void write(HWPXObject object) {
        PagePr pagePr = (PagePr) object;
        switchObject(pagePr.switchObject());

        xsb()
                .openElement(ElementNames.hp_pagePr)
                .elementWriter(this)
                .attribute(AttributeNames.landscape, pagePr.landscape())
                .attribute(AttributeNames.width, pagePr.width())
                .attribute(AttributeNames.height, pagePr.height())
                .attribute(AttributeNames.gutterType, pagePr.gutterType());

        if (pagePr.margin() != null) {
            margin(pagePr.margin());
        }

        xsb().closeElement();
        releaseMe();
    }

    private void margin(PageMargin margin) {
        xsb()
                .openElement(ElementNames.hp_margin)
                .attribute(AttributeNames.header, margin.header())
                .attribute(AttributeNames.footer, margin.footer())
                .attribute(AttributeNames.gutter, margin.gutter())
                .attribute(AttributeNames.left, margin.left())
                .attribute(AttributeNames.right, margin.right())
                .attribute(AttributeNames.top, margin.top())
                .attribute(AttributeNames.bottom, margin.bottom())
                .closeElement();
    }

    @Override
    protected void childInSwitch(HWPXObject child) {
        switch (child._objectType()) {
            case hp_margin:
                margin((PageMargin) child);
                break;
        }
    }
}
