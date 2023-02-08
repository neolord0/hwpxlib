package kr.dogfoot.hwpxlib.object.content.section_xml.enumtype;

/**
 * 미주 위치
 */
public enum EndNotePlace {
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

    public String str() {
        return str;
    }

    public static EndNotePlace fromString(String str) {
        if (str != null) {
            String STR = str.toUpperCase();
            for (EndNotePlace item : values()) {
                if (item.str.equals(STR)) {
                    return item;
                }
            }
        }
        return null;
    }
}
