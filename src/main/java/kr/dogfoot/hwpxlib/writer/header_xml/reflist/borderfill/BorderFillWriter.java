package kr.dogfoot.hwpxlib.writer.header_xml.reflist.borderfill;

import kr.dogfoot.hwpxlib.commonstirngs.AttributeNames;
import kr.dogfoot.hwpxlib.commonstirngs.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.BorderFill;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.borderfill.Border;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.borderfill.SlashCore;
import kr.dogfoot.hwpxlib.writer.common.ElementWriter;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterManager;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterSort;

public class BorderFillWriter extends ElementWriter {
    public BorderFillWriter(ElementWriterManager elementWriterManager) {
        super(elementWriterManager);
    }

    @Override
    public ElementWriterSort sort() {
        return ElementWriterSort.BorderFill;
    }

    @Override
    public void write(HWPXObject object) {
        BorderFill borderFill = (BorderFill) object;
        switchObject(borderFill.switchObject());

        xsb()
                .openElement(ElementNames.hh_borderFill)
                .elementWriter(this)
                .attribute(AttributeNames.id, borderFill.id())
                .attribute(AttributeNames.threeD, borderFill.threeD())
                .attribute(AttributeNames.shadow, borderFill.shadow())
                .attribute(AttributeNames.centerLine, borderFill.centerLine())
                .attribute(AttributeNames.breakCellSeparateLine, borderFill.breakCellSeparateLine());

        if (borderFill.slash() != null) {
            slashCore(ElementNames.hh_slash, borderFill.slash());
        }

        if (borderFill.backSlash() != null) {
            slashCore(ElementNames.hh_backSlash, borderFill.backSlash());
        }

        if (borderFill.leftBorder() != null) {
            border(ElementNames.hh_leftBorder, borderFill.leftBorder());
        }

        if (borderFill.rightBorder() != null) {
            border(ElementNames.hh_rightBorder, borderFill.rightBorder());
        }

        if (borderFill.topBorder() != null) {
            border(ElementNames.hh_topBorder, borderFill.topBorder());
        }

        if (borderFill.bottomBorder() != null) {
            border(ElementNames.hh_bottomBorder, borderFill.bottomBorder());
        }

        if (borderFill.diagonal() != null) {
            border(ElementNames.hh_diagonal, borderFill.diagonal());
        }

        if (borderFill.fillBrush() != null) {
            writeChild(ElementWriterSort.FillBrush, borderFill.fillBrush());
        }

        xsb().closeElement();
        releaseMe();
    }

    private void slashCore(String elementName, SlashCore slashCore) {
          xsb()
                  .openElement(elementName)
                  .attribute(AttributeNames.type, slashCore.type())
                  .attribute(AttributeNames.Crooked, slashCore.Crooked())
                  .attribute(AttributeNames.isCounter, slashCore.isCounter())
                  .closeElement();
    }

    private void border(String elementName, Border border) {
        xsb()
                .openElement(elementName)
                .attribute(AttributeNames.type, border.type())
                .attribute(AttributeNames.width, border.width())
                .attribute(AttributeNames.color, border.color())
                .closeElement();
    }

    @Override
    protected void childInSwitch(HWPXObject child) {
        switch (child._objectType()) {
            case hh_slash:
                slashCore(ElementNames.hh_slash, (SlashCore) child);
                break;
            case hh_backSlash:
                slashCore(ElementNames.hh_backSlash, (SlashCore) child);
                break;
            case hh_leftBorder:
                border(ElementNames.hh_leftBorder, (Border) child);
                break;
            case hh_rightBorder:
                border(ElementNames.hh_rightBorder, (Border) child);
                break;
            case hh_topBorder:
                border(ElementNames.hh_topBorder, (Border) child);
                break;
            case hh_bottomBorder:
                border(ElementNames.hh_bottomBorder, (Border) child);
                break;
            case hh_diagonal:
                border(ElementNames.hh_diagonal, (Border) child);
                break;
            case hc_fillBrush:
                writeChild(ElementWriterSort.FillBrush, child);
                break;
        }
    }
}
