package kr.dogfoot.hwpxlib.writer.header_xml.reflist.charpr;

import kr.dogfoot.hwpxlib.commonstrings.AttributeNames;
import kr.dogfoot.hwpxlib.commonstrings.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.CharPr;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.charpr.*;
import kr.dogfoot.hwpxlib.writer.common.ElementWriter;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterManager;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterSort;

public class CharPrWriter extends ElementWriter {
    public CharPrWriter(ElementWriterManager elementWriterManager) {
        super(elementWriterManager);
    }

    @Override
    public ElementWriterSort sort() {
        return ElementWriterSort.CharPr;
    }

    @Override
    public void write(HWPXObject object) {
        CharPr charPr = (CharPr) object;
        switchList(charPr.switchList());

        xsb()
                .openElement(ElementNames.hh_charPr)
                .elementWriter(this)
                .attribute(AttributeNames.id, charPr.id())
                .attribute(AttributeNames.height, charPr.height())
                .attribute(AttributeNames.textColor, charPr.textColor())
                .attribute(AttributeNames.shadeColor, charPr.shadeColor())
                .attribute(AttributeNames.useFontSpace, charPr.useFontSpace())
                .attribute(AttributeNames.useKerning, charPr.useKerning())
                .attribute(AttributeNames.symMark, charPr.symMark())
                .attribute(AttributeNames.borderFillIDRef, charPr.borderFillIDRef());

        if (charPr.fontRef() != null) {
            stringValuesByLanguage(ElementNames.hh_fontRef, charPr.fontRef());
        }

        if (charPr.ratio() != null) {
            shortValuesByLanguage(ElementNames.hh_ratio, charPr.ratio());
        }

        if (charPr.spacing() != null) {
            shortValuesByLanguage(ElementNames.hh_spacing, charPr.spacing());
        }

        if (charPr.relSz() != null) {
            shortValuesByLanguage(ElementNames.hh_relSz, charPr.relSz());
        }

        if (charPr.offset() != null) {
            shortValuesByLanguage(ElementNames.hh_offset, charPr.offset());
        }

        if (charPr.bold() != null) {
            noAttributeChild(ElementNames.hh_bold);
        }

        if (charPr.italic() != null) {
            noAttributeChild(ElementNames.hh_italic);
        }

        if (charPr.underline() != null) {
            underline(charPr.underline());
        }

        if (charPr.strikeout() != null) {
            strikeout(charPr.strikeout());
        }

        if (charPr.outline() != null) {
            outline(charPr.outline());
        }

        if (charPr.shadow() != null) {
            shadow(charPr.shadow());
        }

        if (charPr.emboss() != null) {
            noAttributeChild(ElementNames.hh_emboss);
        }

        if (charPr.engrave() != null) {
            noAttributeChild(ElementNames.hh_engrave);
        }

        if (charPr.supscript() != null) {
            noAttributeChild(ElementNames.hh_supscript);
        }

        if (charPr.subscript() != null) {
            noAttributeChild(ElementNames.hh_subscript);
        }

        xsb().closeElement();
        releaseMe();
    }

    private void stringValuesByLanguage(String elementName, ValuesByLanguage<String> valuesByLanguage) {
        xsb()
                .openElement(elementName)
                .attribute(AttributeNames.hangul, valuesByLanguage.hangul())
                .attribute(AttributeNames.latin, valuesByLanguage.latin())
                .attribute(AttributeNames.hanja, valuesByLanguage.hanja())
                .attribute(AttributeNames.japanese, valuesByLanguage.japanese())
                .attribute(AttributeNames.other, valuesByLanguage.other())
                .attribute(AttributeNames.symbol, valuesByLanguage.symbol())
                .attribute(AttributeNames.user, valuesByLanguage.user())
                .closeElement();
    }

    private void shortValuesByLanguage(String elementName, ValuesByLanguage<Short> valuesByLanguage) {
        xsb()
                .openElement(elementName)
                .attribute(AttributeNames.hangul, valuesByLanguage.hangul())
                .attribute(AttributeNames.latin, valuesByLanguage.latin())
                .attribute(AttributeNames.hanja, valuesByLanguage.hanja())
                .attribute(AttributeNames.japanese, valuesByLanguage.japanese())
                .attribute(AttributeNames.other, valuesByLanguage.other())
                .attribute(AttributeNames.symbol, valuesByLanguage.symbol())
                .attribute(AttributeNames.user, valuesByLanguage.user())
                .closeElement();
    }

    private void underline(Underline underline) {
        xsb()
                .openElement(ElementNames.hh_underline)
                .attribute(AttributeNames.type, underline.type())
                .attribute(AttributeNames.shape, underline.shape())
                .attribute(AttributeNames.color, underline.color())
                .closeElement();
    }

    private void strikeout(Strikeout strikeout) {
        xsb()
                .openElement(ElementNames.hh_strikeout)
                .attribute(AttributeNames.shape, strikeout.shape())
                .attribute(AttributeNames.color, strikeout.color())
                .closeElement();
    }

    private void outline(Outline outline) {
        xsb()
                .openElement(ElementNames.hh_outline)
                .attribute(AttributeNames.type, outline.type())
                .closeElement();
    }

    private void shadow(CharShadow shadow) {
        xsb()
                .openElement(ElementNames.hh_shadow)
                .attribute(AttributeNames.type, shadow.type())
                .attribute(AttributeNames.color, shadow.color())
                .attribute(AttributeNames.offsetX, shadow.offsetX())
                .attribute(AttributeNames.offsetY, shadow.offsetY())
                .closeElement();
    }

    @Override
    protected void childInSwitch(HWPXObject child) {
        switch (child._objectType()) {
            case hh_fontRef:
                stringValuesByLanguage(ElementNames.hh_ratio, (ValuesByLanguage<String>) child);
                break;
            case hh_ratio:
                shortValuesByLanguage(ElementNames.hh_ratio, (ValuesByLanguage<Short>) child);
                break;
            case hh_spacing:
                shortValuesByLanguage(ElementNames.hh_spacing, (ValuesByLanguage<Short>) child);
                break;
            case hh_relSz:
                shortValuesByLanguage(ElementNames.hh_relSz, (ValuesByLanguage<Short>) child);
                break;
            case hh_offset:
                shortValuesByLanguage(ElementNames.hh_offset, (ValuesByLanguage<Short>) child);
                break;
            case hh_bold:
                noAttributeChild(ElementNames.hh_bold);
                break;
            case hh_italic:
                noAttributeChild(ElementNames.hh_italic);
                break;
            case hh_underline:
                underline((Underline) child);
                break;
            case hh_strikeout:
                strikeout((Strikeout) child);
                break;
            case hh_outline:
                outline((Outline) child);
                break;
            case hh_shadow:
                shadow((CharShadow) child);
                break;
            case hh_emboss:
                noAttributeChild(ElementNames.hh_emboss);
                break;
            case hh_engrave:
                noAttributeChild(ElementNames.hh_engrave);
                break;
            case hh_supscript:
                noAttributeChild(ElementNames.hh_supscript);
                break;
            case hh_subscript:
                noAttributeChild(ElementNames.hh_subscript);
                break;
        }
    }
}
