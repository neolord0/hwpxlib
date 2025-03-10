package kr.dogfoot.hwpxlib.object.content.section_xml.enumtype;

import kr.dogfoot.hwpxlib.object.common.EnumGetStr;

/**
 * 화살표 모양
 */
public enum ArrowType implements EnumGetStr {
    /**
     * 화살표 없음
     */
    NORMAL("NORMAL"),
    /**
     * 삼각형
     */
    ARROW("ARROW"),
    /**
     * 선 화살표
     */
    SPEAR("SPEAR"),
    /**
     * 오목한 삼각형
     */
    CONCAVE_ARROW("CONCAVE_ARROW"),
    /**
     * 빈 다이아몬드
     */
    EMPTY_DIAMOND("EMPTY_DIAMOND"),
    /**
     * 빈 원
     */
    EMPTY_CIRCLE("EMPTY_CIRCLE"),
    /**
     * 빈 박스
     */
    EMPTY_BOX("EMPTY_BOX");

    private String str;

    ArrowType(String str) {
        this.str = str;
    }

    @Override
    public String str() {
        return str;
    }

    public static ArrowType fromString(String str) {
        if (str != null) {
            String STR = str.toUpperCase();
            for (ArrowType item : values()) {
                if (item.str.equals(STR)) {
                    return item;
                }
            }
        }
        return null;
    }
}
