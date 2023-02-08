package kr.dogfoot.hwpxlib.object.content.section_xml.enumtype;

/**
 * 텍스트 진행방향
 */
public enum TextDirection {
    /**
     * 가로쓰기
     */
    HORIZONTAL("HORIZONTAL"),
    /**
     * 세로쓰기-영문 눕힘
     */
    VERTICAL("VERTICAL"),
    /**
     * 세로쓰기-영문 세움
     */
    VERTICALALL("VERTICALALL");

    private String str;

    TextDirection(String str) {
        this.str = str;
    }

    public String str() {
        return str;
    }

    public static TextDirection fromString(String str) {
        if (str != null) {
            String STR = str.toUpperCase();
            for (TextDirection item : values()) {
                if (item.str.equals(STR)) {
                    return item;
                }
            }
        }
        return null;
    }
}
