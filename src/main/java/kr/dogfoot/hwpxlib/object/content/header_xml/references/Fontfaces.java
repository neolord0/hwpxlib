package kr.dogfoot.hwpxlib.object.content.header_xml.references;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.LanguageType;

import java.util.ArrayList;

/**
 * 폰트 리스트
 */
public class Fontfaces extends SwitchableObject {
    /**
     * 한글을 위한 폰트 리스트
     */
    private ArrayList<Fontface> fontfaceList;

    public Fontfaces() {
        fontfaceList = new ArrayList<Fontface>();
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hh_fontfaces;
    }

    public int countOfFontface() {
        return fontfaceList.size();
    }

    public Fontface getFontface(int index) {
        return fontfaceList.get(index);
    }

    public void addFontface(Fontface fontface) {
        fontfaceList.add(fontface);
    }

    public Fontface addNewFontface() {
        Fontface fontface = new Fontface();
        fontfaceList.add(fontface);
        return fontface;
    }

    public void insertFontface(Fontface fontface, int position) {
        fontfaceList.add(position, fontface);
    }

    public void removeFontface(int position) {
        fontfaceList.remove(position);
    }

    public Iterable<Fontface> fontfaces() {
        return fontfaceList;
    }

    public Fontface hangulFontface() {
        return getFontface(LanguageType.HANGUL);
    }

    private Fontface getFontface(LanguageType lang) {
        for (Fontface fontface : fontfaceList) {
            if (fontface.lang() == lang) {
                return fontface;
            }
        }
        return null;
    }

    public Fontface latinFontface() {
        return getFontface(LanguageType.LATIN);
    }

    public Fontface hanjaFontface() {
        return getFontface(LanguageType.HANJA);
    }

    public Fontface japaneseFontface() {
        return getFontface(LanguageType.JAPANESE);
    }

    public Fontface otherFontface() {
        return getFontface(LanguageType.OTHER);
    }

    public Fontface symbolFontface() {
        return getFontface(LanguageType.SYMBOL);
    }

    public Fontface userFontface() {
        return getFontface(LanguageType.USER);
    }

    @Override
    public Fontfaces clone() {
        Fontfaces cloned = new Fontfaces();
        cloned.copyFrom(this);
        return cloned;
    }

    public void copyFrom(Fontfaces from) {
        for (Fontface fontface : from.fontfaceList) {
            fontfaceList.add(fontface.clone());
        }

        super.copyFrom(from);
    }
}
