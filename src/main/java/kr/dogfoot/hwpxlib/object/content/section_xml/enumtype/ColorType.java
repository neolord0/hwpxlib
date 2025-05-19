package kr.dogfoot.hwpxlib.object.content.section_xml.enumtype;

import kr.dogfoot.hwpxlib.object.common.EnumGetStr;

public enum ColorType implements EnumGetStr {
    RGB("RGB"),
    CMYK("CMYK"),
    SCHEMA("SCHEMA"),
    SYSTEM("SYSTEM");

    private String str;

    ColorType(String str) {
        this.str = str;
    }

    @Override
    public String str() {
        return str;
    }

    public static ColorType fromString(String str) {
        if (str == null) return null;

        String STR = str.toUpperCase();
        for (ColorType item : values()) {
            if (item.str.equals(STR)) {
                return item;
            }
        }
        return null;
    }
}
