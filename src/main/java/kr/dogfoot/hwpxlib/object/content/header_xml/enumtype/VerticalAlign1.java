package kr.dogfoot.hwpxlib.object.content.header_xml.enumtype;

public enum VerticalAlign1 {
    /**
     * 글꼴 기준
     */
    BASELINE("BASELINE"),
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

    VerticalAlign1(String str) {
        this.str = str;
    }

    public String str() {
        return str;
    }

    public static VerticalAlign1 fromString(String str) {
        if (str != null) {
            String STR = str.toUpperCase();
            for (VerticalAlign1 item : values()) {
                if (item.str.equals(STR)) {
                    return item;
                }
            }
        }
        return null;
    }
}
