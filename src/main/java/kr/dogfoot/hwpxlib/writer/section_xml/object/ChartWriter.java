package kr.dogfoot.hwpxlib.writer.section_xml.object;

import kr.dogfoot.hwpxlib.commonstrings.AttributeNames;
import kr.dogfoot.hwpxlib.commonstrings.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.Chart;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterManager;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterSort;
import kr.dogfoot.hwpxlib.writer.section_xml.object.shapeobject.ShapeObjectWriter;

public class ChartWriter extends ShapeObjectWriter {
    public ChartWriter(ElementWriterManager elementWriterManager) {
        super(elementWriterManager);
    }

    @Override
    public ElementWriterSort sort() {
        return ElementWriterSort.Chart;
    }

    @Override
    public void write(HWPXObject object) {
        Chart chart = (Chart) object;
        switchObject(chart.switchObject());

        xsb()
                .openElement(ElementNames.hp_chart)
                .elementWriter(this);
        writeAttributeForShapeObject(chart);
        xsb()
                .attribute(AttributeNames.chartIDRef, chart.chartIDRef())
                .attribute(AttributeNames.version, chart.version());

        writeChildrenForShapeObject(chart);

        xsb().closeElement();
        releaseMe();
    }
}
