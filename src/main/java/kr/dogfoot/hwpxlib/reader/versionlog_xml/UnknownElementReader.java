package kr.dogfoot.hwpxlib.reader.versionlog_xml;

import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import org.xml.sax.Attributes;

public class UnknownElementReader extends ElementReader {
    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.UnknownElement;
    }

    @Override
    public void childElement(String name, Attributes attrs) {
        unknownChild(name, attrs);
    }

    private void unknownChild(String name, Attributes attrs) {
        xmlFileReader().setCurrentElementReader(ElementReaderSort.UnknownElement);
        xmlFileReader().startElement(name, attrs);
    }

    @Override
    public SwitchableObject switchableObject() {
        return null;
    }
}
