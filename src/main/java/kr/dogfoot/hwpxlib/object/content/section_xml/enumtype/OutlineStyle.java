package kr.dogfoot.hwpxlib.object.content.section_xml.enumtype;

import kr.dogfoot.hwpxlib.object.common.EnumGetStr;

/**
 * 테두리선 형태
 */
public enum OutlineStyle implements EnumGetStr {
    NORMAL("NORMAL"),
    OUTER("OUTER"),
    INNER("INNER");

    private String str;

    OutlineStyle(String str) {
        this.str = str;
    }

    @Override
    public String str() {
        return str;
    }

    public static OutlineStyle fromString(String str) {
        if (str == null) return null;

        String STR = str.toUpperCase();
        for (OutlineStyle item : values()) {
            if (item.str.equals(STR)) {
                return item;
            }
        }
        return null;
    }

}
