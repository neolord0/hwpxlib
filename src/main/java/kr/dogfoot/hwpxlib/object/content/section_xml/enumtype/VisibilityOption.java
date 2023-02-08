package kr.dogfoot.hwpxlib.object.content.section_xml.enumtype;

/**
 * 보기 옵션
 */
public enum VisibilityOption {
    /**
     * 첫 페이지에서만 감추기
     */
    HIDE_FIRST("HIDE_FIRST"),
    /**
     * 첫 페이지에만 보여주기
     */
    SHOW_FIRST("SHOW_FIRST"),
    /**
     * 모두 보여주기
     */
    SHOW_ALL("SHOW_ALL");

    private String str;

    VisibilityOption(String str) {
        this.str = str;
    }

    public String str() {
        return str;
    }

    public static VisibilityOption fromString(String str) {
        if (str != null) {
            String STR = str.toUpperCase();
            for (VisibilityOption item : values()) {
                if (item.str.equals(STR)) {
                    return item;
                }
            }
        }
        return null;
    }
}
