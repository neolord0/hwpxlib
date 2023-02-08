package kr.dogfoot.hwpxlib.object.content.section_xml.enumtype;

/**
 * 호의 종류
 */
public enum ArcType {
    NORMAL("NORMAL"),
    PIE("PIE"),
    CHORD("CHORD");

    private String str;

    ArcType(String str) {
        this.str = str;
    }

    public String str() {
        return str;
    }

    public static ArcType fromString(String str) {
        if (str != null) {
            String STR = str.toUpperCase();
            for (ArcType item : values()) {
                if (item.str.equals(STR)) {
                    return item;
                }
            }
        }
        return null;
    }
}
