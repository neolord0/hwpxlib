package kr.dogfoot.hwpxlib.object.content.section_xml.enumtype;

/**
 * 세로 정렬
 */
public enum VerticalAlign2 {
    /**
     * 위쪽
     */
    TOP("TOP"),
    /**
     * 가운데
     */
    CENTER("CENTER"),
    /**
     * 아래
     */
    BOTTOM("BOTTOM");

    private String str;

    VerticalAlign2(String str) {
        this.str = str;
    }

    public String str() {
        return str;
    }

    public static VerticalAlign2 fromString(String str) {
        if (str != null) {
            String STR = str.toUpperCase();
            for (VerticalAlign2 item : values()) {
                if (item.str.equals(STR)) {
                    return item;
                }
            }
        }
        return null;
    }
}
