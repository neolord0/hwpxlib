package kr.dogfoot.hwpxlib.object.content.header_xml.enumtype;

import kr.dogfoot.hwpxlib.object.common.EnumGetStr;

public enum ImageEffect implements EnumGetStr {
    /**
     * 원래 그림에서
     */
    REAL_PIC("REAL_PIC"),
    /**
     * 그래이스케일로
     */
    GRAY_SCALE("GRAY_SCALE"),
    /**
     * 흑백으로
     */
    BLACK_WHITE("BLACK_WHITE");


    private String str;

    ImageEffect(String str) {
        this.str = str;
    }

    @Override
    public String str() {
        return str;
    }

    public static ImageEffect fromString(String str) {
        if (str == null) return null;

        String STR = str.toUpperCase();
        for (ImageEffect item : values()) {
            if (item.str.equals(STR)) {
                return item;
            }
        }
        return null;
    }
}
