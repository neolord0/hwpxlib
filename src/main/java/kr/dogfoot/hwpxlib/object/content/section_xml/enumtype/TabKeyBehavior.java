package kr.dogfoot.hwpxlib.object.content.section_xml.enumtype;

/**
 * 탭키를 눌렸을 때의 동작
 */
public enum TabKeyBehavior {
    /**
     * 다음 객체로 이동
     */
    NEXT_OBJECT("NEXT_OBJECT"),
    /**
     * 내용에 tab 추가
     */
    INSERT_TAB("INSERT_TAB");

    private String str;

    TabKeyBehavior(String str) {
        this.str = str;
    }

    public String str() {
        return str;
    }

    public static TabKeyBehavior fromString(String str) {
        if (str != null) {
            String STR = str.toUpperCase();
            for (TabKeyBehavior item : values()) {
                if (item.str.equals(STR)) {
                    return item;
                }
            }
        }
        return null;
    }

}
