package kr.dogfoot.hwpxlib.object.content.section_xml.enumtype;

import kr.dogfoot.hwpxlib.object.common.EnumGetStr;

public enum VertRelTo implements EnumGetStr {
    PAPER("PAPER"),
    PAGE("PAGE"),
    PARA("PARA");

    private String str;

    VertRelTo(String str) {
        this.str = str;
    }

    @Override
    public String str() {
        return str;
    }

    public static VertRelTo fromString(String str) {
        if (str == null) return null;

        String STR = str.toUpperCase();
        for (VertRelTo item : values()) {
            if (item.str.equals(STR)) {
                return item;
            }
        }
        return null;
    }
}
