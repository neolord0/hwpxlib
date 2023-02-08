package kr.dogfoot.hwpxlib.object.content.header_xml.enumtype;

public enum FontFamilyType {
    FCAT_UNKNOWN("FCAT_UNKNOWN"),
    FCAT_MYUNGJO("FCAT_MYUNGJO"),
    FCAT_GOTHIC("FCAT_GOTHIC"),
    FCAT_SSERIF("FCAT_SSERIF"),
    FCAT_BRUSHSCRIPT("FCAT_BRUSHSCRIPT"),
    FCAT_DECORATIVE("FCAT_DECORATIVE"),
    FCAT_NONRECTMJ("FCAT_NONRECTMJ"),
    FCAT_NONRECTGT("FCAT_NONRECTGT");

    private String str;

    FontFamilyType(String str) {
        this.str = str;
    }

    public String str() {
        return str;
    }

    public static FontFamilyType fromString(String str) {
        if (str != null) {
            String STR = str.toUpperCase();
            for (FontFamilyType item : values()) {
                if (item.str.equals(STR)) {
                    return item;
                }
            }
        }
        return null;
    }
}
