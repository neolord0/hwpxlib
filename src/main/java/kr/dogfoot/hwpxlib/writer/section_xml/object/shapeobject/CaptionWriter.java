package kr.dogfoot.hwpxlib.writer.section_xml.object.shapeobject;

import kr.dogfoot.hwpxlib.commonstirngs.AttributeNames;
import kr.dogfoot.hwpxlib.commonstirngs.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapeobject.Caption;
import kr.dogfoot.hwpxlib.writer.common.ElementWriter;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterManager;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterSort;

public class CaptionWriter extends ElementWriter {
    public CaptionWriter(ElementWriterManager elementWriterManager) {
        super(elementWriterManager);
    }

    @Override
    public ElementWriterSort sort() {
        return ElementWriterSort.Caption;
    }

    @Override
    public void write(HWPXObject object) {
        Caption caption = (Caption) object;
        switchObject(caption.switchObject());

        xsb()
                .openElement(ElementNames.hp_caption)
                .elementWriter(this)
                .attribute(AttributeNames.side, caption.side())
                .attribute(AttributeNames.fullSz, caption.fullSz())
                .attribute(AttributeNames.width, caption.width())
                .attribute(AttributeNames.gap, caption.gap())
                .attribute(AttributeNames.lastWidth, caption.lastWidth());

        if (caption.subList() != null) {
            writeChild(ElementWriterSort.SubList, caption.subList());
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
