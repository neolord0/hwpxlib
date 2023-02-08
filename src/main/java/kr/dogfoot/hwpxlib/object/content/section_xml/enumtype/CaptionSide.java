package kr.dogfoot.hwpxlib.object.content.section_xml.enumtype;

public enum CaptionSide {
    LEFT("LEFT"),
    RIGHT("RIGHT"),
    TOP("TOP"),
    BOTTOM("BOTTOM");

    private String str;

    CaptionSide(String str) {
        this.str = str;
    }

    public String str() {
        return str;
    }

    public static CaptionSide fromString(String str) {
        if (str != null) {
            String STR = str.toUpperCase();
            for (CaptionSide item : values()) {
                if (item.str.equals(STR)) {
                    return item;
                }
            }
        }
        return null;
    }
}
