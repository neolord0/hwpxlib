package kr.dogfoot.hwpxlib.object.content.section_xml.enumtype;

/**
 * 쪽 테두리 위치 기준
 */
public enum PageBorderPositionCriterion {
    /**
     * 본문 기준
     */
    CONTENT("CONTENT"),
    /**
     * 종이 기준
     */
    PAPER("PAPER");

    private String str;

    PageBorderPositionCriterion(String str) {
        this.str = str;
    }

    public String str() {
        return str;
    }

    public static PageBorderPositionCriterion fromString(String str) {
        if (str != null) {
            String STR = str.toUpperCase();
            for (PageBorderPositionCriterion item : values()) {
                if (item.str.equals(STR)) {
                    return item;
                }
            }
        }
        return null;
    }
}
