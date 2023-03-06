package kr.dogfoot.hwpxlib.object.content.header_xml.enumtype;

import kr.dogfoot.hwpxlib.object.common.EnumGetStr;

/**
 * 메모 변경 추적을 위한 속성
 */
public enum MemoType implements EnumGetStr {
    NORMAL("NORMAL"),
    USER_INSERT("USER_INSERT"),
    USER_DELETE("USER_DELETE"),
    USER_UPDATE("USER_UPDATE");

    private String str;

    MemoType(String str) {
        this.str = str;
    }

    @Override
    public String str() {
        return str;
    }

    public static MemoType fromString(String str) {
        if (str != null) {
            String STR = str.toUpperCase();
            for (MemoType item : values()) {
                if (item.str.equals(STR)) {
                    return item;
                }
            }
        }
        return null;
    }

}
