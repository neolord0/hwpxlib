package kr.dogfoot.hwpxlib.object.content.header_xml.enumtype;

public enum LineBreakForNonLatin {
    /**
     * 어절
     */
    KEEP_WORD("KEEP_WORD"),
    /**
     * 글자
     */
    BREAK_WORD("BREAK_WORD");

    private String str;

    LineBreakForNonLatin(String str) {
        this.str = str;
    }

    public String str() {
        return str;
    }

    public static LineBreakForNonLatin fromString(String str) {
        if (str != null) {
            String STR = str.toUpperCase();
            for (LineBreakForNonLatin item : values()) {
                if (item.str.equals(STR)) {
                    return item;
                }
            }
        }
        return null;
    }
}
