package kr.dogfoot.hwpxlib.reader.header_xml.parapr;

import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.HorizontalAlign2;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.VerticalAlign1;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.parapr.Align;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.util.AttributeNames;

public class AlignReader extends ElementReader {
    private Align align;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.Align;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.horizontal:
                align.horizontal(HorizontalAlign2.fromString(value));
                break;
            case AttributeNames.vertical:
                align.vertical(VerticalAlign1.fromString(value));
                break;
        }
    }

    @Override
    public SwitchableObject switchableObject() {
        return null;
    }

    public void align(Align align) {
        this.align = align;
    }
}
