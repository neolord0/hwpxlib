package kr.dogfoot.hwpxlib.object.content.header_xml.enumtype;

public enum HorizontalAlign2 {
    /**
     * 양쪽 정렬
     */
    JUSTIFY("JUSTIFY"),
    /**
     * 왼쪽 정렬
     */
    LEFT("LEFT"),
    /**
     * 오른쪽 정렬
     */
    RIGHT("RIGHT"),
    /**
     * 가운데 정렬
     */
    CENTER("CENTER"),
    /**
     * 배분 정렬
     */
    DISTRIBUTE("DISTRIBUTE"),
    /**
     * 나눔 정렬
     */
    DISTRIBUTE_SPACE("DISTRIBUTE_SPACE");

    private String str;

    HorizontalAlign2(String str) {
        this.str = str;
    }

    public String str() {
        return str;
    }

    public static HorizontalAlign2 fromString(String str) {
        if (str != null) {
            String STR = str.toUpperCase();
            for (HorizontalAlign2 item : values()) {
                if (item.str.equals(STR)) {
                    return item;
                }
            }
        }
        return null;
    }
}
