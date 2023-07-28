package kr.dogfoot.hwpxlib.writer.section_xml.object;

import kr.dogfoot.hwpxlib.commonstrings.AttributeNames;
import kr.dogfoot.hwpxlib.commonstrings.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.Compose;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.compose.ComposeCharPr;
import kr.dogfoot.hwpxlib.writer.common.ElementWriter;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterManager;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterSort;

public class ComposeWriter extends ElementWriter {
    public ComposeWriter(ElementWriterManager elementWriterManager) {
        super(elementWriterManager);
    }

    @Override
    public ElementWriterSort sort() {
        return ElementWriterSort.Compose;
    }

    @Override
    public void write(HWPXObject object) {
        Compose compose = (Compose) object;
        switchList(compose.switchList());

        xsb()
                .openElement(ElementNames.hp_compose)
                .elementWriter(this)
                .attribute(AttributeNames.circleType, compose.circleType())
                .attribute(AttributeNames.charSz, compose.charSz())
                .attribute(AttributeNames.composeType, compose.composeType())
                .attribute(AttributeNames.charPrCnt, compose.countOfCharPr())
                .attribute(AttributeNames.composeText, compose.composeText());

        for (ComposeCharPr charPr : compose.charPrs()) {
            charPr(charPr);
        }

        xsb().closeElement();
        releaseMe();
    }

    private void charPr(ComposeCharPr charPr) {
        xsb()
                .openElement(ElementNames.hp_charPr)
                .attribute(AttributeNames.prIDRef, charPr.prIDRef())
                .closeElement();
    }

    @Override
    protected void childInSwitch(HWPXObject child) {
        switch (child._objectType()) {
            case hp_charPr:
                charPr((ComposeCharPr) child);
                break;
        }
    }
}
