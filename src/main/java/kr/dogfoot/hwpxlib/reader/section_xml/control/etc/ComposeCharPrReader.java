package kr.dogfoot.hwpxlib.reader.section_xml.control.etc;

import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.compose.ComposeCharPr;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.commonstirngs.AttributeNames;

public class ComposeCharPrReader extends ElementReader {
    private ComposeCharPr charPr;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.ComposeCharPr;
    }

    public void charPr(ComposeCharPr charPr) {
        this.charPr = charPr;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.prIDRef:
                charPr.prIDRef(value);
                break;
        }
    }

    @Override
    public SwitchableObject switchableObject() {
        return null;
    }
}
