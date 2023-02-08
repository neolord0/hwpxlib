package kr.dogfoot.hwpxlib.object.content.header_xml.enumtype;

public enum LineSpacingType {
    /**
     * 글자에 따라
     */
    PERCENT("PERCENT"),
    /**
     * 고정 값
     */
    FIXED("FIXED"),
    /**
     * 여백만 지정
     */
    BETWEEN_LINES("BETWEEN_LINES"),
    /**
     * 최소
     */
    AT_LEAST("AT_LEAST");

    private String str;

    LineSpacingType(String str) {
        this.str = str;
    }

    public String str() {
        return str;
    }

    public static LineSpacingType fromString(String str) {
        if (str != null) {
            String STR = str.toUpperCase();
            for (LineSpacingType item : values()) {
                if (item.str.equals(STR)) {
                    return item;
                }
            }
        }
        return null;
    }
}
