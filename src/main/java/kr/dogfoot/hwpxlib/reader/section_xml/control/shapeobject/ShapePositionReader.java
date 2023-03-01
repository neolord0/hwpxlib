package kr.dogfoot.hwpxlib.reader.section_xml.control.shapeobject;

import kr.dogfoot.hwpxlib.commonstirngs.AttributeNames;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.HorzAlign;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.HorzRelTo;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.VertAlign;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.VertRelTo;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapeobject.ShapePosition;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.util.ValueConvertor;

public class ShapePositionReader extends ElementReader {
    private ShapePosition pos;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.ShapePosition;
    }

    public void pos(ShapePosition pos) {
        this.pos = pos;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.treatAsChar:
                pos.treatAsChar(ValueConvertor.toBoolean(value));
                break;
            case AttributeNames.affectLSpacing:
                pos.affectLSpacing(ValueConvertor.toBoolean(value));
                break;
            case AttributeNames.flowWithText:
                pos.flowWithText(ValueConvertor.toBoolean(value));
                break;
            case AttributeNames.allowOverlap:
                pos.allowOverlap(ValueConvertor.toBoolean(value));
                break;
            case AttributeNames.holdAnchorAndSO:
                pos.holdAnchorAndSO(ValueConvertor.toBoolean(value));
                break;
            case AttributeNames.vertRelTo:
                pos.vertRelTo(VertRelTo.fromString(value));
                break;
            case AttributeNames.horzRelTo:
                pos.horzRelTo(HorzRelTo.fromString(value));
                break;
            case AttributeNames.vertAlign:
                pos.vertAlign(VertAlign.fromString(value));
                break;
            case AttributeNames.horzAlign:
                pos.horzAlign(HorzAlign.fromString(value));
                break;
            case AttributeNames.vertOffset:
                pos.vertOffset(ValueConvertor.toLong(value));
                break;
            case AttributeNames.horzOffset:
                pos.horzOffset(ValueConvertor.toLong(value));
                break;
        }
    }

    @Override
    public SwitchableObject switchableObject() {
        return null;
    }
}
