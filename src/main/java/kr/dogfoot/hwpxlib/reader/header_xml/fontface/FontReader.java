package kr.dogfoot.hwpxlib.reader.header_xml.fontface;

import kr.dogfoot.hwpxlib.commonstirngs.AttributeNames;
import kr.dogfoot.hwpxlib.commonstirngs.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.FontType;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.fontface.Font;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.fontface.SubstFont;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.fontface.TypeInfo;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.util.ValueConvertor;
import org.xml.sax.Attributes;

public class FontReader extends ElementReader {
    private Font font;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.Font;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.id:
                font.id(value);
                break;
            case AttributeNames.face:
                font.face(value);
                break;
            case AttributeNames.type:
                font.type(FontType.fromString(value));
                break;
            case AttributeNames.isEmbedded:
                font.isEmbedded(ValueConvertor.toBoolean(value));
                break;
            case AttributeNames.binaryItemIDRef:
                font.binaryItemIDRef(value);
                break;
        }
    }

    @Override
    public void childElement(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.hh_substFont:
                font.createSubstFont();
                substFont(font.substFont(), name, attrs);
                break;
            case ElementNames.hh_typeInfo:
                font.createTypeInfo();
                typeInfo(font.typeInfo(), name, attrs);
                break;
        }
    }

    @Override
    public HWPXObject childElementInSwitch(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.hh_substFont:
                SubstFont substFont = new SubstFont();
                substFont(substFont, name, attrs);
                return substFont;
            case ElementNames.hh_typeInfo:
                TypeInfo typeInfo = new TypeInfo();
                typeInfo(typeInfo, name, attrs);
                return typeInfo;
        }
        return null;
    }

    private void substFont(SubstFont substFont, String name, Attributes attrs) {
        ((SubstFontReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.SubstFont))
                .substFont(substFont);

        xmlFileReader().startElement(name, attrs);
    }

    private void typeInfo(TypeInfo typeInfo, String name, Attributes attrs) {
        ((TypeInfoReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.TypeInfo))
                .typeInfo(typeInfo);

        xmlFileReader().startElement(name, attrs);
    }

    @Override
    public SwitchableObject switchableObject() {
        return font;
    }

    public void font(Font font) {
        this.font = font;
    }
}
