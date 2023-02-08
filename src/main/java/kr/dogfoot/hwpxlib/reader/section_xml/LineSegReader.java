package kr.dogfoot.hwpxlib.reader.section_xml;

import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.LineSeg;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.util.ValueConvertor;
import kr.dogfoot.hwpxlib.util.AttributeNames;

public class LineSegReader extends ElementReader {
    private LineSeg lineSeg;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.LineSeg;
    }

    public void lineSeg(LineSeg lineSeg) {
        this.lineSeg = lineSeg;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.textpos:
                lineSeg.textpos(ValueConvertor.toInteger(value));
                break;
            case AttributeNames.vertpos:
                lineSeg.vertpos(ValueConvertor.toInteger(value));
                break;
            case AttributeNames.vertsize:
                lineSeg.vertsize(ValueConvertor.toInteger(value));
                break;
            case AttributeNames.textheight:
                lineSeg.textheight(ValueConvertor.toInteger(value));
                break;
            case AttributeNames.baseline:
                lineSeg.baseline(ValueConvertor.toInteger(value));
                break;
            case AttributeNames.spacing:
                lineSeg.spacing(ValueConvertor.toInteger(value));
                break;
            case AttributeNames.horzpos:
                lineSeg.horzpos(ValueConvertor.toInteger(value));
                break;
            case AttributeNames.horzsize:
                lineSeg.horzsize(ValueConvertor.toInteger(value));
                break;
            case AttributeNames.flags:
                lineSeg.flags(ValueConvertor.toInteger(value));
                break;
        }
    }

    @Override
    public SwitchableObject switchableObject() {
        return null;
    }
}
