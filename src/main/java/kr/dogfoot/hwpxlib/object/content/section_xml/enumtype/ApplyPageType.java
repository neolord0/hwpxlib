package kr.dogfoot.hwpxlib.object.content.section_xml.enumtype;

/**
 * 적용되는 페이지 타입
 */
public enum ApplyPageType {
    /**
     * 양 쪽
     */
    BOTH("BOTH"),
    /**
     * 짝수 쪽
     */
    EVEN("EVEN"),
    /**
     * 홀수 쪽
     */
    ODD("ODD");

    private String str;

    ApplyPageType(String str) {
        this.str = str;
    }

    public String str() {
        return str;
    }

    public static ApplyPageType fromString(String str) {
        if (str != null) {
            String STR = str.toUpperCase();
            for (ApplyPageType item : values()) {
                if (item.str.equals(STR)) {
                    return item;
                }
            }
        }
        return null;
    }

}
