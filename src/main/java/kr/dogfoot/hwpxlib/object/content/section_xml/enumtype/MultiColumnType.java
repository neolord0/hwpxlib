package kr.dogfoot.hwpxlib.object.content.section_xml.enumtype;

import kr.dogfoot.hwpxlib.object.common.EnumGetStr;

public enum MultiColumnType implements EnumGetStr {
    /**
     * 일반 다단
     */
    NEWSPAPER("NEWSPAPER"),
    /**
     * 배분 다단
     */
    BALANCED_NEWSPAPER("BALANCED_NEWSPAPER"),
    /**
     * 평행 다단
     */
    PARALLEL("PARALLEL");

    private String str;

    MultiColumnType(String str) {
        this.str = str;
    }

    @Override
    public String str() {
        return str;
    }

    public static MultiColumnType fromString(String str) {
        if (str == null) return null;

        String STR = str.toUpperCase();
        for (MultiColumnType item : values()) {
            if (item.str.equals(STR)) {
                return item;
            }
        }
        return null;
    }
}
