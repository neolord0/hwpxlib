package kr.dogfoot.hwpxlib.reader.section_xml.control.picture;

import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.LineType2;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.ArrowSize;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.ArrowType;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.LineCap;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.OutlineStyle;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.picture.LineShape;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.util.ValueConvertor;
import kr.dogfoot.hwpxlib.util.AttributeNames;

public class LineShapeReader extends ElementReader {
    private LineShape lineShape;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.LineShape;
    }

    public void lineShape(LineShape lineShape) {
        this.lineShape = lineShape;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.color:
                lineShape.color(value);
                break;
            case AttributeNames.width:
                lineShape.width(ValueConvertor.toInteger(value));
                break;
            case AttributeNames.style:
                lineShape.style(LineType2.fromString(value));
                break;
            case AttributeNames.endCap:
                lineShape.endCap(LineCap.fromString(value));
                break;
            case AttributeNames.headStyle:
                lineShape.headStyle(ArrowType.fromString(value));
                break;
            case AttributeNames.tailStyle:
                lineShape.tailStyle(ArrowType.fromString(value));
                break;
            case AttributeNames.headfill:
                lineShape.headfill(ValueConvertor.toBoolean(value));
                break;
            case AttributeNames.tailfill:
                lineShape.tailfill(ValueConvertor.toBoolean(value));
                break;
            case AttributeNames.headSz:
                lineShape.headSz(ArrowSize.fromString(value));
                break;
            case AttributeNames.tailSz:
                lineShape.tailSz(ArrowSize.fromString(value));
                break;
            case AttributeNames.outlineStyle:
                lineShape.outlineStyle(OutlineStyle.fromString(value));
                break;
            case AttributeNames.alpha:
                lineShape.alpha(ValueConvertor.toFloat(value));
                break;
        }
    }

    @Override
    public SwitchableObject switchableObject() {
        return null;
    }
}
