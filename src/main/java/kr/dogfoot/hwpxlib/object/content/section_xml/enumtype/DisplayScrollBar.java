package kr.dogfoot.hwpxlib.object.content.section_xml.enumtype;

import kr.dogfoot.hwpxlib.object.common.EnumGetStr;

/**
 * 스크롤바 표시 방법
 */
public enum DisplayScrollBar implements EnumGetStr {
    NONE("NONE"),
    VERTICAL("VERTICAL"),
    HORIZONTAL("HORIZONTAL"),
    BOTH("BOTH");

    private String str;

    DisplayScrollBar(String str) {
        this.str = str;
    }

    @Override
    public String str() {
        return str;
    }

    public static DisplayScrollBar fromString(String str) {
        if (str != null) {
            String STR = str.toUpperCase();
            for (DisplayScrollBar item : values()) {
                if (item.str.equals(STR)) {
                    return item;
                }
            }
        }
        return null;
    }
}
