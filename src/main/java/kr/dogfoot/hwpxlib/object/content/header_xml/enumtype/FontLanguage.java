package kr.dogfoot.hwpxlib.object.content.header_xml.enumtype;

import kr.dogfoot.hwpxlib.object.common.EnumGetStr;

public enum FontLanguage implements EnumGetStr {
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

    @Override
    public String str() {
        return this.str;
    }

    public boolean equalStr(String str) {
        return this.str.equals(str);
    }
}
