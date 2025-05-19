package kr.dogfoot.hwpxlib.object.content.section_xml.enumtype;

import kr.dogfoot.hwpxlib.object.common.EnumGetStr;

public enum EquationLineMode implements EnumGetStr {
    LINE("LINE"),
    CHAR("CHAR");

    private String str;

    EquationLineMode(String str) {
        this.str = str;
    }

    @Override
    public String str() {
        return str;
    }

    public static EquationLineMode fromString(String str) {
        if (str == null) return null;

        String STR = str.toUpperCase();
        for (EquationLineMode item : values()) {
            if (item.str.equals(STR)) {
                return item;
            }
        }
        return null;
    }


}
