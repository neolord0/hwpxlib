package kr.dogfoot.hwpxlib.object.content.section_xml.enumtype;

import kr.dogfoot.hwpxlib.object.common.EnumGetStr;

public enum ColumnDirection implements EnumGetStr {
    /**
     * 왼쪽부터
     */
    LEFT("LEFT"),
    /**
     * 오른쪽부터
     */
    RIGHT("RIGHT"),
    /**
     * 맞쪽
     */
    MIRROR("MIRROR");

    private String str;

    ColumnDirection(String str) {
        this.str = str;
    }

    @Override
    public String str() {
        return str;
    }

    public static ColumnDirection fromString(String str) {
        if (str == null) return null;

        String STR = str.toUpperCase();
        for (ColumnDirection item : values()) {
            if (item.str.equals(STR)) {
                return item;
            }
        }
        return null;
    }
}
