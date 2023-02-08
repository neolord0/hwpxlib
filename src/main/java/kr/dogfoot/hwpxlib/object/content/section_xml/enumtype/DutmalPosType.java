package kr.dogfoot.hwpxlib.object.content.section_xml.enumtype;

/**
 * 덧말 위치
 */
public enum DutmalPosType {
    TOP("TOP"),
    BOTTOM("BOTTOM");

    private String str;

    DutmalPosType(String str) {
        this.str = str;
    }

    public String str() {
        return str;
    }

    public static DutmalPosType fromString(String str) {
        if (str != null) {
            String STR = str.toUpperCase();
            for (DutmalPosType item : values()) {
                if (item.str.equals(STR)) {
                    return item;
                }
            }
        }
        return null;
    }
}
