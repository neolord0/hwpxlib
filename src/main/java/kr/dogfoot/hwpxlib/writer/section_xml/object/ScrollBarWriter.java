package kr.dogfoot.hwpxlib.writer.section_xml.object;

import kr.dogfoot.hwpxlib.commonstrings.AttributeNames;
import kr.dogfoot.hwpxlib.commonstrings.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.ScrollBar;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterManager;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterSort;
import kr.dogfoot.hwpxlib.writer.section_xml.object.formobject.FormObjectWriter;

public class ScrollBarWriter extends FormObjectWriter {
    public ScrollBarWriter(ElementWriterManager elementWriterManager) {
        super(elementWriterManager);
    }

    @Override
    public ElementWriterSort sort() {
        return ElementWriterSort.ScrollBar;
    }

    @Override
    public void write(HWPXObject object) {
        ScrollBar scrollBar = (ScrollBar) object;
        switchObject(scrollBar.switchObject());

        xsb()
                .openElement(ElementNames.hp_scrollBar)
                .elementWriter(this)
                .attribute(AttributeNames.delay, scrollBar.delay())
                .attribute(AttributeNames.largeChange, scrollBar.largeChange())
                .attribute(AttributeNames.smallChange, scrollBar.smallChange())
                .attribute(AttributeNames.min, scrollBar.min())
                .attribute(AttributeNames.max, scrollBar.max())
                .attribute(AttributeNames.page, scrollBar.page())
                .attribute(AttributeNames.value, scrollBar.value())
                .attribute(AttributeNames.type, scrollBar.type());
        writeAttributeForFormObject(scrollBar);

        writeChildrenForFormObject(scrollBar);

        writeChildrenForShapeObject(scrollBar);

        xsb().closeElement();
        releaseMe();
    }
}
