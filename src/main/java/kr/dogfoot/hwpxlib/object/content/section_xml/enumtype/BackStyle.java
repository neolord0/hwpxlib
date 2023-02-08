package kr.dogfoot.hwpxlib.object.content.section_xml.enumtype;

/**
 * 배경스타일
 */
public enum BackStyle {
    /**
     * 투명
     */
    TRANSPARENT("TRANSPARENT"),
    /**
     * 불투명
     */
    OPAQUE("OPAQUE");

    private String str;

    BackStyle(String str) {
        this.str = str;
    }

    public String str() {
        return str;
    }

    public static BackStyle fromString(String str) {
        if (str != null) {
            String STR = str.toUpperCase();
            for (BackStyle item : values()) {
                if (item.str.equals(STR)) {
                    return item;
                }
            }
        }
        return null;
    }

}
