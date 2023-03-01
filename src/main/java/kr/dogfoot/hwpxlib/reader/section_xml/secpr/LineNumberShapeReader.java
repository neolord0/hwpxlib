package kr.dogfoot.hwpxlib.reader.section_xml.secpr;

import kr.dogfoot.hwpxlib.commonstirngs.AttributeNames;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.LineNumberRestartType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.secpr.LineNumberShape;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.util.ValueConvertor;

public class LineNumberShapeReader extends ElementReader {
    private LineNumberShape lineNumberShape;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.LineNumberShape;
    }

    public void lineNumberShape(LineNumberShape lineNumberShape) {
        this.lineNumberShape = lineNumberShape;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.restartType:
                lineNumberShape.restartType(LineNumberRestartType.fromString(value));
                break;
            case AttributeNames.countBy:
                lineNumberShape.countBy(ValueConvertor.toInteger(value));
                break;
            case AttributeNames.distance:
                lineNumberShape.distance(ValueConvertor.toInteger(value));
                break;
            case AttributeNames.startNumber:
                lineNumberShape.startNumberAnd(ValueConvertor.toInteger(value));
                break;
        }
    }

    @Override
    public SwitchableObject switchableObject() {
        return null;
    }
}
