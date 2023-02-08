package kr.dogfoot.hwpxlib.reader.header_xml.charpr;

import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.LineType2;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.charpr.Strikeout;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.util.AttributeNames;

public class StrikeoutReader extends ElementReader {
    private Strikeout strikeout;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.Strikeout;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.shape:
                strikeout.shape(LineType2.fromString(value));
                break;
            case AttributeNames.color:
                strikeout.color(value);
                break;
        }
    }

    @Override
    public SwitchableObject switchableObject() {
        return null;
    }

    public void strikeout(Strikeout strikeout) {
        this.strikeout = strikeout;
    }
}
