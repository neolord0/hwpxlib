package kr.dogfoot.hwpxlib.object.content.section_xml.enumtype;

import kr.dogfoot.hwpxlib.object.common.EnumGetStr;

public enum HeightRelTo implements EnumGetStr {
    /**
     * 종이
     */
    PAPER("PAPER"),
    /**
     * 쪽
     */
    PAGE("PAGE"),
    /**
     * 고정 값
     */
    ABSOLUTE("ABSOLUTE");

    private String str;

    HeightRelTo(String str) {
        this.str = str;
    }

    @Override
    public String str() {
        return str;
    }

    public static HeightRelTo fromString(String str) {
        if (str == null) return null;

        String STR = str.toUpperCase();
        for (HeightRelTo item : values()) {
            if (item.str.equals(STR)) {
                return item;
            }
        }
        return null;
    }

}
