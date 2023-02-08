package kr.dogfoot.hwpxlib.object.content.header_xml.enumtype;

public enum ValueUnit1 {
    PERCENT("PERCENT"),
    HWPUNIT("HWPUNIT");

    private String str;

    ValueUnit1(String str) {
        this.str = str;
    }

    public String str() {
        return str;
    }

    public static ValueUnit1 fromString(String str) {
        if (str != null) {
            String STR = str.toUpperCase();
            for (ValueUnit1 item : values()) {
                if (item.str.equals(STR)) {
                    return item;
                }
            }
        }
        return null;
    }
}
