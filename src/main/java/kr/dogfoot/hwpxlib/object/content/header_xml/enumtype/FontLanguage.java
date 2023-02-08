package kr.dogfoot.hwpxlib.object.content.header_xml.enumtype;

public enum FontLanguage {
    HANGUL("HANGUL"),
    LATIN("LATIN"),
    HANJA("HANJA"),
    JAPANESE("JAPANESE"),
    OTHER("OTHER"),
    SYMBOL("SYMBOL"),
    USER("USER");

    private String str;

    FontLanguage(String str) {
        this.str = str;
    }

    public String str() {
        return this.str;
    }

    public boolean equalStr(String str) {
        return this.str.equals(str);
    }
}
