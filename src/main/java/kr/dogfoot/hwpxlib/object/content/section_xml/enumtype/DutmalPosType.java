package kr.dogfoot.hwpxlib.object.content.section_xml.enumtype;

import kr.dogfoot.hwpxlib.object.common.EnumGetStr;

/**
 * 덧말 위치
 */
public enum DutmalPosType implements EnumGetStr {
    TOP("TOP"),
    BOTTOM("BOTTOM");

    private String str;

    DutmalPosType(String str) {
        this.str = str;
    }

    @Override
    public String str() {
        return str;
    }

    public static DutmalPosType fromString(String str) {
        if (str != null) {
            String STR = str.toUpperCase();
            for (DutmalPosType item : values()) {
                if (item.str.equals(STR)) {
                    return item;
                }
            }
        }
        return null;
    }
}
