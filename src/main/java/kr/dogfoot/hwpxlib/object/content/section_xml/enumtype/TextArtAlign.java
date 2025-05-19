package kr.dogfoot.hwpxlib.object.content.section_xml.enumtype;

import kr.dogfoot.hwpxlib.object.common.EnumGetStr;

/**
 * 글맵시 정렬 방식
 */
public enum TextArtAlign implements EnumGetStr {
    LEFT("LEFT"),
    RIGHT("RIGHT"),
    CENTER("CENTER"),
    FULL("FULL"),
    TABLE("TABLE");

    private String str;

    TextArtAlign(String str) {
        this.str = str;
    }

    @Override
    public String str() {
        return str;
    }

    public static TextArtAlign fromString(String str) {
        if (str == null) return null;

        String STR = str.toUpperCase();
        for (TextArtAlign item : values()) {
            if (item.str.equals(STR)) {
                return item;
            }
        }
        return null;
    }
}
