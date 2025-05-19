package kr.dogfoot.hwpxlib.object.content.section_xml.enumtype;

import kr.dogfoot.hwpxlib.object.common.EnumGetStr;

/**
 * 미주 위치
 */
public enum EndNotePlace implements EnumGetStr {
    /**
     * 문서 끝
     */
    END_OF_DOCUMENT("END_OF_DOCUMENT"),
    /**
     * 구역 끝
     */
    END_OF_SECTION("END_OF_SECTION");

    private String str;

    EndNotePlace(String str) {
        this.str = str;
    }

    @Override
    public String str() {
        return str;
    }

    public static EndNotePlace fromString(String str) {
        if (str == null) return null;

        String STR = str.toUpperCase();
        for (EndNotePlace item : values()) {
            if (item.str.equals(STR)) {
                return item;
            }
        }
        return null;
    }
}
