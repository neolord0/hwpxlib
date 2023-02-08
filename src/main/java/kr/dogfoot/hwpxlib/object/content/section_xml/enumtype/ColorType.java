package kr.dogfoot.hwpxlib.object.content.section_xml.enumtype;

public enum ColorType {
    RGB("RGB"),
    CMYK("CMYK"),
    SCHEMA("SCHEMA"),
    SYSTEM("SYSTEM");

    private String str;

    ColorType(String str) {
        this.str = str;
    }

    public String str() {
        return str;
    }

    public static ColorType fromString(String str) {
        if (str != null) {
            String STR = str.toUpperCase();
            for (ColorType item : values()) {
                if (item.str.equals(STR)) {
                    return item;
                }
            }
        }
        return null;
    }
}
