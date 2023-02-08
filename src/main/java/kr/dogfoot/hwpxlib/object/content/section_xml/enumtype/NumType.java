package kr.dogfoot.hwpxlib.object.content.section_xml.enumtype;

public enum NumType {
    PAGE("PAGE"),
    FOOTNOTE("FOOTNOTE"),
    ENDNOTE("ENDNOTE"),
    PICTURE("PICTURE"),
    TABLE("TABLE"),
    EQUATION("EQUATION"),
    TOTAL_PAGE("TOTAL_PAGE");

    private String str;

    NumType(String str) {
        this.str = str;
    }

    public String str() {
        return str;
    }

    public static NumType fromString(String str) {
        if (str != null) {
            String STR = str.toUpperCase();
            for (NumType item : values()) {
                if (item.str.equals(STR)) {
                    return item;
                }
            }
        }
        return null;
    }

}
