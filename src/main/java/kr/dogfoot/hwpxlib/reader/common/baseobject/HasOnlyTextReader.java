package kr.dogfoot.hwpxlib.reader.common.baseobject;

import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.common.baseobject.HasOnlyText;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;

public class HasOnlyTextReader extends ElementReader {
    private HasOnlyText hasOnlyText;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.HasOnlyText;
    }

    public void hasOnlyText(HasOnlyText hasOnlyText) {
        this.hasOnlyText = hasOnlyText;
    }

    @Override
    public void text(String text) {
        hasOnlyText.addText(text);
    }

    @Override
    public SwitchableObject switchableObject() {
        return null;
    }
}
