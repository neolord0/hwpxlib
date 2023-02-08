package kr.dogfoot.hwpxlib.object.content.header_xml.enumtype;

public enum TabItemType {
    LEFT("LEFT", 1),
    RIGHT("RIGHT", 2),
    CENTER("CENTER", 3),
    DECIMAL("DECIMAL", 4);

    private String str;
    private int index;

    TabItemType(String str, int index) {
        this.str = str;
        this.index = index;
    }

    public String str() {
        return str;
    }

    public static TabItemType fromString(String str) {
        if (str != null) {
            String STR = str.toUpperCase();
            for (TabItemType item : values()) {
                if (item.str.equals(STR)) {
                    return item;
                }
            }
        }
        return null;
    }

    public static TabItemType fromIndex(int index) {
        for (TabItemType item : values()) {
            if (item.index == index) {
                return item;
            }
        }
        return null;
    }
}
