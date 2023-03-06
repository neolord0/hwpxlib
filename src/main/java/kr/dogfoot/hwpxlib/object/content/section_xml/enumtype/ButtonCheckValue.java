package kr.dogfoot.hwpxlib.object.content.section_xml.enumtype;

import kr.dogfoot.hwpxlib.object.common.EnumGetStr;

/**
 * 버튼 체크 상태 값
 */
public enum ButtonCheckValue implements EnumGetStr {
    /**
     * 체크 안함
     */
    UNCHECKED("UNCHECKED"),
    /**
     * 체크 함
     */
    CHECKED("CHECKED"),
    /**
     * 결정 안함
     */
    INDETERMINATE("INDETERMINATE");

    private String str;

    ButtonCheckValue(String str) {
        this.str = str;
    }

    @Override
    public String str() {
        return str;
    }

    public static ButtonCheckValue fromString(String str) {
        if (str != null) {
            String STR = str.toUpperCase();
            for (ButtonCheckValue item : values()) {
                if (item.str.equals(STR)) {
                    return item;
                }
            }
        }
        return null;
    }
}
