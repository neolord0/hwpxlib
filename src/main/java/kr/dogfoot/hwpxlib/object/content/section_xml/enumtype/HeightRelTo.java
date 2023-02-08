package kr.dogfoot.hwpxlib.object.content.section_xml.enumtype;

public enum HeightRelTo {
    /**
     * 종이
     */
    PAPER("PAPER"),
    /**
     * 쪽
     */
    PAGE("PAGE"),
    /**
     * 고정 값
     */
    ABSOLUTE("ABSOLUTE");

    private String str;

    HeightRelTo(String str) {
        this.str = str;
    }

    public String str() {
        return str;
    }

    public static HeightRelTo fromString(String str) {
        if (str != null) {
            String STR = str.toUpperCase();
            for (HeightRelTo item : values()) {
                if (item.str.equals(STR)) {
                    return item;
                }
            }
        }
        return null;
    }

}