package kr.dogfoot.hwpxlib.object.content.section_xml.enumtype;

import kr.dogfoot.hwpxlib.object.common.EnumGetStr;

/**
 * 페이지 방향
 */
public enum PageDirection implements EnumGetStr {
    /**
     * 세로
     */
    WIDELY("WIDELY"),
    /**
     * 가로
     */
    NARROWLY("NARROWLY");

    private String str;

    PageDirection(String str) {
        this.str = str;
    }

    @Override
    public String str() {
        return str;
    }

    public static PageDirection fromString(String str) {
        if (str == null) return null;

        String STR = str.toUpperCase();
        for (PageDirection item : values()) {
            if (item.str.equals(STR)) {
                return item;
            }
        }
        return null;
    }
}
