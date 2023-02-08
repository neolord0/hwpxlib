package kr.dogfoot.hwpxlib.object.content.section_xml.enumtype;

/**
 * 글맵시 정렬 방식
 */
public enum TextArtAlign {
    LEFT("LEFT"),
    RIGHT("RIGHT"),
    CENTER("CENTER"),
    FULL("FULL"),
    TABLE("TABLE");

    private String str;

    TextArtAlign(String str) {
        this.str = str;
    }

    public String str() {
        return str;
    }

    public static TextArtAlign fromString(String str) {
        if (str != null) {
            String STR = str.toUpperCase();
            for (TextArtAlign item : values()) {
                if (item.str.equals(STR)) {
                    return item;
                }
            }
        }
        return null;
    }
}
