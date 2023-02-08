package kr.dogfoot.hwpxlib.object.content.section_xml.enumtype;


public enum AlignStyleType {
    TOP_LEFT("TOP_LEFT"),
    TOP("TOP"),
    TOP_RIGHT("TOP_RIGHT"),
    LEFT("LEFT"),
    CENTER("CENTER"),
    RIGHT("RIGHT"),
    BOTTOM_LEFT("BOTTOM_LEFT"),
    BOTTOM("BOTTOM"),
    BOTTOM_RIGHT("BOTTOM_RIGHT");

    private String str;

    AlignStyleType(String str) {
        this.str = str;
    }

    public String str() {
        return str;
    }

    public static AlignStyleType fromString(String str) {
        if (str != null) {
            String STR = str.toUpperCase();
            for (AlignStyleType item : values()) {
                if (item.str.equals(STR)) {
                    return item;
                }
            }
        }
        return null;
    }
}
