package kr.dogfoot.hwpxlib.object.content.section_xml.enumtype;

import kr.dogfoot.hwpxlib.object.common.EnumGetStr;

/**
 * 스크롤 바 종류
 */
public enum ScrollBarType implements EnumGetStr {
    /**
     * 가로 스크롤바
     */
    HORIZONTAL("HORIZONTAL"),
    /**
     * 세로 스크롤바
     */
    VERTICAL("VERTICAL");

    private String str;

    ScrollBarType(String str) {
        this.str = str;
    }

    @Override
    public String str() {
        return str;
    }

    public static ScrollBarType fromString(String str) {
        if (str == null) return null;

        String STR = str.toUpperCase();
        for (ScrollBarType item : values()) {
            if (item.str.equals(STR)) {
                return item;
            }
        }
        return null;
    }
}