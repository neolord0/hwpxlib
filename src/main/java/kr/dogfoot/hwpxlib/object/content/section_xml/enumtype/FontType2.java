package kr.dogfoot.hwpxlib.object.content.section_xml.enumtype;

/**
 * 폰트 타입
 */
public enum FontType2 {
    /**
     * 트루타입 글꼴
     */
    TTF("TTF"),
    /**
     * 한/글 전용 글꼴
     */
    HFT("HFT");

    private String str;

    FontType2(String str) {
        this.str = str;
    }

    public String str() {
        return str;
    }

    public static FontType2 fromString(String str) {
        if (str != null) {
            String STR = str.toUpperCase();
            for (FontType2 item : values()) {
                if (item.str.equals(STR)) {
                    return item;
                }
            }
        }
        return null;
    }
}
