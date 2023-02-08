package kr.dogfoot.hwpxlib.object.content.section_xml.enumtype;

/**
 * 줄나눔 방식
 */
public enum LineWrapMethod {
    /**
     * 나눠짐
     */
    BREAK("BREAK"),
    /**
     * 한 줄로 입력
     */
    SQUEEZE("SQUEEZE"),
    /**
     * ?
     */
    KEEP("KEEP");

    private String str;

    LineWrapMethod(String str) {
        this.str = str;
    }

    public String str() {
        return str;
    }

    public static LineWrapMethod fromString(String str) {
        if (str != null) {
            String STR = str.toUpperCase();
            for (LineWrapMethod item : values()) {
                if (item.str.equals(STR)) {
                    return item;
                }
            }
        }
        return null;
    }
}
