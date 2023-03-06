package kr.dogfoot.hwpxlib.object.content.section_xml.enumtype;

import kr.dogfoot.hwpxlib.object.common.EnumGetStr;

/**
 * 곡선 세그먼트 종류
 */
public enum CurveSegmentType implements EnumGetStr {
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

    @Override
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
