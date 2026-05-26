package kr.dogfoot.hwpxlib.reader.section_xml.t;

import kr.dogfoot.hwpxlib.commonstrings.AttributeNames;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.MarkpenBeginForRun;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.t.MarkpenBegin;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;

public class MarkpenBeginReader extends ElementReader {
    private MarkpenBegin markpenBegin;
    private MarkpenBeginForRun markpenBeginForRun;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.MarkpenBegin;
    }

    public void markpenBegin(MarkpenBegin markpenBegin) {
        this.markpenBegin = markpenBegin;
        this.markpenBeginForRun = null;
    }

    public void markpenBeginForRun(MarkpenBeginForRun markpenBeginForRun) {
        this.markpenBeginForRun = markpenBeginForRun;
        this.markpenBegin = null;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.color:
                if (markpenBegin != null) {
                    markpenBegin.color(value);
                } else if (markpenBeginForRun != null) {
                    markpenBeginForRun.color(value);
                }
                break;
        }
    }

    @Override
    public SwitchableObject switchableObject() {
        return null;
    }

}
