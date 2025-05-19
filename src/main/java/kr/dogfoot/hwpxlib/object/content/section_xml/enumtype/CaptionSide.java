package kr.dogfoot.hwpxlib.object.content.section_xml.enumtype;

import kr.dogfoot.hwpxlib.object.common.EnumGetStr;

public enum CaptionSide implements EnumGetStr {
    LEFT("LEFT"),
    RIGHT("RIGHT"),
    TOP("TOP"),
    BOTTOM("BOTTOM");

    private String str;

    CaptionSide(String str) {
        this.str = str;
    }

    @Override
    public String str() {
        return str;
    }

    public static CaptionSide fromString(String str) {
        if (str == null) return null;

        String STR = str.toUpperCase();
        for (CaptionSide item : values()) {
            if (item.str.equals(STR)) {
                return item;
            }
        }
        return null;
    }
}
