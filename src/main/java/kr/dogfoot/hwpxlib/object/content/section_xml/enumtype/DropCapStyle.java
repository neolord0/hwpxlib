package kr.dogfoot.hwpxlib.object.content.section_xml.enumtype;

import kr.dogfoot.hwpxlib.object.common.EnumGetStr;

public enum DropCapStyle implements EnumGetStr {
    /**
     * 장식 하지 않음
     */
    None("None"),
    /**
     * 두 줄이 들어갈 수 있는 크기로 첫 글자를 크게 함
     */
    DoubleLine("DoubleLine"),
    /**
     * 세 줄이 들어가는 크기로 첫 글자를 크게 함
     */
    TripleLine("TripleLine"),
    /**
     * 여백
     */
    Margin("Margin");

    private String str;

    DropCapStyle(String str) {
        this.str = str;
    }

    @Override
    public String str() {
        return str;
    }

    public static DropCapStyle fromString(String str) {
        if (str != null) {
            for (DropCapStyle item : values()) {
                if (item.str.equals(str)) {
                    return item;
                }
            }
        }
        return null;
    }
}
