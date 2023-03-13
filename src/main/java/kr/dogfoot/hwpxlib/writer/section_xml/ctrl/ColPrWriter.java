package kr.dogfoot.hwpxlib.writer.section_xml.ctrl;

import kr.dogfoot.hwpxlib.commonstrings.AttributeNames;
import kr.dogfoot.hwpxlib.commonstrings.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.ctrl.ColPr;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.ctrl.inner.ColLine;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.ctrl.inner.ColSz;
import kr.dogfoot.hwpxlib.writer.common.ElementWriter;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterManager;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterSort;

public class ColPrWriter extends ElementWriter {
    public ColPrWriter(ElementWriterManager elementWriterManager) {
        super(elementWriterManager);
    }

    @Override
    public ElementWriterSort sort() {
        return ElementWriterSort.ColPr;
    }

    @Override
    public void write(HWPXObject object) {
        ColPr colPr = (ColPr) object;
        switchObject(colPr.switchObject());

        xsb()
                .openElement(ElementNames.hp_colPr)
                .elementWriter(this)
                .attribute(AttributeNames.id, colPr.id())
                .attribute(AttributeNames.type, colPr.type())
                .attribute(AttributeNames.layout, colPr.layout())
                .attribute(AttributeNames.colCount, colPr.colCount())
                .attribute(AttributeNames.sameSz, colPr.sameSz())
                .attribute(AttributeNames.sameGap, colPr.sameGap());

        for (ColSz colSz : colPr.colSzs()) {
            colSz(colSz);
        }

        if (colPr.colLine() != null) {
            colLine(colPr.colLine());
        }

        xsb().closeElement();
        releaseMe();;
    }

    private void colSz(ColSz colSz) {
        xsb()
                .openElement(ElementNames.hp_colSz)
                .attribute(AttributeNames.width, colSz.width())
                .attribute(AttributeNames.gap, colSz.gap())
                .closeElement();
    }

    private void colLine(ColLine colLine) {
        xsb()
                .openElement(ElementNames.hp_colLine)
                .attribute(AttributeNames.type, colLine.type())
                .attribute(AttributeNames.width, colLine.width())
                .attribute(AttributeNames.color, colLine.color())
                .closeElement();
    }

    @Override
    protected void childInSwitch(HWPXObject child) {
        switch (child._objectType()) {
            case hp_colSz:
                colSz((ColSz) child);
                break;
            case hp_colLine:
                colLine((ColLine) child);
                break;
        }
    }
}
