package kr.dogfoot.hwpxlib.object.content.header_xml.enumtype;

import kr.dogfoot.hwpxlib.object.common.EnumGetStr;

public enum TargetProgramSort implements EnumGetStr {
    HWP201X("HWP201X"),
    HWP200X("HWP200X"),
    MS_WORD("MS_WORD");

    private String str;

    TargetProgramSort(String str) {
        this.str = str;
    }

    @Override
    public String str() {
        return str;
    }

    public static TargetProgramSort fromString(String str) {
        if (str != null) {
            String STR = str.toUpperCase();
            for (TargetProgramSort item : values()) {
                if (item.str.equals(STR)) {
                    return item;
                }
            }
        }
        return null;
    }
}