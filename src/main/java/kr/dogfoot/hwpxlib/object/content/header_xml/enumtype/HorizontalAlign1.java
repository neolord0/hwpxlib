package kr.dogfoot.hwpxlib.object.content.header_xml.enumtype;

import kr.dogfoot.hwpxlib.object.common.EnumGetStr;

public enum HorizontalAlign1 implements EnumGetStr {
    LEFT("LEFT"),
    RIGHT("RIGHT"),
    CENTER("CENTER");

    private String str;

    HorizontalAlign1(String str) {
        this.str = str;
    }

    @Override
    public String str() {
        return str;
    }

    public static HorizontalAlign1 fromString(String str) {
        if (str == null) return null;

        String STR = str.toUpperCase();
        for (HorizontalAlign1 item : values()) {
            if (item.str.equals(STR)) {
                return item;
            }
        }
        return null;
    }
}
