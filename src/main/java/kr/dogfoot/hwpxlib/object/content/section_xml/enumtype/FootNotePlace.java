package kr.dogfoot.hwpxlib.object.content.section_xml.enumtype;

import kr.dogfoot.hwpxlib.object.common.EnumGetStr;

/**
 * 각주 위치
 */
public enum FootNotePlace implements EnumGetStr {
    /**
     * 각 단 아래
     */
    EACH_COLUMN("EACH_COLUMN"),
    /**
     * 전단
     */
    MERGED_COLUMN("MERGED_COLUMN"),
    /**
     * 오른쪽 단 야래
     */
    RIGHT_MOST_COLUMN("RIGHT_MOST_COLUMN");

    private String str;

    FootNotePlace(String str) {
        this.str = str;
    }

    @Override
    public String str() {
        return str;
    }

    public static FootNotePlace fromString(String str) {
        if (str == null) return null;

        String STR = str.toUpperCase();
        for (FootNotePlace item : values()) {
            if (item.str.equals(STR)) {
                return item;
            }
        }
        return null;
    }
}

