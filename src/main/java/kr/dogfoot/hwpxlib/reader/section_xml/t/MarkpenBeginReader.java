package kr.dogfoot.hwpxlib.reader.section_xml.t;

import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.t.MarkpenBegin;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.util.ValueConvertor;
import kr.dogfoot.hwpxlib.util.AttributeNames;

public class MarkpenBeginReader extends ElementReader {
    private MarkpenBegin markpenBegin;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.MarkpenBegin;
    }

    public void markpenBegin(MarkpenBegin markpenBegin) {
        this.markpenBegin = markpenBegin;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.beginColor:
                markpenBegin.beginColor(value);
                break;
        }
    }

    @Override
    public SwitchableObject switchableObject() {
        return null;
    }
}
