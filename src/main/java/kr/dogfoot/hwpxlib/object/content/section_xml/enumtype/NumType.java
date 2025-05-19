package kr.dogfoot.hwpxlib.object.content.section_xml.enumtype;

import kr.dogfoot.hwpxlib.object.common.EnumGetStr;

public enum NumType implements EnumGetStr {
    PAGE("PAGE"),
    FOOTNOTE("FOOTNOTE"),
    ENDNOTE("ENDNOTE"),
    PICTURE("PICTURE"),
    TABLE("TABLE"),
    EQUATION("EQUATION"),
    TOTAL_PAGE("TOTAL_PAGE");

    private String str;

    NumType(String str) {
        this.str = str;
    }

    @Override
    public String str() {
        return str;
    }

    public static NumType fromString(String str) {
        if (str == null) return null;

        String STR = str.toUpperCase();
        for (NumType item : values()) {
            if (item.str.equals(STR)) {
                return item;
            }
        }
        return null;
    }

}
