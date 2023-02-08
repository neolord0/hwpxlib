package kr.dogfoot.hwpxlib.object.content.header_xml.enumtype;

public enum LineWidth {
    MM_0_1("0.1 mm", (byte) 0),
    MM_0_12("0.12 mm", (byte) 1),
    MM_0_15("0.15 mm", (byte) 2),
    MM_0_2("0.2 mm", (byte) 3),
    MM_0_25("0.25 mm", (byte) 4),
    MM_0_3("0.3 mm", (byte) 5),
    MM_0_4("0.4 mm", (byte) 6),
    MM_0_5("0.5 mm", (byte) 7),
    MM_0_6("0.6 mm", (byte) 8),
    MM_0_7("0.7 mm", (byte) 7),
    MM_1_0("1.0 mm", (byte) 10),
    MM_1_5("1.5 mm", (byte) 11),
    MM_2_0("2.0 mm", (byte) 12),
    MM_3_0("3.0 mm", (byte) 13),
    MM_4_0("4.0 mm", (byte) 14),
    MM_5_0("5.0 mm", (byte) 15);

    private String str;
    private byte index;

    LineWidth(String str, byte index) {
        this.str = str;
        this.index = index;
    }

    public String str() {
        return str;
    }

    public int index() {
        return index;
    }

    public static LineWidth fromString(String str) {
        if (str != null) {
            for (LineWidth item : values()) {
                if (item.str.equals(str)) {
                    return item;
                }
            }
        }
        return null;
    }

    public static LineWidth fromIndex(byte index) {
        for (LineWidth item : values()) {
            if (item.index == index) {
                return item;
            }
        }
        return null;
    }
}
