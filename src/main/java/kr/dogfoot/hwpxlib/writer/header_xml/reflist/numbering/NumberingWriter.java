package kr.dogfoot.hwpxlib.writer.header_xml.reflist.numbering;

import kr.dogfoot.hwpxlib.commonstirngs.AttributeNames;
import kr.dogfoot.hwpxlib.commonstirngs.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.Numbering;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.numbering.ParaHead;
import kr.dogfoot.hwpxlib.writer.common.ElementWriter;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterManager;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterSort;
import kr.dogfoot.hwpxlib.writer.util.XMLStringBuilder;

public class NumberingWriter extends ElementWriter {
    public NumberingWriter(ElementWriterManager elementWriterManager) {
        super(elementWriterManager);
    }

    @Override
    public ElementWriterSort sort() {
        return ElementWriterSort.Numbering;
    }

    @Override
    public void write(HWPXObject object) {
        Numbering numbering = (Numbering) object;
        storeSwitchObject(numbering.switchObject());

        xsb()
                .openElement(ElementNames.hh_numbering)
                .elementWriter(this)
                .attribute(AttributeNames.id, numbering.id())
                .attribute(AttributeNames.start, numbering.start());

        for (ParaHead paraHead : numbering.paraHeads()) {
            paraHead(paraHead, xsb());
        }

        xsb().closeElement();
        releaseMe();
    }

    public static void paraHead(ParaHead paraHead, XMLStringBuilder xsb) {
        xsb
                .openElement(ElementNames.hh_paraHead)
                .attribute(AttributeNames.start, paraHead.start())
                .attribute(AttributeNames.level, paraHead.level());
        if (paraHead.align() != null) {
            xsb.attribute(AttributeNames.align, paraHead.align().str());
        }
        xsb
                .attribute(AttributeNames.useInstWidth, paraHead.useInstWidth())
                .attribute(AttributeNames.autoIndent, paraHead.autoIndent())
                .attribute(AttributeNames.widthAdjust, paraHead.widthAdjust());
        if (paraHead.textOffsetType() != null) {
            xsb.attribute(AttributeNames.textOffsetType, paraHead.textOffsetType().str());
        }
        xsb.attribute(AttributeNames.textOffset, paraHead.textOffset());
        if (paraHead.numFormat() != null) {
            xsb.attribute(AttributeNames.numFormat, paraHead.numFormat().str());
        }
        xsb
                .attribute(AttributeNames.charPrIDRef, paraHead.charPrIDRef())
                .attribute(AttributeNames.checkable, paraHead.checkable())
                .text(paraHead.text())
                .closeElement();
    }

    @Override
    protected void childInSwitch(HWPXObject child) {
        switch (child._objectType()) {
            case hh_paraHead:
                paraHead((ParaHead) child, xsb());
                break;
        }
    }
}
