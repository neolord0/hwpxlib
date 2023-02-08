package kr.dogfoot.hwpxlib.object.content.section_xml.enumtype;

public enum EquationLineMode {
    LINE("LINE"),
    CHAR("CHAR");

    private String str;

    EquationLineMode(String str) {
        this.str = str;
    }

    public String str() {
        return str;
    }

    public static EquationLineMode fromString(String str) {
        if (str != null) {
            String STR = str.toUpperCase();
            for (EquationLineMode item : values()) {
                if (item.str.equals(STR)) {
                    return item;
                }
            }
        }
        return null;
    }


}
