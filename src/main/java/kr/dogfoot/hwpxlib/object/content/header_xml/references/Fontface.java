package kr.dogfoot.hwpxlib.object.content.header_xml.references;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.LanguageType;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.fontface.Font;

import java.util.ArrayList;

public class Fontface extends SwitchableObject {
    private LanguageType lang;
    private final ArrayList<Font> fontList;

    public Fontface() {
        fontList = new ArrayList<Font>();
    }

    @Override
    public ObjectType objectType() {
        return ObjectType.Fontface;
    }

    @Override
    public HWPXObject createChildWithElementName(String name) {
        if (ObjectType.Font.equalElementName(name)) {
            return new Font();
        }
        return null;
    }

    public LanguageType lang() {
        return lang;
    }

    public void lang(LanguageType lang) {
        this.lang = lang;
    }

    public Fontface langAnd(LanguageType lang) {
        this.lang = lang;
        return this;
    }

    public int countOfFont() {
        return fontList.size();
    }

    public Font getFont(int index) {
        return fontList.get(index);
    }

    public void addFont(Font font) {
        fontList.add(font);
    }

    public Font addNewFont() {
        Font font = new Font();
        fontList.add(font);
        return font;
    }

    public void insertFont(Font font, int position) {
        fontList.add(position, font);
    }

    public void removeFont(int position) {
        fontList.remove(position);
    }

    public Iterable<Font> fonts() {
        return fontList;
    }
}
