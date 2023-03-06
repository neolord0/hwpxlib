package kr.dogfoot.hwpxlib.object.content.section_xml.enumtype;

import kr.dogfoot.hwpxlib.object.common.EnumGetStr;

public enum NumberingType implements EnumGetStr {
    /**
     * 없음
     */
    NONE("NONE"),
    /**
     * 그림
     */
    PICTURE("PICTURE"),
    /**
     * 표
     */
    TABLE("TABLE"),
    /**
     * 수식
     */
    EQUATION("EQUATION");

    private String str;

    NumberingType(String str) {
        this.str = str;
    }

    @Override
    public String str() {
        return str;
    }

    public static NumberingType fromString(String str) {
        if (str != null) {
            String STR = str.toUpperCase();
            for (NumberingType item : values()) {
                if (item.str.equals(STR)) {
                    return item;
                }
            }
        }
        return null;
    }
}
