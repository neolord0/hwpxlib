package kr.dogfoot.hwpxlib.reader.section_xml.secpr;

import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.LineType2;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.LineWidth;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.secpr.notepr.NoteLine;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.util.ValueConvertor;
import kr.dogfoot.hwpxlib.util.AttributeNames;

public class NoteLineReader extends ElementReader {
    private NoteLine noteLine;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.NoteLine;
    }

    public void noteLine(NoteLine noteLine) {
        this.noteLine = noteLine;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.length:
                noteLine.length(ValueConvertor.toInteger(value));
                break;
            case AttributeNames.type:
                noteLine.type(LineType2.fromString(value));
                break;
            case AttributeNames.width:
                noteLine.width(LineWidth.fromString(value));
                break;
            case AttributeNames.color:
                noteLine.color(value);
                break;
        }
    }

    @Override
    public SwitchableObject switchableObject() {
        return null;
    }
}
