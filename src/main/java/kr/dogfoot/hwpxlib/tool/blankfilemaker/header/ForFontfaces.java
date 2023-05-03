package kr.dogfoot.hwpxlib.tool.blankfilemaker.header;

import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.FontFamilyType;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.FontType;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.LanguageType;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.Fontface;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.Fontfaces;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.fontface.Font;

public class ForFontfaces {
    public static void make(Fontfaces fontfaces) {
        addFonts(fontfaces.addNewFontface().langAnd(LanguageType.HANGUL));
        addFonts(fontfaces.addNewFontface().langAnd(LanguageType.LATIN));
        addFonts(fontfaces.addNewFontface().langAnd(LanguageType.HANJA));
        addFonts(fontfaces.addNewFontface().langAnd(LanguageType.JAPANESE));
        addFonts(fontfaces.addNewFontface().langAnd(LanguageType.OTHER));
        addFonts(fontfaces.addNewFontface().langAnd(LanguageType.SYMBOL));
        addFonts(fontfaces.addNewFontface().langAnd(LanguageType.USER));
    }

    private static void addFonts(Fontface fontface) {
        font1(fontface.addNewFont());
        font2(fontface.addNewFont());
    }

    private static void font1(Font font) {
        font
                .idAnd("0")
                .faceAnd("함초롬돋움")
                .typeAnd(FontType.TTF)
                .isEmbeddedAnd(false);

        font.createTypeInfo();
        font.typeInfo()
                .familyTypeAnd(FontFamilyType.FCAT_GOTHIC)
                .weightAnd(8)
                .proportionAnd(4)
                .contrastAnd(0)
                .strokeVariationAnd(1)
                .armStyleAnd(true)
                .letterformAnd(true)
                .midlineAnd(true)
                .xHeight(1);
    }

    private static void font2(Font font) {
        font
                .idAnd("1")
                .faceAnd("함초롬바탕")
                .typeAnd(FontType.TTF)
                .isEmbeddedAnd(false);

        font.createTypeInfo();
        font.typeInfo()
                .familyTypeAnd(FontFamilyType.FCAT_GOTHIC)
                .weightAnd(8)
                .proportionAnd(4)
                .contrastAnd(0)
                .strokeVariationAnd(1)
                .armStyleAnd(true)
                .letterformAnd(true)
                .midlineAnd(true)
                .xHeight(1);
    }
}
