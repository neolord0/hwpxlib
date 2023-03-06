package kr.dogfoot.hwpxlib.object.content.section_xml.enumtype;

import kr.dogfoot.hwpxlib.object.common.EnumGetStr;

public enum PageNumPosition implements EnumGetStr {
    NONE("NONE"),
    TOP_LEFT("TOP_LEFT"),
    TOP_CENTER("TOP_CENTER"),
    TOP_RIGHT("TOP_RIGHT"),
    BOTTOM_LEFT("BOTTOM_LEFT"),
    BOTTOM_CENTER("BOTTOM_CENTER"),
    BOTTOM_RIGHT("BOTTOM_RIGHT"),
    OUTSIDE_TOP("OUTSIDE_TOP"),
    OUTSIDE_BOTTOM("OUTSIDE_BOTTOM"),
    INSIDE_TOP("INSIDE_TOP"),
    INSIDE_BOTTOM("INSIDE_BOTTOM");

    private String str;

    PageNumPosition(String str) {
        this.str = str;
    }

    @Override
    public String str() {
        return str;
    }

    public static PageNumPosition fromString(String str) {
        if (str != null) {
            String STR = str.toUpperCase();
            for (PageNumPosition item : values()) {
                if (item.str.equals(STR)) {
                    return item;
                }
            }
        }
        return null;
    }
}
