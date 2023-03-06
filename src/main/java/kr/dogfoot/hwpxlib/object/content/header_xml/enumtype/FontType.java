package kr.dogfoot.hwpxlib.object.content.header_xml.enumtype;

import kr.dogfoot.hwpxlib.object.common.EnumGetStr;

public enum FontType implements EnumGetStr {
    /**
     * 대표 글꼴
     */
    REP("REP"),
    /**
     * 트루타입 글꼴
     */
    TTF("TTF"),
    /**
     * 한/글 전용 글꼴
     */
    HFT("HFT");

    private String str;

    FontType(String str) {
        this.str = str;
    }

    @Override
    public String str() {
        return str;
    }

    public static FontType fromString(String str) {
        if (str != null) {
            String STR = str.toUpperCase();
            for (FontType item : values()) {
                if (item.str.equals(STR)) {
                    return item;
                }
            }
        }
        return null;
    }
}
