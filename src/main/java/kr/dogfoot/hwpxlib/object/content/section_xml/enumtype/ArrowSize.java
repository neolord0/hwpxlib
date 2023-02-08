package kr.dogfoot.hwpxlib.object.content.section_xml.enumtype;

/**
 * 화살표 크기
 */
public enum ArrowSize {
    SMALL_SMALL("SMALL_SMALL"),
    SMALL_MEDIUM("SMALL_MEDIUM"),
    SMALL_LARGE("SMALL_LARGE"),
    MEDIUM_SMALL("MEDIUM_SMALL"),
    MEDIUM_MEDIUM("MEDIUM_MEDIUM"),
    MEDIUM_LARGE("MEDIUM_LARGE"),
    LARGE_SMALL("LARGE_SMALL"),
    LARGE_MEDIUM("LARGE_MEDIUM"),
    LARGE_LARGE("LARGE_LARGE");

    private String str;

    ArrowSize(String str) {
        this.str = str;
    }

    public String str() {
        return str;
    }

    public static ArrowSize fromString(String str) {
        if (str != null) {
            String STR = str.toUpperCase();
            for (ArrowSize item : values()) {
                if (item.str.equals(STR)) {
                    return item;
                }
            }
        }
        return null;
    }
}
