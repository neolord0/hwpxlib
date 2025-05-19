package kr.dogfoot.hwpxlib.object.content.section_xml.enumtype;

import kr.dogfoot.hwpxlib.object.common.EnumGetStr;

/**
 * 글자 겹침 종류
 */
public enum ComposeType implements EnumGetStr {
    /**
     * 나열하기
     */
    SPREAD("SPREAD"),
    /**
     * 겹치기
     */
    OVERLAP("OVERLAP");


    private String str;

    ComposeType(String str) {
        this.str = str;
    }

    @Override
    public String str() {
        return str;
    }

    public static ComposeType fromString(String str) {
        if (str == null) return null;

        String STR = str.toUpperCase();
        for (ComposeType item : values()) {
            if (item.str.equals(STR)) {
                return item;
            }
        }
        return null;
    }
}
