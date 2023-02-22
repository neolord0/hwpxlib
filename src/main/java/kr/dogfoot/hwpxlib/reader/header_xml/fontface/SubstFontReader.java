package kr.dogfoot.hwpxlib.reader.header_xml.fontface;

import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.FontType;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.fontface.SubstFont;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.util.ValueConvertor;
import kr.dogfoot.hwpxlib.object.names.AttributeNames;

public class SubstFontReader extends ElementReader {
    private SubstFont substFont;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.SubstFont;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.face:
                substFont.face(value);
                break;
            case AttributeNames.type:
                substFont.type(FontType.fromString(value));
                break;
            case AttributeNames.isEmbedded:
                substFont.isEmbedded(ValueConvertor.toBoolean(value));
                break;
            case AttributeNames.binaryItemIDRef:
                substFont.binaryItemIDRef(value);
                break;
        }
    }

    @Override
    public SwitchableObject switchableObject() {
        return null;
    }

    public void substFont(SubstFont substFont) {
        this.substFont = substFont;
    }
}
