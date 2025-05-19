package kr.dogfoot.hwpxlib.object.content.header_xml.enumtype;

import kr.dogfoot.hwpxlib.object.common.EnumGetStr;

public enum SlashType implements EnumGetStr {
    /**
     * 없음
     */
    NONE("NONE"),
    /**
     * 중심선 하나
     */
    CENTER("CENTER"),
    /**
     * 중심선 + 중심선 아래에 사선
     */
    CENTER_BELOW("CENTER_BELOW"),
    /**
     * 중심선 + 중심선 위에 사선
     */
    CENTER_ABOVE("CENTER_ABOVE"),
    /**
     * 중심선 + 중심선 아래에 사선 + 중심선 위에 사선
     */
    ALL("ALL");

    private String str;

    SlashType(String str) {
        this.str = str;
    }

    @Override
    public String str() {
        return str;
    }

    public static SlashType fromString(String str) {
        if (str == null) return null;

        String STR = str.toUpperCase();
        for (SlashType item : values()) {
            if (item.str.equals(STR)) {
                return item;
            }
        }
        return null;
    }
}
