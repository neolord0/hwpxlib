package kr.dogfoot.hwpxlib.object.content.header_xml.enumtype;

import kr.dogfoot.hwpxlib.object.common.EnumGetStr;

/**
 * 변경추적 종류
 */
public enum TrackChangeType implements EnumGetStr {
    /**
     * 알 수 없음
     */
    Unknown("Unknown"),
    /**
     * 내용 삭제
     */
    Delete("Delete"),
    /**
     * 내용 삽입
     */
    Insert("Insert"),
    /**
     * 글자 모양 변경
     */
    CharShape("CharShape"),
    /**
     * 문단 모양 변경
     */
    ParaShape("ParaShape");

    private String str;

    TrackChangeType(String str) {
        this.str = str;
    }

    @Override
    public String str() {
        return str;
    }

    public static TrackChangeType fromString(String str) {
        if (str != null) {
            for (TrackChangeType item : values()) {
                if (item.str.equalsIgnoreCase(str)) {
                    return item;
                }
            }
        }
        return null;
    }
}
