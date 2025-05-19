package kr.dogfoot.hwpxlib.object.content.header_xml.enumtype;

import kr.dogfoot.hwpxlib.object.common.EnumGetStr;

public enum VerticalAlign1 implements EnumGetStr {
    /**
     * 글꼴 기준
     */
    BASELINE("BASELINE"),
    /**
     * 위쪽
     */
    TOP("TOP"),
    /**
     * 가운데
     */
    CENTER("CENTER"),
    /**
     * 아래
     */
    BOTTOM("BOTTOM");

    private String str;

    VerticalAlign1(String str) {
        this.str = str;
    }

    @Override
    public String str() {
        return str;
    }

    public static VerticalAlign1 fromString(String str) {
        if (str == null) return null;

        String STR = str.toUpperCase();
        for (VerticalAlign1 item : values()) {
            if (item.str.equals(STR)) {
                return item;
            }
        }
        return null;
    }
}
