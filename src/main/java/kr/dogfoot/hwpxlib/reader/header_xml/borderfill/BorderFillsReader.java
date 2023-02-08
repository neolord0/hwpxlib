package kr.dogfoot.hwpxlib.reader.header_xml.borderfill;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectList;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.BorderFill;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.util.ElementNames;
import org.xml.sax.Attributes;

public class BorderFillsReader extends ElementReader {
    private ObjectList<BorderFill> borderFills;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.BorderFills;
    }

    @Override
    public void childElement(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.BorderFill:
                borderFill(borderFills.addNew(), name, attrs);
                break;
        }
    }

    @Override
    public HWPXObject childElementInSwitch(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.BorderFill:
                BorderFill borderFill = new BorderFill();
                borderFill(borderFill, name, attrs);
                return borderFill;
        }
        return null;
    }

    private void borderFill(BorderFill borderFill, String name, Attributes attrs) {
        ((BorderFillReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.BorderFill))
                .borderFill(borderFill);

        xmlFileReader().startElement(name, attrs);
    }

    @Override
    public SwitchableObject switchableObject() {
        return borderFills;
    }

    public void borderFills(ObjectList<BorderFill> borderFills) {
        this.borderFills = borderFills;
    }
}
