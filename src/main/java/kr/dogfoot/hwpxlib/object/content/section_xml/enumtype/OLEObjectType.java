package kr.dogfoot.hwpxlib.object.content.section_xml.enumtype;

import kr.dogfoot.hwpxlib.object.common.EnumGetStr;

/**
 * OLE 객체 타입
 */
public enum OLEObjectType implements EnumGetStr {
    UNKNOWN("UNKNOWN"),
    EMBEDDED("EMBEDDED"),
    LINK("LINK"),
    STATIC("STATIC"),
    EQUATION("EQUATION");

    private String str;

    OLEObjectType(String str) {
        this.str = str;
    }

    @Override
    public String str() {
        return str;
    }

    public static OLEObjectType fromString(String str) {
        if (str == null) return null;

        String STR = str.toUpperCase();
        for (OLEObjectType item : values()) {
            if (item.str.equals(STR)) {
                return item;
            }
        }
        return null;
    }
}

