package kr.dogfoot.hwpxlib.object.content.header_xml.enumtype;

import kr.dogfoot.hwpxlib.object.common.EnumGetStr;

public enum LineWrap implements EnumGetStr {
    /**
     * 일반적인 줄바꿈
     */
    BREAK("BREAK"),
    /**
     * 자간을 조절하여 한 줄을 유지
     */
    SQUEEZE("SQUEEZE"),
    /**
     * 내용에 따라 폭이 늘어남
     */
    KEEP("KEEP");

    private String str;

    LineWrap(String str) {
        this.str = str;
    }

    @Override
    public String str() {
        return str;
    }

    public static LineWrap fromString(String str) {
        if (str == null) return null;

        String STR = str.toUpperCase();
        for (LineWrap item : values()) {
            if (item.str.equals(STR)) {
                return item;
            }
        }
        return null;
    }
}
