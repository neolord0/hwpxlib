package kr.dogfoot.hwpxlib.reader.header_xml.memopr;

import kr.dogfoot.hwpxlib.commonstirngs.AttributeNames;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.LineType2;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.LineWidth;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.MemoType;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.MemoPr;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.util.ValueConvertor;

public class MemoPrReader extends ElementReader {
    private MemoPr memoPr;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.MemoPr;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.id:
                memoPr.id(value);
                break;
            case AttributeNames.width:
                memoPr.width(ValueConvertor.toInteger(value));
                break;
            case AttributeNames.lineType:
                memoPr.lineType(LineType2.fromString(value));
                break;
            case AttributeNames.lineWidth:
                memoPr.lineWidth(LineWidth.fromIndex(ValueConvertor.toByte(value)));
                break;
            case AttributeNames.lineColor:
                memoPr.lineColor(value);
                break;
            case AttributeNames.fillColor:
                memoPr.fillColor(value);
                break;
            case AttributeNames.activeColor:
                memoPr.activeColor(value);
                break;
            case AttributeNames.memoType:
                memoPr.memoType(MemoType.fromString(value));
                break;
        }
    }

    @Override
    public SwitchableObject switchableObject() {
        return null;
    }

    public void memoPr(MemoPr memoPr) {
        this.memoPr = memoPr;
    }
}
