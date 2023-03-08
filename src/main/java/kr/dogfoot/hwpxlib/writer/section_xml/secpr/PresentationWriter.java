package kr.dogfoot.hwpxlib.writer.section_xml.secpr;

import kr.dogfoot.hwpxlib.commonstirngs.AttributeNames;
import kr.dogfoot.hwpxlib.commonstirngs.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.secpr.Presentation;
import kr.dogfoot.hwpxlib.writer.common.ElementWriter;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterManager;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterSort;

public class PresentationWriter extends ElementWriter {
    public PresentationWriter(ElementWriterManager elementWriterManager) {
        super(elementWriterManager);
    }

    @Override
    public ElementWriterSort sort() {
        return ElementWriterSort.Presentation;
    }

    @Override
    public void write(HWPXObject object) {
        Presentation presentation = (Presentation) object;
        switchObject(presentation.switchObject());

        xsb()
                .openElement(ElementNames.hp_presentation)
                .elementWriter(this)
                .attribute(AttributeNames.effect, presentation.effect())
                .attribute(AttributeNames.soundIDRef, presentation.soundIDRef())
                .attribute(AttributeNames.inventText, presentation.inventText())
                .attribute(AttributeNames.autoshow, presentation.autoshow())
                .attribute(AttributeNames.showtime, presentation.showtime())
                .attribute(AttributeNames.applyto, presentation.applyto());

        if (presentation.fillBrush() != null) {
            writeChild(ElementWriterSort.FillBrush, presentation.fillBrush());
        }

        xsb().closeElement();
        releaseMe();
    }

    @Override
    protected void childInSwitch(HWPXObject child) {
        switch (child._objectType()) {
            case hc_fillBrush:
                writeChild(ElementWriterSort.FillBrush, child);
                break;
        }
    }
}


