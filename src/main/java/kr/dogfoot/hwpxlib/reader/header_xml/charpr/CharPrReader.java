package kr.dogfoot.hwpxlib.reader.header_xml.charpr;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.SymMarkSort;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.CharPr;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.charpr.*;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.util.ValueConvertor;
import kr.dogfoot.hwpxlib.util.AttributeNames;
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
            case ElementNames.hh_fontRef:
                charPr.createFontRef();
                fontRef(charPr.fontRef(), name, attrs);
                break;
            case ElementNames.hh_ratio:
                charPr.createRatio();
                ratio(charPr.ratio(), name, attrs);
                break;
            case ElementNames.hh_spacing:
                charPr.createSpacing();
                spacing(charPr.spacing(), name, attrs);
                break;
            case ElementNames.hh_relSz:
                charPr.createRelSz();
                relSz(charPr.relSz(), name, attrs);
                break;
            case ElementNames.hh_offset:
                charPr.createOffset();
                offset(charPr.offset(), name, attrs);
                break;
            case ElementNames.hh_bold:
                charPr.createBold();
                xmlFileReader().setCurrentEntryReaderForEmpty(name, attrs);
                break;
            case ElementNames.hh_italic:
                charPr.createItalic();
                xmlFileReader().setCurrentEntryReaderForEmpty(name, attrs);
                break;
            case ElementNames.hh_underline:
                charPr.createUnderline();
                underline(charPr.underline(), name, attrs);
                break;
            case ElementNames.hh_strikeout:
                charPr.createStrikeout();
                strikeout(charPr.strikeout(), name, attrs);
                break;
            case ElementNames.hh_outline:
                charPr.createOutline();
                outline(charPr.outline(), name, attrs);
                break;
            case ElementNames.hh_shadow:
                charPr.createShadow();
                shadow(charPr.shadow(), name, attrs);
                break;
            case ElementNames.hh_emboss:
                charPr.createEmboss();
                xmlFileReader().setCurrentEntryReaderForEmpty(name, attrs);
                break;
            case ElementNames.hh_engrave:
                charPr.createEngrave();
                xmlFileReader().setCurrentEntryReaderForEmpty(name, attrs);
                break;
            case ElementNames.hh_supscript:
                charPr.createSupscript();
                xmlFileReader().setCurrentEntryReaderForEmpty(name, attrs);
                break;
            case ElementNames.hh_subscript:
                charPr.createSubscript();
                xmlFileReader().setCurrentEntryReaderForEmpty(name, attrs);
                break;
        }
    }

    @Override
    public HWPXObject childElementInSwitch(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.hh_fontRef:
                FontRef fontRef = new FontRef();
                fontRef(fontRef, name, attrs);
                return fontRef;
            case ElementNames.hh_ratio:
                Ratio ratio = new Ratio();
                ratio(ratio, name, attrs);
                return ratio;
            case ElementNames.hh_spacing:
                Spacing spacing = new Spacing();
                spacing(spacing, name, attrs);
                return spacing;
            case ElementNames.hh_relSz:
                RelSz relSz = new RelSz();
                relSz(relSz, name, attrs);
                return relSz;
            case ElementNames.hh_offset:
                CharOffset offset = new CharOffset();
                offset(offset, name, attrs);
                return offset;
            case ElementNames.hh_bold:
                Bold bold = new Bold();
                xmlFileReader().setCurrentEntryReaderForEmpty(name, attrs);
                return bold;
            case ElementNames.hh_italic:
                Italic italic = new Italic();
                xmlFileReader().setCurrentEntryReaderForEmpty(name, attrs);
                return italic;
            case ElementNames.hh_underline:
                Underline underline = new Underline();
                underline(underline, name, attrs);
                return underline;
            case ElementNames.hh_strikeout:
                Strikeout strikeout = new Strikeout();
                strikeout(strikeout, name, attrs);
                return strikeout;
            case ElementNames.hh_outline:
                Outline outline = new Outline();
                outline(outline, name, attrs);
                return outline;
            case ElementNames.hh_shadow:
                CharShadow shadow = new CharShadow();
                shadow(shadow, name, attrs);
                return shadow;
            case ElementNames.hh_emboss:
                Emboss emboss = new Emboss();
                xmlFileReader().setCurrentEntryReaderForEmpty(name, attrs);
                return emboss;
            case ElementNames.hh_engrave:
                Engrave engrave = new Engrave();
                xmlFileReader().setCurrentEntryReaderForEmpty(name, attrs);
                return engrave;
            case ElementNames.hh_supscript:
                Supscript supscript = new Supscript();
                xmlFileReader().setCurrentEntryReaderForEmpty(name, attrs);
                return supscript;
            case ElementNames.hh_subscript:
                Subscript subscript = new Subscript();
                xmlFileReader().setCurrentEntryReaderForEmpty(name, attrs);
                return subscript;
        }
        return null;
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
