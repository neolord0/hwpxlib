package kr.dogfoot.hwpxlib.object.content.header_xml.enumtype;

import kr.dogfoot.hwpxlib.object.common.EnumGetStr;

public enum LanguageType implements EnumGetStr {
    HANGUL("HANGUL"),
    LATIN("LATIN"),
    HANJA("HANJA"),
    JAPANESE("JAPANESE"),
    OTHER("OTHER"),
    SYMBOL("SYMBOL"),
    USER("USER");

    private String str;

    LanguageType(String str) {
        this.str = str;
    }

    @Override
    public String str() {
        return str;
    }

    public static LanguageType fromString(String str) {
        if (str == null) return null;

        String STR = str.toUpperCase();
        for (LanguageType item : values()) {
            if (item.str.equals(STR)) {
                return item;
            }
        }
        return null;
    }
}
