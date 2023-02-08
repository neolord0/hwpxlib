package kr.dogfoot.hwpxlib.object.content.header_xml.enumtype;

public enum ValueUnit2 {
    CHAR("CHAR"),
    HWPUNIT("HWPUNIT");

    private String str;

    ValueUnit2(String str) {
        this.str = str;
    }

    public String str() {
        return str;
    }

    public static ValueUnit2 fromString(String str) {
        if (str != null) {
            String STR = str.toUpperCase();
            for (ValueUnit2 item : values()) {
                if (item.str.equals(STR)) {
                    return item;
                }
            }
        }
        return null;
    }
}
