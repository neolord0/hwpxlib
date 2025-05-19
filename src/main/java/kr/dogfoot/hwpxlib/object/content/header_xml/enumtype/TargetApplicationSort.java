package kr.dogfoot.hwpxlib.object.content.header_xml.enumtype;

import kr.dogfoot.hwpxlib.object.common.EnumGetStr;

public enum TargetApplicationSort implements EnumGetStr {
    WordProcessor("WORDPROCESSOR"),
    Presentation("PRESENTATION"),
    SpreadSheet("SPREADSHEET");

    private String str;

    TargetApplicationSort(String str) {
        this.str = str;
    }

    @Override
    public String str() {
        return str;
    }

    public static TargetApplicationSort fromString(String str) {
        if (str == null) return null;

        String STR = str.toUpperCase();
        for (TargetApplicationSort item : values()) {
            if (item.str.equals(STR)) {
                return item;
            }
        }
        return null;
    }
}
