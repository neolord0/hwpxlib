package kr.dogfoot.hwpxlib.object.content.section_xml.enumtype;

/**
 * 가로 배열 방식
 */
public enum HorzAlign {
    /**
     * 왼쪽
     */
    LEFT("LEFT"),
    /**
     * 가운데
     */
    CENTER("CENTER"),
    /**
     * 오른쪽
     */
    RIGHT("RIGHT"),
    /**
     * 안쪽
     */
    INSIDE("INSIDE"),
    /**
     * 바깥쪽
     */
    OUTSIDE("OUTSIDE");

    private String str;

    HorzAlign(String str) {
        this.str = str;
    }

    public String str() {
        return str;
    }

    public static HorzAlign fromString(String str) {
        if (str != null) {
            String STR = str.toUpperCase();
            for (HorzAlign item : values()) {
                if (item.str.equals(STR)) {
                    return item;
                }
            }
        }
        return null;
    }
}
