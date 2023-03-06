package kr.dogfoot.hwpxlib.object.content.section_xml.enumtype;

import kr.dogfoot.hwpxlib.object.common.EnumGetStr;

/**
 * 프레젠테이션 효과
 */
public enum PresentationEffect implements EnumGetStr {
    /**
     * 없음
     */
    none("none"),
    /**
     * 왼쪽으로 펼치기
     */
    overLeft("overLeft"),
    /**
     * 오른쪽으로 펼치기
     */
    overRight("overRight"),
    /**
     * 위로 펼치기
     */
    overUp("overUp"),
    /**
     * 아래로 펼치기
     */
    overDown("overDown"),
    /**
     * 상자형으로 펼치기
     */
    rectOut("rectOut"),
    /**
     * 상자형으로 오므리기
     */
    rectIn("rectIn"),
    /**
     * 왼쪽 블라인드
     */
    blindLeft("blindLeft"),
    /**
     * 오른쪽 블라인드
     */
    blindRight("blindRight"),
    /**
     * 위쪽 블라인드
     */
    blindUp("blindUp"),
    /**
     * 아래쪽 블라인드
     */
    blindDown("blindDown"),
    /**
     * 수평 커튼 열기
     */
    cuttonHorzOut("cuttonHorzOut"),
    /**
     * 수평 커튼 닫기
     */
    cuttonHorzIn("cuttonHorzIn"),
    /**
     * 수직 커튼 열기
     */
    cuttonVertOut("cuttonVertOut"),
    /**
     * 수직 커튼 닫기
     */
    cuttonVertIn("cuttonVertIn"),
    /**
     * 왼쪽으로 가리기
     */
    moveLeft("moveLeft"),
    /**
     * 오른쪽으로 가리기
     */
    moveRight("moveRight"),
    /**
     * 위로 가리기
     */
    moveUp("moveUp"),
    /**
     * 아래로 가리기
     */
    moveDown("moveDown"),
    /**
     * 임의 선택
     */
    random("random");

    private String str;

    PresentationEffect(String str) {
        this.str = str;
    }

    @Override
    public String str() {
        return str;
    }

    public static PresentationEffect fromString(String str) {
        if (str != null) {
            for (PresentationEffect item : values()) {
                if (item.str.equals(str)) {
                    return item;
                }
            }
        }
        return null;
    }
}
