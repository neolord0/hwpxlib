package kr.dogfoot.hwpxlib.object.content.header_xml.enumtype;

public enum SymMarkSort {
    NONE("NONE"),
    DOT_ABOVE("DOT_ABOVE"),
    RING_ABOVE("RING_ABOVE"),
    TILDE("TILDE"),
    CARON("CARON"),
    SIDE("SIDE"),
    COLON("COLON"),
    GRAVE_ACCENT("GRAVE_ACCENT"),
    ACUTE_ACCENT("ACUTE_ACCENT"),
    CIRCUMFLEX("CIRCUMFLEX"),
    MACRON("MACRON"),
    HOOK_ABOVE("HOOK_ABOVE"),
    DOT_BELOW("DOT_BELOW");

    private String str;

    SymMarkSort(String str) {
        this.str = str;
    }

    public String str() {
        return str;
    }

    public static SymMarkSort fromString(String str) {
        if (str != null) {
            String STR = str.toUpperCase();
            for (SymMarkSort item : values()) {
                if (item.str.equals(STR)) {
                    return item;
                }
            }
        }
        return null;
    }
}
