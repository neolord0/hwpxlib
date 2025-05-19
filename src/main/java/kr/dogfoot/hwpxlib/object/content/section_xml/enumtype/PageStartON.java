package kr.dogfoot.hwpxlib.object.content.section_xml.enumtype;

import kr.dogfoot.hwpxlib.object.common.EnumGetStr;

public enum PageStartON implements EnumGetStr {
    /**
     * 이어서
     */
    BOTH("BOTH"),
    /**
     * 홀수
     */
    ODD("ODD"),
    /**
     * 짝수
     */
    EVEN("EVEN");

    private String str;

    PageStartON(String str) {
        this.str = str;
    }

    @Override
    public String str() {
        return str;
    }

    public static PageStartON fromString(String str) {
        if (str == null) return null;

        String STR = str.toUpperCase();
        for (PageStartON item : values()) {
            if (item.str.equals(STR)) {
                return item;
            }
        }
        return null;
    }
}
