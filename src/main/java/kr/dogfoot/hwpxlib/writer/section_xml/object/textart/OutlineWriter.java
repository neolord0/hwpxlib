package kr.dogfoot.hwpxlib.writer.section_xml.object.textart;

import kr.dogfoot.hwpxlib.commonstrings.AttributeNames;
import kr.dogfoot.hwpxlib.commonstrings.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectList;
import kr.dogfoot.hwpxlib.object.common.baseobject.Point;
import kr.dogfoot.hwpxlib.writer.common.ElementWriter;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterManager;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterSort;

public class OutlineWriter extends ElementWriter {
    public OutlineWriter(ElementWriterManager elementWriterManager) {
        super(elementWriterManager);
    }

    @Override
    public ElementWriterSort sort() {
        return ElementWriterSort.Outline;
    }

    @Override
    public void write(HWPXObject object) {
        ObjectList<Point> outline = (ObjectList<Point>) object;
        switchObject(outline.switchObject());

        xsb()
                .openElement(ElementNames.hp_outline)
                .elementWriter(this)
                .attribute(AttributeNames.cnt, outline.count());

        for (Point point : outline.items()) {
            point(ElementNames.hc_pt, point);
        }

        xsb().closeElement();
        releaseMe();
    }

    @Override
    protected void childInSwitch(HWPXObject child) {
        switch (child._objectType()) {
            case hc_pt:
                point(ElementNames.hc_pt, (Point) child);
                break;
        }
    }
}
