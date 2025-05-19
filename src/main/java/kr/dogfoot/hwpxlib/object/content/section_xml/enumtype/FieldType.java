package kr.dogfoot.hwpxlib.object.content.section_xml.enumtype;

import kr.dogfoot.hwpxlib.object.common.EnumGetStr;

public enum FieldType implements EnumGetStr {
    /**
     * 누름틀
     */
    CLICK_HERE("CLICK_HERE"),
    /**
     * 하이퍼링크
     */
    HYPERLINK("HYPERLINK"),
    /**
     * 북마크
     */
    BOOKMARK("BOOKMARK"),
    /**
     * 표 계산식
     */
    FORMULA("FORMULA"),
    /**
     * 문서요약
     */
    SUMMARY("SUMMARY"),
    /**
     * 사용자 정보
     */
    USER_INFO("USER_INFO"),
    /**
     * 날짜
     */
    DATE("DATE"),
    /**
     * 문서 날짜
     */
    DOC_DATE("DOC_DATE"),
    /**
     * 파일 경로
     */
    PATH("PATH"),
    /**
     * 상호 참조
     */
    CROSSREF("CROSSREF"),
    /**
     * 메일 머지
     */
    MAILMERGE("MAILMERGE"),
    /**
     * 메모
     */
    MEMO("MEMO"),
    /**
     * 교정 부호
     */
    PROOFREADING_MARKS("PROOFREADING_MARKS"),
    /**
     * 선택 글자 보호
     */
    PRIVATE_INFO("PRIVATE_INFO"),
    /**
     * 추가적인 의미 정보
     */
    METADATA("METADATA"),
    /**
     * 인용 정보
     */
    CITATION("CITATION"),
    /**
     * 참고 문헌
     */
    BIBLIOGRAPHY("BIBLIOGRAPHY");

    private String str;

    FieldType(String str) {
        this.str = str;
    }

    @Override
    public String str() {
        return str;
    }

    public static FieldType fromString(String str) {
        if (str == null) return null;

        String STR = str.toUpperCase();
        for (FieldType item : values()) {
            if (item.str.equals(STR)) {
                return item;
            }
        }
        return null;
    }
}
