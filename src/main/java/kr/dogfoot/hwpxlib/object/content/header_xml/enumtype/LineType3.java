package kr.dogfoot.hwpxlib.object.content.header_xml.enumtype;

import kr.dogfoot.hwpxlib.object.common.EnumGetStr;

public enum LineType3 implements EnumGetStr {
    /**
     * 실선
     */
    SOLID("SOLID"),
    /**
     * 점선
     */
    DOT("DOT"),
    /**
     * 긴 점선
     */
    DASH("DASH"),
    /**
     * -.-.-.
     */
    DASH_DOT("DASH_DOT"),
    /**
     * -..-..-..
     */
    DASH_DOT_DOT("DASH_DOT_DOT"),
    /**
     * DASH 보다 긴 선의 반복
     */
    LONG_DASH("LONG_DASH"),
    /**
     * DOT 보다 큰 동그라미의 반복
     */
    CIRCLE("CIRCLE"),
    /**
     * 2중선(가는 선 + 가는 선)
     */
    DOUBLE_SLIM("DOUBLE_SLIM"),
    /**
     * 2중선(가는 선 + 굵은 선)
     */
    SLIM_THICK("SLIM_THICK"),
    /**
     * 2중선(굵은 선 + 가는 선)
     */
    THICK_SLIM("THICK_SLIM"),
    /**
     * 3중선(가는 선 + 굵은 선 + 가는 선)
     */
    SLIM_THICK_SLIM("SLIM_THICK_SLIM"),
    /**
     * 물걸선
     */
    WAVE("WAVE"),
    /**
     * 이중 물결선
     */
    DOUBLEWAVE("DOUBLEWAVE");

    private String str;

    LineType3(String str) {
        this.str = str;
    }

    @Override
    public String str() {
        return str;
    }

    public static LineType3 fromString(String str) {
        if (str == null) return null;

        String STR = str.toUpperCase();
        for (LineType3 item : values()) {
            if (item.str.equals(STR)) {
                return item;
            }
        }
        return null;
    }
}
