package kr.dogfoot.hwpxlib.object.content.header_xml.enumtype;

import kr.dogfoot.hwpxlib.object.common.EnumGetStr;

public enum ParaHeadingType implements EnumGetStr  {
    /**
     * 없음
     */
    NONE("NONE"),
    /**
     * 개요 문단
     */
    OUTLINE("OUTLINE"),
    /**
     * 번호 문단
     */
    NUMBER("NUMBER"),
    /**
     * 글머리표 문단
     */
    BULLET("BULLET");

    private String str;

    ParaHeadingType(String str) {
        this.str = str;
    }

    @Override
    public String str() {
        return str;
    }

    public static ParaHeadingType fromString(String str) {
        if (str != null) {
            String STR = str.toUpperCase();
            for (ParaHeadingType item : values()) {
                if (item.str.equals(STR)) {
                    return item;
                }
            }
        }
        return null;
    }

}
