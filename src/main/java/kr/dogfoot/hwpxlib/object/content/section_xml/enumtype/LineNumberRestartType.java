package kr.dogfoot.hwpxlib.object.content.section_xml.enumtype;

import kr.dogfoot.hwpxlib.object.common.EnumGetStr;

public enum LineNumberRestartType implements EnumGetStr {
    Unknown("0"),
    /**
     * 쪽 마다 새번호
     */
    AtEachPage("1"),
    /**
     * 구역마다 새번호
     */
    AtEachSection("2"),
    /**
     * 이전 번호에 이어서
     */
    Continue("3");

    private String str;

    LineNumberRestartType(String str) {
        this.str = str;
    }

    @Override
    public String str() {
        return str;
    }

    public static LineNumberRestartType fromString(String str) {
        if (str == null) return null;

        for (LineNumberRestartType item : values()) {
            if (item.str.equals(str)) {
                return item;
            }
        }
        return null;
    }
}
