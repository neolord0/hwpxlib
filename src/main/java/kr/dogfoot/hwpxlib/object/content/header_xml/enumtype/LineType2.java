package kr.dogfoot.hwpxlib.object.content.header_xml.enumtype;

public enum LineType2 {
    /**
     * 선 없음
     */
    NONE("NONE", 0),
    /**
     * 실선
     */
    SOLID("SOLID", 1),
    /**
     * 점선
     */
    DOT("DOT", 2),
    /**
     * 긴 점선
     */
    DASH("DASH", 3),
    /**
     * -.-.-.
     */
    DASH_DOT("DASH_DOT", 4),
    /**
     * -..-..-..
     */
    DASH_DOT_DOT("DASH_DOT_DOT", 5),
    /**
     * DASH 보다 긴 선의 반복
     */
    LONG_DASH("LONG_DASH", 6),
    /**
     * DOT 보다 큰 동그라미의 반복
     */
    CIRCLE("CIRCLE", 7),
    /**
     * 2중선(가는 선 + 가는 선)
     */
    DOUBLE_SLIM("DOUBLE_SLIM", 8),
    /**
     * 2중선(가는 선 + 굵은 선)
     */
    SLIM_THICK("SLIM_THICK", 9),
    /**
     * 2중선(굵은 선 + 가는 선)
     */
    THICK_SLIM("THICK_SLIM", 10),
    /**
     * 3중선(가는 선 + 굵은 선 + 가는 선)
     */
    SLIM_THICK_SLIM("SLIM_THICK_SLIM", 11);

    private String str;
    private int index;

    LineType2(String str, int index) {
        this.str = str;
        this.index = index;
    }

    public String str() {
        return str;
    }

    public static LineType2 fromString(String str) {
        if (str != null) {
            String STR = str.toUpperCase();
            for (LineType2 item : values()) {
                if (item.str.equals(STR)) {
                    return item;
                }
            }
        }
        return null;
    }

    public static LineType2 fromIndex(int index) {
        for (LineType2 item : values()) {
            if (item.index == index) {
                return item;
            }
        }
        return null;
    }

}
