package kr.dogfoot.hwpxlib.object.content.header_xml.enumtype;

import kr.dogfoot.hwpxlib.object.common.EnumGetStr;

/**
 * 스타일 종류
 */
public enum StyleType implements EnumGetStr {
    /**
     * 문단 스타일
     */
    PARA("PARA"),
    /**
     * 글자 스타일
     */
    CHAR("CHAR");

    private String str;

    StyleType(String str) {
        this.str = str;
    }

    @Override
    public String str() {
        return str;
    }

    public static StyleType fromString(String str) {
        if (str == null) return null;

        String STR = str.toUpperCase();
        for (StyleType item : values()) {
            if (item.str.equals(STR)) {
                return item;
            }
        }
        return null;
    }
}
