package kr.dogfoot.hwpxlib.writer.section_xml;

import kr.dogfoot.hwpxlib.commonstrings.AttributeNames;
import kr.dogfoot.hwpxlib.commonstrings.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectList;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.LineSeg;
import kr.dogfoot.hwpxlib.writer.common.ElementWriter;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterManager;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterSort;

public class LineSegArrayWriter extends ElementWriter {
    public LineSegArrayWriter(ElementWriterManager elementWriterManager) {
        super(elementWriterManager);
    }

    @Override
    public ElementWriterSort sort() {
        return ElementWriterSort.LineSegArray;
    }

    @Override
    public void write(HWPXObject object) {
        ObjectList<LineSeg> lineSegArray = (ObjectList<LineSeg>) object;
        switchList(lineSegArray.switchList());

        xsb()
                .openElement(ElementNames.hp_linesegarray)
                .elementWriter(this);

        for (LineSeg lineSeq : lineSegArray.items()) {
            lineSeq(lineSeq);
        }

        xsb().closeElement();
        releaseMe();
    }

    private void lineSeq(LineSeg lineSeq) {
        xsb()
                .openElement(ElementNames.hp_lineseg)
                .attribute(AttributeNames.textpos, lineSeq.textpos())
                .attribute(AttributeNames.vertpos, lineSeq.vertpos())
                .attribute(AttributeNames.vertsize, lineSeq.vertsize())
                .attribute(AttributeNames.textheight, lineSeq.textheight())
                .attribute(AttributeNames.baseline, lineSeq.baseline())
                .attribute(AttributeNames.spacing, lineSeq.spacing())
                .attribute(AttributeNames.horzpos, lineSeq.horzpos())
                .attribute(AttributeNames.horzsize, lineSeq.horzsize())
                .attribute(AttributeNames.flags , lineSeq.flags())
                .closeElement();
    }

    @Override
    protected void childInSwitch(HWPXObject child) {
        switch (child._objectType()) {
            case hp_lineseg:
                lineSeq((LineSeg) child);
                break;
        }
    }
}
