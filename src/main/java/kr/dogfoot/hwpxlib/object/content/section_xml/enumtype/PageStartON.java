package kr.dogfoot.hwpxlib.object.content.section_xml.enumtype;

public enum PageStartON {
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

    public String str() {
        return str;
    }

    public static PageStartON fromString(String str) {
        if (str != null) {
            String STR = str.toUpperCase();
            for (PageStartON item : values()) {
                if (item.str.equals(STR)) {
                    return item;
                }
            }
        }
        return null;
    }
}
