package kr.dogfoot.hwpxlib.writer.section_xml;

import kr.dogfoot.hwpxlib.commonstrings.AttributeNames;
import kr.dogfoot.hwpxlib.commonstrings.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.Para;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.Run;
import kr.dogfoot.hwpxlib.writer.common.ElementWriter;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterManager;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterSort;

public class ParaWriter extends ElementWriter {
    public ParaWriter(ElementWriterManager elementWriterManager) {
        super(elementWriterManager);
    }

    @Override
    public ElementWriterSort sort() {
        return ElementWriterSort.Para;
    }

    @Override
    public void write(HWPXObject object) {
        Para para = (Para) object;
        switchObject(para.switchObject());

        xsb()
                .openElement(ElementNames.hp_p)
                .elementWriter(this)
                .attribute(AttributeNames.id, para.id())
                .attribute(AttributeNames.paraPrIDRef, para.paraPrIDRef())
                .attribute(AttributeNames.styleIDRef, para.styleIDRef())
                .attribute(AttributeNames.pageBreak, para.pageBreak())
                .attribute(AttributeNames.columnBreak, para.columnBreak())
                .attribute(AttributeNames.merged, para.merged())
                .attribute(AttributeNames.paraTcId, para.paraTcId());

        for (Run run : para.runs()) {
            writeChild(ElementWriterSort.Run, run);
        }

        if (para.lineSegArray() != null) {
            writeChild(ElementWriterSort.LineSegArray, para.lineSegArray());
        }

        xsb().closeElement();
        releaseMe();
    }
}
