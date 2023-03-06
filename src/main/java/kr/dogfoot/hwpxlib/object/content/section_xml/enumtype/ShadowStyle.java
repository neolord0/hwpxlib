package kr.dogfoot.hwpxlib.object.content.section_xml.enumtype;

import kr.dogfoot.hwpxlib.object.common.EnumGetStr;

public enum ShadowStyle implements EnumGetStr {
    OUTSIDE("OUTSIDE"),
    INSIDE("INSIDE");

    private String str;

    ShadowStyle(String str) {
        this.str = str;
    }

    @Override
    public String str() {
        return str;
    }

    public static ShadowStyle fromString(String str) {
        if (str != null) {
            String STR = str.toUpperCase();
            for (ShadowStyle item : values()) {
                if (item.str.equals(STR)) {
                    return item;
                }
            }
        }
        return null;
    }
}
