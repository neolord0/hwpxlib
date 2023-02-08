package kr.dogfoot.hwpxlib.object.content.header_xml.enumtype;

public enum LineBreakForLatin {
    /**
     * 단어
     */
    KEEP_WORD("KEEP_WORD"),
    /**
     * 하이픈
     */
    HYPHENATION("HYPHENATION"),
    /**
     * 글자
     */
    BREAK_WORD("BREAK_WORD");

    private String str;

    LineBreakForLatin(String str) {
        this.str = str;
    }

    public String str() {
        return str;
    }

    public static LineBreakForLatin fromString(String str) {
        if (str != null) {
            String STR = str.toUpperCase();
            for (LineBreakForLatin item : values()) {
                if (item.str.equals(STR)) {
                    return item;
                }
            }
        }
        return null;
    }
}
