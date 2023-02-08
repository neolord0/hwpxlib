package kr.dogfoot.hwpxlib.object.content.header_xml.enumtype;

public enum CenterLineSort {
    NONE("NONE"),
    VERTICAL("VERTICAL"),
    HORIZONTAL("HORIZONTAL"),
    CROSS("CROSS");

    private String str;

    CenterLineSort(String str) {
        this.str = str;
    }

    public String str() {
        return str;
    }

    public static CenterLineSort fromString(String str) {
        if (str != null) {
            String STR = str.toUpperCase();
            for (CenterLineSort item : values()) {
                if (item.str.equals(STR)) {
                    return item;
                }
            }
        }
        return null;
    }
}
