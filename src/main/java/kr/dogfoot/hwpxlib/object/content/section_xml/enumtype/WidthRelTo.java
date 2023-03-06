package kr.dogfoot.hwpxlib.object.content.section_xml.enumtype;

import kr.dogfoot.hwpxlib.object.common.EnumGetStr;

/**
 * 너비 기준
 */
public enum WidthRelTo implements EnumGetStr {
    /**
     * 종이
     */
    PAPER("PAPER"),
    /**
     * 쪽
     */
    PAGE("PAGE"),
    /**
     * 단
     */
    COLUMN("COLUMN"),
    /**
     * 문단
     */
    PARA("PARA"),
    /**
     * 고정 값
     */
    ABSOLUTE("ABSOLUTE");

    private String str;

    WidthRelTo(String str) {
        this.str = str;
    }

    @Override
    public String str() {
        return str;
    }

    public static WidthRelTo fromString(String str) {
        if (str != null) {
            String STR = str.toUpperCase();
            for (WidthRelTo item : values()) {
                if (item.str.equals(STR)) {
                    return item;
                }
            }
        }
        return null;
    }
}
