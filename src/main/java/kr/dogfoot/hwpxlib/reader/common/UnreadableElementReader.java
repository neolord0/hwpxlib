package kr.dogfoot.hwpxlib.reader.common;

import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import org.xml.sax.Attributes;

public class UnreadableElementReader extends ElementReader {
    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.Unreadable;
    }


    public void childElement(String name, Attributes attrs) {
        xmlFileReader().setCurrentElementReader(ElementReaderSort.Unreadable);
    }

    @Override
    public SwitchableObject switchableObject() {
        return null;
    }
}
