package kr.dogfoot.hwpxlib.object.content.section_xml.enumtype;

import kr.dogfoot.hwpxlib.object.common.EnumGetStr;

/**
 * 쪽 경계에서 나눔
 */
public enum TablePageBreak implements EnumGetStr {
    /**
     * 나눔
     */
    TABLE("TABLE"),
    /**
     * 셀 단위로 나눔
     */
    CELL("CELL"),
    /**
     * 나누지 않음
     */
    NONE("NONE");

    private String str;

    TablePageBreak(String str) {
        this.str = str;
    }

    @Override
    public String str() {
        return str;
    }

    public static TablePageBreak fromString(String str) {
        if (str == null) return null;

        String STR = str.toUpperCase();
        for (TablePageBreak item : values()) {
            if (item.str.equals(STR)) {
                return item;
            }
        }
        return null;
    }
}
