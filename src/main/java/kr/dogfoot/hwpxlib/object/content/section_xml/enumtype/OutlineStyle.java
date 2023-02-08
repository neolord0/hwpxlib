package kr.dogfoot.hwpxlib.object.content.section_xml.enumtype;

/**
 * 테두리선 형태
 */
public enum OutlineStyle {
    NORMAL("NORMAL"),
    OUTER("OUTER"),
    INNER("INNER");

    private String str;

    OutlineStyle(String str) {
        this.str = str;
    }

    public String str() {
        return str;
    }

    public static OutlineStyle fromString(String str) {
        if (str != null) {
            for (OutlineStyle item : values()) {
                if (item.str.equals(str)) {
                    return item;
                }
            }
        }
        return null;
    }

}
