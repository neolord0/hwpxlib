package kr.dogfoot.hwpxlib.object.content.section_xml.enumtype;

public enum DropCapStyle {
    /**
     * 장식 하지 않음
     */
    NONE("NONE"),
    /**
     * 두 줄이 들어갈 수 있는 크기로 첫 글자를 크게 함
     */
    DOUBLELINE("DOUBLELINE"),
    /**
     * 세 줄이 들어가는 크기로 첫 글자를 크게 함
     */
    TRIPLELINE("TRIPLELINE"),
    /**
     * 여백
     */
    MARGIN("MARGIN");

    private String str;

    DropCapStyle(String str) {
        this.str = str;
    }

    public String str() {
        return str;
    }

    public static DropCapStyle fromString(String str) {
        if (str != null) {
            String STR = str.toUpperCase();
            for (DropCapStyle item : values()) {
                if (item.str.equals(STR)) {
                    return item;
                }
            }
        }
        return null;
    }
}
