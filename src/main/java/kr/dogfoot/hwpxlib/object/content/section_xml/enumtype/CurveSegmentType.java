package kr.dogfoot.hwpxlib.object.content.section_xml.enumtype;

/**
 * 곡선 세그먼트 종류
 */
public enum CurveSegmentType {
    /**
     * 직선
     */
    LINE("LINE"),
    /**
     * 곡선
     */
    CURVE("CURVE");

    private String str;

    CurveSegmentType(String str) {
        this.str = str;
    }

    public String str() {
        return str;
    }

    public static CurveSegmentType fromString(String str) {
        if (str != null) {
            String STR = str.toUpperCase();
            for (CurveSegmentType item : values()) {
                if (item.str.equals(STR)) {
                    return item;
                }
            }
        }
        return null;
    }
}
