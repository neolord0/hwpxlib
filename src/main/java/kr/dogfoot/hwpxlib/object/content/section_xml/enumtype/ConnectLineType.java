package kr.dogfoot.hwpxlib.object.content.section_xml.enumtype;

/**
 * 연결선 종류
 */
public enum ConnectLineType {
    STRAIGHT_NOARROW("STRAIGHT_NOARROW"),
    STRAIGHT_ONEWAY("STRAIGHT_ONEWAY"),
    STRAIGHT_BOTH("STRAIGHT_BOTH"),
    STROKE_NOARROW("STROKE_NOARROW"),
    STROKE_ONEWAY("STROKE_ONEWAY"),
    STROKE_BOTH("STROKE_BOTH"),
    ARC_NOARROW("ARC_NOARROW"),
    ARC_ONEWAY("ARC_ONEWAY"),
    ARC_BOTH("ARC_BOTH");

    private String str;

    ConnectLineType(String str) {
        this.str = str;
    }

    public String str() {
        return str;
    }

    public static ConnectLineType fromString(String str) {
        if (str != null) {
            String STR = str.toUpperCase();
            for (ConnectLineType item : values()) {
                if (item.str.equals(STR)) {
                    return item;
                }
            }
        }
        return null;
    }
}
