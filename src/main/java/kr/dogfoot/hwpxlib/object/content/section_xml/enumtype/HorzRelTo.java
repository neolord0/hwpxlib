package kr.dogfoot.hwpxlib.object.content.section_xml.enumtype;

import kr.dogfoot.hwpxlib.object.common.EnumGetStr;

public enum HorzRelTo implements EnumGetStr {
    PAPER("PAPER"),
    PAGE("PAGE"),
    PARA("PARA"),
    COLUMN("COLUMN");

    private String str;

    HorzRelTo(String str) {
        this.str = str;
    }

    @Override
    public String str() {
        return str;
    }

    public static HorzRelTo fromString(String str) {
        if (str == null) return null;

        String STR = str.toUpperCase();
        for (HorzRelTo item : values()) {
            if (item.str.equals(STR)) {
                return item;
            }
        }
        return null;
    }
}
