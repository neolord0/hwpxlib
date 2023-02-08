package kr.dogfoot.hwpxlib.object.content.section_xml.enumtype;

/**
 * 제책 방벙(Gutter 여백 종류)
 */
public enum GutterMethod {
    /**
     * 왼쪽만
     */
    LEFT_ONLY("LEFT_ONLY"),
    /**
     * 맞쪽
     */
    LEFT_RIGHT("LEFT_RIGHT"),
    /**
     * 위쪽
     */
    TOP_BOTTOM("TOP_BOTTOM");

    private String str;

    GutterMethod(String str) {
        this.str = str;
    }

    public String str() {
        return str;
    }

    public static GutterMethod fromString(String str) {
        if (str != null) {
            String STR = str.toUpperCase();
            for (GutterMethod item : values()) {
                if (item.str.equals(STR)) {
                    return item;
                }
            }
        }
        return null;
    }
}
