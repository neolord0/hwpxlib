package kr.dogfoot.hwpxlib.object.content.header_xml.enumtype;

import kr.dogfoot.hwpxlib.object.common.EnumGetStr;

public enum ValueUnit2 implements EnumGetStr {
    CHAR("CHAR"),
    HWPUNIT("HWPUNIT");

    private String str;

    ValueUnit2(String str) {
        this.str = str;
    }

    @Override
    public String str() {
        return str;
    }

    public static ValueUnit2 fromString(String str) {
        if (str == null) return null;

        String STR = str.toUpperCase();
        for (ValueUnit2 item : values()) {
            if (item.str.equals(STR)) {
                return item;
            }
        }
        return null;
    }
}
