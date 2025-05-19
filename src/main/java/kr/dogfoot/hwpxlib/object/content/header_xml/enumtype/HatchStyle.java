package kr.dogfoot.hwpxlib.object.content.header_xml.enumtype;

import kr.dogfoot.hwpxlib.object.common.EnumGetStr;

public enum HatchStyle implements EnumGetStr {
    /**
     * ----
     */
    HORIZONTAL("HORIZONTAL"),
    /**
     * ||||
     */
    VERTICAL("VERTICAL"),
    /**
     * \\\\
     */
    BACK_SLASH("BACK_SLASH"),
    /**
     * ////
     */
    SLASH("SLASH"),
    /**
     * ++++
     */
    CROSS("CROSS"),
    /**
     * xxxxx
     */
    CROSS_DIAGONAL("CROSS_DIAGONAL");

    private String str;

    HatchStyle(String str) {
        this.str = str;
    }

    @Override
    public String str() {
        return str;
    }

    public static HatchStyle fromString(String str) {
        if (str == null) return null;

        String STR = str.toUpperCase();
        for (HatchStyle item : values()) {
            if (item.str.equals(STR)) {
                return item;
            }
        }
        return null;
    }
}
