package kr.dogfoot.hwpxlib.object.content.section_xml.enumtype;

import kr.dogfoot.hwpxlib.object.common.EnumGetStr;

/**
 * 라인 끝 처리
 */
public enum LineCap implements EnumGetStr {
    /**
     * 둥글게
     */
    ROUND("ROUND"),
    /**
     * 평평하게
     */
    FLAT("FLAT");

    private String str;

    LineCap(String str) {
        this.str = str;
    }

    @Override
    public String str() {
        return str;
    }

    public static LineCap fromString(String str) {
        if (str == null) return null;

        for (LineCap item : values()) {
            if (item.str.equals(str)) {
                return item;
            }
        }
        return null;
    }
}
