package kr.dogfoot.hwpxlib.writer.section_xml.secpr;

import kr.dogfoot.hwpxlib.commonstirngs.AttributeNames;
import kr.dogfoot.hwpxlib.commonstirngs.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.baseobject.LeftRightTopBottom;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.secpr.notepr.*;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.secpr.pageborder.PageBorderFill;
import kr.dogfoot.hwpxlib.writer.common.ElementWriter;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterManager;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterSort;

public class PageBorderFillWriter extends ElementWriter {
    public PageBorderFillWriter(ElementWriterManager elementWriterManager) {
        super(elementWriterManager);
    }

    @Override
    public ElementWriterSort sort() {
        return ElementWriterSort.PageBorderFill;
    }

    @Override
    public void write(HWPXObject object) {
        PageBorderFill pageBorderFill = (PageBorderFill) object;
        switchObject(pageBorderFill.switchObject());

        xsb()
                .openElement(ElementNames.hp_pageBorderFill)
                .elementWriter(this)
                .attribute(AttributeNames.type, pageBorderFill.type())
                .attribute(AttributeNames.borderFillIDRef, pageBorderFill.borderFillIDRef())
                .attribute(AttributeNames.textBorder, pageBorderFill.textBorder())
                .attribute(AttributeNames.headerInside, pageBorderFill.headerInside())
                .attribute(AttributeNames.footerInside, pageBorderFill.footerInside())
                .attribute(AttributeNames.fillArea, pageBorderFill.fillArea());

        if (pageBorderFill.offset() != null) {
            leftRightTopBottom(ElementNames.hp_offset, pageBorderFill.offset());
        }

        xsb().closeElement();
        releaseMe();
    }

    @Override
    protected void childInSwitch(HWPXObject child) {
        switch (child._objectType()) {
            case hp_offset_for_pageBorderFill:
                leftRightTopBottom(ElementNames.hp_offset, (LeftRightTopBottom) child);
                break;
        }
    }
}
