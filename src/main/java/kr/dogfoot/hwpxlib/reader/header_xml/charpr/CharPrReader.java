package kr.dogfoot.hwpxlib.reader.header_xml.charpr;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.SymMarkSort;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.CharPr;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.charpr.*;
import kr.dogfoot.hwpxlib.util.AttributeNames;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.util.ValueConvertor;
import kr.dogfoot.hwpxlib.util.ElementNames;
import org.xml.sax.Attributes;

public class CharPrReader extends ElementReader {
    private CharPr charPr;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.CharPr;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.id:
                charPr.id(value);
                break;
            case AttributeNames.height:
                charPr.height(ValueConvertor.toInteger(value));
                break;
            case AttributeNames.textColor:
                charPr.textColor(value);
                break;
            case AttributeNames.shadeColor:
                charPr.shadeColor(value);
                break;
            case AttributeNames.useFontSpace:
                charPr.useFontSpace(ValueConvertor.toBoolean(value));
                break;
            case AttributeNames.useKerning:
                charPr.useKerning(ValueConvertor.toBoolean(value));
                break;
            case AttributeNames.symMark:
                charPr.symMarkAnd(SymMarkSort.fromString(value));
                break;
            case AttributeNames.borderFillIDRef:
                charPr.borderFillIDRef(value);
                break;
        }
    }

    @Override
    public void childElement(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.FontRef:
                charPr.createFontRef();
                fontRef(charPr.fontRef(), name, attrs);
                break;
            case ElementNames.Ratio:
                charPr.createRatio();
                ratio(charPr.ratio(), name, attrs);
                break;
            case ElementNames.Spacing:
                charPr.createSpacing();
                spacing(charPr.spacing(), name, attrs);
                break;
            case ElementNames.RelSz:
                charPr.createRelSz();
                relSz(charPr.relSz(), name, attrs);
                break;
            case ElementNames.CharOffset:
                charPr.createOffset();
                offset(charPr.offset(), name, attrs);
                break;
            case ElementNames.Bold:
                charPr.createBold();
                xmlFileReader().noAttributeNoChild(name, attrs);
                break;
            case ElementNames.Italic:
                charPr.createItalic();
                xmlFileReader().noAttributeNoChild(name, attrs);
                break;
            case ElementNames.Underline:
                charPr.createUnderline();
                underline(charPr.underline(), name, attrs);
                break;
            case ElementNames.Strikeout:
                charPr.createStrikeout();
                strikeout(charPr.strikeout(), name, attrs);
                break;
            case ElementNames.Outline:
                charPr.createOutline();
                outline(charPr.outline(), name, attrs);
                break;
            case ElementNames.CharShadow:
                charPr.createShadow();
                shadow(charPr.shadow(), name, attrs);
                break;
            case ElementNames.Emboss:
                charPr.createEmboss();
                xmlFileReader().noAttributeNoChild(name, attrs);
                break;
            case ElementNames.Engrave:
                charPr.createEngrave();
                xmlFileReader().noAttributeNoChild(name, attrs);
                break;
            case ElementNames.Supscript:
                charPr.createSupscript();
                xmlFileReader().noAttributeNoChild(name, attrs);
                break;
            case ElementNames.Subscript:
                charPr.createSubscript();
                xmlFileReader().noAttributeNoChild(name, attrs);
                break;
        }
    }

    @Override
    public void childElementInSwitch(HWPXObject child, String name, Attributes attrs) {
        if (child.objectType() == ObjectType.FontRef) {
            fontRef((FontRef) child, name, attrs);
        } else if (child.objectType() == ObjectType.Ratio) {
            ratio((Ratio) child, name, attrs);
        } else if (child.objectType() == ObjectType.Spacing) {
            spacing((Spacing) child, name, attrs);
        } else if (child.objectType() == ObjectType.RelSz) {
            relSz((RelSz) child, name, attrs);
        } else if (child.objectType() == ObjectType.CharOffset) {
            offset((CharOffset) child, name, attrs);
        } else if (child.objectType() == ObjectType.Bold) {
            xmlFileReader().noAttributeNoChild(name, attrs);
        } else if (child.objectType() == ObjectType.Italic) {
            xmlFileReader().noAttributeNoChild(name, attrs);
        } else if (child.objectType() == ObjectType.Underline) {
            underline((Underline) child, name, attrs);
        } else if (child.objectType() == ObjectType.Strikeout) {
            strikeout((Strikeout) child, name, attrs);
        } else if (child.objectType() == ObjectType.Outline) {
            outline((Outline) child, name, attrs);
        } else if (child.objectType() == ObjectType.CharShadow) {
            shadow((CharShadow) child, name, attrs);
        } else if (child.objectType() == ObjectType.Emboss) {
            xmlFileReader().noAttributeNoChild(name, attrs);
        } else if (child.objectType() == ObjectType.Engrave) {
            xmlFileReader().noAttributeNoChild(name, attrs);
        } else if (child.objectType() == ObjectType.Supscript) {
            xmlFileReader().noAttributeNoChild(name, attrs);
        } else if (child.objectType() == ObjectType.Subscript) {
            xmlFileReader().noAttributeNoChild(name, attrs);
        }
    }


    private void fontRef(FontRef fontRef, String name, Attributes attrs) {
        ((StringValuesByLanguageReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.StringValuesByLanguageReader))
                .stringValuesByLanguage(fontRef);

        xmlFileReader().startElement(name, attrs);
    }

    private void ratio(Ratio ratio, String name, Attributes attrs) {
        ((ShortValuesByLanguageReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.ShortValuesByLanguageReader))
                .shortValuesByLanguage(ratio);

        xmlFileReader().startElement(name, attrs);
    }


    private void relSz(RelSz relSz, String name, Attributes attrs) {
        ((ShortValuesByLanguageReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.ShortValuesByLanguageReader))
                .shortValuesByLanguage(relSz);

        xmlFileReader().startElement(name, attrs);
    }

    private void spacing(Spacing spacing, String name, Attributes attrs) {
        ((ShortValuesByLanguageReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.ShortValuesByLanguageReader))
                .shortValuesByLanguage(spacing);

        xmlFileReader().startElement(name, attrs);
    }

    private void offset(CharOffset offset, String name, Attributes attrs) {
        ((ShortValuesByLanguageReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.ShortValuesByLanguageReader))
                .shortValuesByLanguage(offset);

        xmlFileReader().startElement(name, attrs);
    }

    private void underline(Underline underline, String name, Attributes attrs) {
        ((UnderlineReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.Underline))
                .underLine(underline);

        xmlFileReader().startElement(name, attrs);
    }

    private void strikeout(Strikeout strikeout, String name, Attributes attrs) {
        ((StrikeoutReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.Strikeout))
                .strikeout(strikeout);

        xmlFileReader().startElement(name, attrs);
    }

    private void outline(Outline outline, String name, Attributes attrs) {
        ((OutlineReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.Outline))
                .outline(outline);

        xmlFileReader().startElement(name, attrs);
    }

    private void shadow(CharShadow shadow, String name, Attributes attrs) {
        ((CharShadowReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.CharShadow))
                .charShadow(shadow);

        xmlFileReader().startElement(name, attrs);
    }

    @Override
    public SwitchableObject switchableObject() {
        return charPr;
    }

    public void charPr(CharPr charPr) {
        this.charPr = charPr;
    }
}
