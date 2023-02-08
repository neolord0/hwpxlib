package kr.dogfoot.hwpxlib.object.content.header_xml.enumtype;

public enum HorizontalAlign1 {
    LEFT("LEFT"),
    RIGHT("RIGHT"),
    CENTER("CENTER");

    private String str;

    HorizontalAlign1(String str) {
        this.str = str;
    }

    public String str() {
        return str;
    }

    public static HorizontalAlign1 fromString(String str) {
        if (str != null) {
            String STR = str.toUpperCase();
            for (HorizontalAlign1 item : values()) {
                if (item.str.equals(STR)) {
                    return item;
                }
            }
        }
        return null;
    }
}
