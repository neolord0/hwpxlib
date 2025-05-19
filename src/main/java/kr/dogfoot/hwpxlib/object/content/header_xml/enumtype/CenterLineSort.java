package kr.dogfoot.hwpxlib.object.content.header_xml.enumtype;

import kr.dogfoot.hwpxlib.object.common.EnumGetStr;

public enum CenterLineSort implements EnumGetStr {
    NONE("NONE"),
    VERTICAL("VERTICAL"),
    HORIZONTAL("HORIZONTAL"),
    CROSS("CROSS");

    private String str;

    CenterLineSort(String str) {
        this.str = str;
    }

    @Override
    public String str() {
        return str;
    }

    public static CenterLineSort fromString(String str) {
        if (str == null) return null;

        String STR = str.toUpperCase();
        for (CenterLineSort item : values()) {
            if (item.str.equals(STR)) {
                return item;
            }
        }
        return null;
    }
}
