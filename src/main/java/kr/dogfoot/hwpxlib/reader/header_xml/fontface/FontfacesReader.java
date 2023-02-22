package kr.dogfoot.hwpxlib.reader.header_xml.fontface;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.Fontface;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.Fontfaces;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.object.names.ElementNames;
import org.xml.sax.Attributes;

public class FontfacesReader extends ElementReader {
    private Fontfaces fontfaces;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.Fontfaces;
    }

    @Override
    public void childElement(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.hh_fontface:
                fontFace(fontfaces.addNewFontface(), name, attrs);
                break;
        }
    }

    @Override
    public HWPXObject childElementInSwitch(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.hh_fontface:
                Fontface fontface = new Fontface();
                fontFace(fontface, name, attrs);
                return fontface;
        }
        return null;
    }

    private void fontFace(Fontface fontface, String name, Attributes attrs) {
        ((FontfaceReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.Fontface))
                .fontface(fontface);

        xmlFileReader().startElement(name, attrs);
    }

    @Override
    public SwitchableObject switchableObject() {
        return fontfaces;
    }

    public void fontfaces(Fontfaces fontfaces) {
        this.fontfaces = fontfaces;
    }
}
