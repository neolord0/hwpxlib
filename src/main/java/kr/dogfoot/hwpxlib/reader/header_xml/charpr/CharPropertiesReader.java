package kr.dogfoot.hwpxlib.reader.header_xml.charpr;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectList;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.CharPr;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.util.ElementNames;
import org.xml.sax.Attributes;

public class CharPropertiesReader extends ElementReader {
    private ObjectList<CharPr> charProperties;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.CharProperties;
    }

    @Override
    public void childElement(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.hh_charPr:
                charPr(charProperties.addNew(), name, attrs);
                break;
        }
    }

    @Override
    public HWPXObject childElementInSwitch(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.hh_charPr:
                CharPr charPr = new CharPr();
                charPr(charPr, name, attrs);
                return charPr;
        }
        return null;
    }

    private void charPr(CharPr charPr, String name, Attributes attrs) {
        ((CharPrReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.CharPr))
                .charPr(charPr);

        xmlFileReader().startElement(name, attrs);
    }

    @Override
    public SwitchableObject switchableObject() {
        return charProperties;
    }

    public void charProperties(ObjectList<CharPr> charProperties) {
        this.charProperties = charProperties;
    }
}
