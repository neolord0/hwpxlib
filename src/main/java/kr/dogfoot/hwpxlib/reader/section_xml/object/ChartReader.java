package kr.dogfoot.hwpxlib.reader.section_xml.object;

import kr.dogfoot.hwpxlib.commonstrings.AttributeNames;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.Chart;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapeobject.ShapeObject;
import kr.dogfoot.hwpxlib.reader.ContentFilesReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.section_xml.object.shapeobject.ShapeObjectReader;
import kr.dogfoot.hwpxlib.reader.util.ValueConvertor;

public class ChartReader extends ShapeObjectReader {
    private Chart chart;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.Chart;
    }

    @Override
    public ShapeObject shapeObject() {
        return chart;
    }

    public void chart(Chart chart) {
        this.chart = chart;

        ((ContentFilesReader) xmlFileReader()).addChart(chart);
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.chartIDRef:
                chart.chartIDRef(value);
                break;
            case AttributeNames.version:
                chart.version(ValueConvertor.toFloat(value));
                break;
            default:
                super.setAttribute(name, value);
                break;
        }
    }

    @Override
    public SwitchableObject switchableObject() {
        return chart;
    }
}
