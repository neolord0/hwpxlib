package kr.dogfoot.hwpxlib.object.content.section_xml.enumtype;

public enum VertRelTo {
    PAPER("PAPER"),
    PAGE("PAGE"),
    PARA("PARA");

    private String str;

    VertRelTo(String str) {
        this.str = str;
    }

    public String str() {
        return str;
    }

    public static VertRelTo fromString(String str) {
        if (str != null) {
            String STR = str.toUpperCase();
            for (VertRelTo item : values()) {
                if (item.str.equals(STR)) {
                    return item;
                }
            }
        }
        return null;
    }
}
