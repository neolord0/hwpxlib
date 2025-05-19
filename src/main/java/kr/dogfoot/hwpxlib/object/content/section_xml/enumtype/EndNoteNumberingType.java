package kr.dogfoot.hwpxlib.object.content.section_xml.enumtype;

import kr.dogfoot.hwpxlib.object.common.EnumGetStr;

/**
 * 미주 번호매김 방식
 */
public enum EndNoteNumberingType implements EnumGetStr {
    /**
     * 이어서
     */
    CONTINUOUS("CONTINUOUS"),
    /**
     * 구역마다 새번호로
     */
    ON_SECTION("ON_SECTION");

    private String str;

    EndNoteNumberingType(String str) {
        this.str = str;
    }

    @Override
    public String str() {
        return str;
    }

    public static EndNoteNumberingType fromString(String str) {
        if (str == null) return null;

        String STR = str.toUpperCase();
        for (EndNoteNumberingType item : values()) {
            if (item.str.equals(STR)) {
                return item;
            }
        }
        return null;
    }
}
