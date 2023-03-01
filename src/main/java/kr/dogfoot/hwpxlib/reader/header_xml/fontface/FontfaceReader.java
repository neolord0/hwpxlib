package kr.dogfoot.hwpxlib.reader.header_xml.fontface;

import kr.dogfoot.hwpxlib.commonstirngs.AttributeNames;
import kr.dogfoot.hwpxlib.commonstirngs.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.LanguageType;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.Fontface;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.fontface.Font;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import org.xml.sax.Attributes;

public class FontfaceReader extends ElementReader {
    private Fontface fontface;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.Fontface;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.lang:
                fontface.lang(LanguageType.fromString(value));
                break;
        }
    }

    @Override
    public void childElement(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.hh_font:
                font(fontface.addNewFont(), name, attrs);
                break;
        }
    }

    @Override
    public HWPXObject childElementInSwitch(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.hh_font:
                Font font = new Font();
                font(font, name, attrs);
                return font;
        }
        return null;
    }

    private void font(Font font, String name, Attributes attrs) {
        ((FontReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.Font))
                .font(font);

        xmlFileReader().startElement(name, attrs);
    }

    @Override
    public SwitchableObject switchableObject() {
        return fontface;
    }

    public void fontface(Fontface fontface) {
        this.fontface = fontface;
    }
}
