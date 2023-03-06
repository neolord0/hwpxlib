package kr.dogfoot.hwpxlib.object.content.section_xml.enumtype;

import kr.dogfoot.hwpxlib.object.common.EnumGetStr;

/**
 * 세로 배열 방식
 */
public enum VertAlign implements EnumGetStr {
    /**
     * 위
     */
    TOP("TOP"),
    /**
     * 가운데
     */
    CENTER("CENTER"),
    /**
     * 아래
     */
    BOTTOM("BOTTOM"),
    /**
     * 안쪽
     */
    INSIDE("INSIDE"),
    /**
     * 바깥쪽
     */
    OUTSIDE("OUTSIDE");

    private String str;

    VertAlign(String str) {
        this.str = str;
    }

    @Override
    public String str() {
        return str;
    }

    public static VertAlign fromString(String str) {
        if (str != null) {
            String STR = str.toUpperCase();
            for (VertAlign item : values()) {
                if (item.str.equals(STR)) {
                    return item;
                }
            }
        }
        return null;
    }
}
