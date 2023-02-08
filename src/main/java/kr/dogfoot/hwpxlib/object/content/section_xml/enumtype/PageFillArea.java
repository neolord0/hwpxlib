package kr.dogfoot.hwpxlib.object.content.section_xml.enumtype;

/**
 * 쪽 채움 영역
 */
public enum PageFillArea {
    /**
     * 종이
     */
    PAPER("PAPER"),
    /**
     * 쪽
     */
    PAGE("PAGE"),
    /**
     * 테두리
     */
    BORDER("BORDER");

    private String str;

    PageFillArea(String str) {
        this.str = str;
    }

    public String str() {
        return str;
    }

    public static PageFillArea fromString(String str) {
        if (str != null) {
            String STR = str.toUpperCase();
            for (PageFillArea item : values()) {
                if (item.str.equals(STR)) {
                    return item;
                }
            }
        }
        return null;
    }
}
