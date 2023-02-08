package kr.dogfoot.hwpxlib.reader.section_xml.ctrl;

import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.ctrl.inner.ColSz;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.util.ValueConvertor;
import kr.dogfoot.hwpxlib.util.AttributeNames;

public class ColSzReader extends ElementReader {
    private ColSz colSz;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.ColSz;
    }

    public void colSz(ColSz colSz) {
        this.colSz = colSz;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.width:
                colSz.width(ValueConvertor.toInteger(value));
                break;
            case AttributeNames.gap:
                colSz.gap(ValueConvertor.toInteger(value));
                break;
        }
    }

    @Override
    public SwitchableObject switchableObject() {
        return null;
    }
}
