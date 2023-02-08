package kr.dogfoot.hwpxlib.object.content.section_xml.enumtype;

public enum ColumnDirection {
    /**
     * 왼쪽부터
     */
    LEFT("LEFT"),
    /**
     * 오른쪽부터
     */
    RIGHT("RIGHT"),
    /**
     * 맞쪽
     */
    MIRROR("MIRROR");

    private String str;

    ColumnDirection(String str) {
        this.str = str;
    }

    public String str() {
        return str;
    }

    public static ColumnDirection fromString(String str) {
        if (str != null) {
            String STR = str.toUpperCase();
            for (ColumnDirection item : values()) {
                if (item.str.equals(STR)) {
                    return item;
                }
            }
        }
        return null;
    }
}
