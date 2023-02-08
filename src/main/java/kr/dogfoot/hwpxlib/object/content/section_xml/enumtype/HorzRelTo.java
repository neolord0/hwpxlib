package kr.dogfoot.hwpxlib.object.content.section_xml.enumtype;

public enum HorzRelTo {
    PAPER("PAPER"),
    PAGE("PAGE"),
    PARA("PARA");

    private String str;

    HorzRelTo(String str) {
        this.str = str;
    }

    public String str() {
        return str;
    }

    public static HorzRelTo fromString(String str) {
        if (str != null) {
            String STR = str.toUpperCase();
            for (HorzRelTo item : values()) {
                if (item.str.equals(STR)) {
                    return item;
                }
            }
        }
        return null;
    }
}
