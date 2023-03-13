package kr.dogfoot.hwpxlib.reader.header_xml.charpr;

import kr.dogfoot.hwpxlib.commonstrings.AttributeNames;
import kr.dogfoot.hwpxlib.commonstrings.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.common.baseobject.NoAttributeNoChild;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.SymMarkSort;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.CharPr;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.charpr.*;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.util.ValueConvertor;
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
                stringValuesByLanguage(charPr.fontRef(), name, attrs);
                break;
            case ElementNames.hh_ratio:
                charPr.createRatio();
                shortValuesByLanguage(charPr.ratio(), name, attrs);
                break;
            case ElementNames.hh_spacing:
                charPr.createSpacing();
                shortValuesByLanguage(charPr.spacing(), name, attrs);
                break;
            case ElementNames.hh_relSz:
                charPr.createRelSz();
                shortValuesByLanguage(charPr.relSz(), name, attrs);
                break;
            case ElementNames.hh_offset:
                charPr.createOffset();
                shortValuesByLanguage(charPr.offset(), name, attrs);
                break;
            case ElementNames.hh_bold:
                charPr.createBold();
                xmlFileReader().setCurrentElementReaderForEmpty(name, attrs);
                break;
            case ElementNames.hh_italic:
                charPr.createItalic();
                xmlFileReader().setCurrentElementReaderForEmpty(name, attrs);
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
                xmlFileReader().setCurrentElementReaderForEmpty(name, attrs);
                break;
            case ElementNames.hh_engrave:
                charPr.createEngrave();
                xmlFileReader().setCurrentElementReaderForEmpty(name, attrs);
                break;
            case ElementNames.hh_supscript:
                charPr.createSupscript();
                xmlFileReader().setCurrentElementReaderForEmpty(name, attrs);
                break;
            case ElementNames.hh_subscript:
                charPr.createSubscript();
                xmlFileReader().setCurrentElementReaderForEmpty(name, attrs);
                break;
        }
    }

    @Override
    public HWPXObject childElementInSwitch(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.hh_fontRef:
                ValuesByLanguage<String> fontRef = new ValuesByLanguage<String>(ObjectType.hh_fontRef);
                stringValuesByLanguage(fontRef, name, attrs);
                return fontRef;
            case ElementNames.hh_ratio:
                ValuesByLanguage<Short> ratio = new ValuesByLanguage<Short>(ObjectType.hh_ratio);
                shortValuesByLanguage(ratio, name, attrs);
                return ratio;
            case ElementNames.hh_spacing:
                ValuesByLanguage<Short> spacing = new ValuesByLanguage<Short>(ObjectType.hh_spacing);
                shortValuesByLanguage(spacing, name, attrs);
                return spacing;
            case ElementNames.hh_relSz:
                ValuesByLanguage<Short> relSz = new ValuesByLanguage<Short>(ObjectType.hh_relSz);
                shortValuesByLanguage(relSz, name, attrs);
                return relSz;
            case ElementNames.hh_offset:
                ValuesByLanguage<Short> offset = new ValuesByLanguage<Short>(ObjectType.hh_offset);
                shortValuesByLanguage(offset, name, attrs);
                return offset;
            case ElementNames.hh_bold:
                NoAttributeNoChild bold = new NoAttributeNoChild(ObjectType.hh_bold);
                xmlFileReader().setCurrentElementReaderForEmpty(name, attrs);
                return bold;
            case ElementNames.hh_italic:
                NoAttributeNoChild italic = new NoAttributeNoChild(ObjectType.hh_italic);
                xmlFileReader().setCurrentElementReaderForEmpty(name, attrs);
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
                NoAttributeNoChild emboss = new NoAttributeNoChild(ObjectType.hh_emboss);
                xmlFileReader().setCurrentElementReaderForEmpty(name, attrs);
                return emboss;
            case ElementNames.hh_engrave:
                NoAttributeNoChild engrave = new NoAttributeNoChild(ObjectType.hh_engrave);
                xmlFileReader().setCurrentElementReaderForEmpty(name, attrs);
                return engrave;
            case ElementNames.hh_supscript:
                NoAttributeNoChild supscript = new NoAttributeNoChild(ObjectType.hh_supscript);
                xmlFileReader().setCurrentElementReaderForEmpty(name, attrs);
                return supscript;
            case ElementNames.hh_subscript:
                NoAttributeNoChild subscript = new NoAttributeNoChild(ObjectType.hh_subscript);
                xmlFileReader().setCurrentElementReaderForEmpty(name, attrs);
                return subscript;
        }
        return null;
    }


    private void stringValuesByLanguage(ValuesByLanguage<String> stringValuesByLanguage, String name, Attributes attrs) {
        ((StringValuesByLanguageReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.StringValuesByLanguageReader))
                .stringValuesByLanguage(stringValuesByLanguage);

        xmlFileReader().startElement(name, attrs);
    }

    private void shortValuesByLanguage(ValuesByLanguage<Short> shortValuesByLanguage, String name, Attributes attrs) {
        ((ShortValuesByLanguageReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.ShortValuesByLanguageReader))
                .shortValuesByLanguage(shortValuesByLanguage);

        xmlFileReader().startElement(name, attrs);
    }

    private void underline(Underline underline, String name, Attributes attrs) {
        ((UnderlineReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.Underline))
                .underLine(underline);

        xmlFileReader().startElement(name, attrs);
    }

    private void strikeout(Strikeout strikeout, String name, Attributes attrs) {
        ((StrikeoutReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.Strikeout))
                .strikeout(strikeout);

        xmlFileReader().startElement(name, attrs);
    }

    private void outline(Outline outline, String name, Attributes attrs) {
        ((OutlineReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.Outline))
                .outline(outline);

        xmlFileReader().startElement(name, attrs);
    }

    private void shadow(CharShadow shadow, String name, Attributes attrs) {
        ((CharShadowReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.CharShadow))
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
