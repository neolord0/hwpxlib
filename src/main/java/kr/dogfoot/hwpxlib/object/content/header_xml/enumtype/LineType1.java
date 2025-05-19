package kr.dogfoot.hwpxlib.object.content.header_xml.enumtype;

import kr.dogfoot.hwpxlib.object.common.EnumGetStr;

public enum LineType1 implements EnumGetStr {
    /**
     * 선 없음
     */
    NONE("NONE"),
    /**
     * 실선
     */
    SOLID("SOLID"),
    /**
     * 점선
     */
    DOT("DOT"),
    /**
     * 두꺼운 선
     */
    THICK("THICK"),
    /**
     * 긴 점선
     */
    DASH("DASH"),
    /**
     * -.-.-.
     */
    DASH_DOT("DASH_DOT"),
    /**
     * -..-..-..
     */
    DASH_DOT_DOT("DASH_DOT_DOT");

    private String str;

    LineType1(String str) {
        this.str = str;
    }

    @Override
    public String str() {
        return str;
    }

    public static LineType1 fromString(String str) {
        if (str == null) return null;

        String STR = str.toUpperCase();
        for (LineType1 item : values()) {
            if (item.str.equals(STR)) {
                return item;
            }
        }
        return null;
    }
}
