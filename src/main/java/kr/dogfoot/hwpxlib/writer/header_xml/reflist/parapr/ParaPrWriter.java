package kr.dogfoot.hwpxlib.writer.header_xml.reflist.parapr;

import kr.dogfoot.hwpxlib.commonstrings.AttributeNames;
import kr.dogfoot.hwpxlib.commonstrings.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.ParaPr;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.parapr.*;
import kr.dogfoot.hwpxlib.writer.common.ElementWriter;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterManager;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterSort;

public class ParaPrWriter extends ElementWriter {
    public ParaPrWriter(ElementWriterManager elementWriterManager) {
        super(elementWriterManager);
    }

    @Override
    public ElementWriterSort sort() {
        return ElementWriterSort.ParaPr;
    }

    @Override
    public void write(HWPXObject object) {
        ParaPr paraPr = (ParaPr) object;
        switchList(paraPr.switchList());

        xsb()
                .openElement(ElementNames.hh_paraPr)
                .elementWriter(this)
                .attribute(AttributeNames.id, paraPr.id())
                .attribute(AttributeNames.tabPrIDRef, paraPr.tabPrIDRef())
                .attribute(AttributeNames.condense, paraPr.condense())
                .attribute(AttributeNames.fontLineHeight, paraPr.fontLineHeight())
                .attribute(AttributeNames.snapToGrid, paraPr.snapToGrid())
                .attribute(AttributeNames.suppressLineNumbers, paraPr.suppressLineNumbers())
                .attribute(AttributeNames.checked, paraPr.checked());

        if (paraPr.align() != null) {
            align(paraPr.align());
        }

        if (paraPr.heading() != null) {
            heading(paraPr.heading());
        }

        if (paraPr.breakSetting() != null) {
            breakSetting(paraPr.breakSetting());
        }

        if (paraPr.autoSpacing() != null) {
            autoSpacing(paraPr.autoSpacing());
        }

        if (paraPr.margin() != null) {
            writeChild(ElementWriterSort.ParaMargin, paraPr.margin());
        }

        if (paraPr.lineSpacing() != null) {
            lineSpacing(paraPr.lineSpacing());
        }

        if (paraPr.border() != null) {
            border(paraPr.border());
        }

        xsb().closeElement();
        releaseMe();
    }

    private void align(Align align) {
        xsb()
                .openElement(ElementNames.hh_align)
                .attribute(AttributeNames.horizontal, align.horizontal())
                .attribute(AttributeNames.vertical, align.vertical())
                .closeElement();
    }

    private void heading(Heading heading) {
        xsb()
                .openElement(ElementNames.hh_heading)
                .attribute(AttributeNames.type, heading.type())
                .attribute(AttributeNames.idRef, heading.idRef())
                .attribute(AttributeNames.level, heading.level())
                .closeElement();
    }

    private void breakSetting(BreakSetting breakSetting) {
        xsb()
                .openElement(ElementNames.hh_breakSetting)
                .attribute(AttributeNames.breakLatinWord, breakSetting.breakLatinWord())
                .attribute(AttributeNames.breakNonLatinWord, breakSetting.breakNonLatinWord())
                .attribute(AttributeNames.widowOrphan, breakSetting.widowOrphan())
                .attribute(AttributeNames.keepWithNext, breakSetting.keepWithNext())
                .attribute(AttributeNames.keepLines, breakSetting.keepLines())
                .attribute(AttributeNames.pageBreakBefore, breakSetting.pageBreakBefore())
                .attribute(AttributeNames.lineWrap, breakSetting.lineWrap())
                .closeElement();
    }

    private void autoSpacing(AutoSpacing autoSpacing) {
        xsb()
                .openElement(ElementNames.hh_autoSpacing)
                .attribute(AttributeNames.eAsianEng, autoSpacing.eAsianEng())
                .attribute(AttributeNames.eAsianNum, autoSpacing.eAsianNum())
                .closeElement();
    }

    private void lineSpacing(LineSpacing lineSpacing) {
        xsb()
                .openElement(ElementNames.hh_lineSpacing)
                .attribute(AttributeNames.type, lineSpacing.type())
                .attribute(AttributeNames.value, lineSpacing.value())
                .attribute(AttributeNames.unit, lineSpacing.unit())
                .closeElement();
    }

    private void border(ParaBorder border) {
        xsb()
                .openElement(ElementNames.hh_border)
                .attribute(AttributeNames.borderFillIDRef, border.borderFillIDRef())
                .attribute(AttributeNames.offsetLeft, border.offsetLeft())
                .attribute(AttributeNames.offsetRight, border.offsetRight())
                .attribute(AttributeNames.offsetTop, border.offsetTop())
                .attribute(AttributeNames.offsetBottom, border.offsetBottom())
                .attribute(AttributeNames.connect, border.connect())
                .attribute(AttributeNames.ignoreMargin, border.ignoreMargin())
                .closeElement();
    }

    @Override
    protected void childInSwitch(HWPXObject child) {
        switch (child._objectType()) {
            case hh_align:
                align((Align) child);
                break;
            case hh_heading:
                heading((Heading) child);
                break;
            case hh_breakSetting:
                breakSetting((BreakSetting) child);
                break;
            case hh_margin:
                writeChild(ElementWriterSort.ParaMargin, child);
                break;
            case hh_lineSpacing:
                lineSpacing((LineSpacing) child);
                break;
            case hh_border:
                border((ParaBorder) child);
                break;
            case hh_autoSpacing:
                autoSpacing((AutoSpacing) child);
                break;
        }
    }
}
