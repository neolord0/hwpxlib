package kr.dogfoot.hwpxlib.object.content.header_xml.enumtype;

public enum CharShadowType {
    NONE("NONE"),
    DROP("DROP"),
    CONTINUOUS("CONTINUOUS");

    private String str;

    CharShadowType(String str) {
        this.str = str;
    }

    public String str() {
        return str;
    }

    public static CharShadowType fromString(String str) {
        if (str != null) {
            String STR = str.toUpperCase();
            for (CharShadowType item : values()) {
                if (item.str.equals(STR)) {
                    return item;
                }
            }
        }
        return null;
    }
}

