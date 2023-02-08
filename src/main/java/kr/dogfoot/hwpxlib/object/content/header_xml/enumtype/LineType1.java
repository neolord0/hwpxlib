package kr.dogfoot.hwpxlib.object.content.header_xml.enumtype;

public enum LineType1 {
    /**
     * 선 없음
     */
    NONE("NONE"),
    /**
     * 실선
     */
    SOLID("SOLID"),
    /**
     * 점선
     */
    DOT("DOT"),
    /**
     * 긴 점선
     */
    DASH("DASH"),
    /**
     * -.-.-.
     */
    DASH_DOT("DASH_DOT"),
    /**
     * -..-..-..
     */
    DASH_DOT_DOT("DASH_DOT_DOT");

    private String str;

    LineType1(String str) {
        this.str = str;
    }

    public String str() {
        return str;
    }

    public static LineType1 fromString(String str) {
        if (str != null) {
            String STR = str.toUpperCase();
            for (LineType1 item : values()) {
                if (item.str.equals(STR)) {
                    return item;
                }
            }
        }
        return null;
    }
}
