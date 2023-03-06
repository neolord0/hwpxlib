package kr.dogfoot.hwpxlib.object.content.section_xml.enumtype;

import kr.dogfoot.hwpxlib.object.common.EnumGetStr;

/**
 * 숫자 포맷
 */
public enum NumberType2 implements EnumGetStr {
    /**
     * 숫자
     */
    DIGIT("DIGIT"),
    /**
     * 원 숫자
     */
    CIRCLED_DIGIT("CIRCLED_DIGIT"),
    /**
     * 대문자 로마 숫자
     */
    ROMAN_CAPITAL("ROMAN_CAPITAL"),
    /**
     * 소문자 로마 숫자
     */
    ROMAN_SMALL("ROMAN_SMALL"),
    /**
     * 알파벳 대문자
     */
    LATIN_CAPITAL("LATIN_CAPITAL"),
    /**
     * 알파벳 소문자
     */
    LATIN_SMALL("LATIN_SMALL"),
    /**
     * 원 알파벳 대문자
     */
    CIRCLED_LATIN_CAPTION("CIRCLED_LATIN_CAPTION"),
    /**
     * 원 알파벳 소문자
     */
    CIRCLED_LATIN_SMALL("CIRCLED_LATIN_SMALL"),
    /**
     * 가,나,다
     */
    HANGUL_SYLLABLE("HANGUL_SYLLABLE"),
    /**
     * 원 가,나 다
     */
    CIRCLED_HANGUL_SYLLABLE("CIRCLED_HANGUL_SYLLABLE"),
    /**
     * ㄱ,ㄴ,ㄷ
     */
    HANGUL_JAMO("HANGUL_JAMO"),
    /**
     * 원 ㄱ,ㄴ,ㄷ
     */
    CIRCLED_HANGUL_JAMO("CIRCLED_HANGUL_JAMO"),
    /**
     * 일, 이, 삼
     */
    HANGUL_PHONETIC("HANGUL_PHONETIC"),
    /**
     * 한자 숫자
     */
    IDEOGRAPH("IDEOGRAPH"),
    /**
     * 원 한자 숫자
     */
    CIRCLED_IDEOGRAPH("CIRCLED_IDEOGRAPH"),
    /**
     * 갑,을,병
     */
    DECAGON_CIRCLE("DECAGON_CIRCLE"),
    /**
     * 한자 갑,을,병
     */
    DECAGON_CIRCLE_HANJA("DECAGON_CIRCLE_HANJA"),
    /**
     * 네 가지 문자가 차레로 반복
     */
    SYMBOL("SYMBOL"),
    /**
     * 사용자 지정 문자 반복
     */
    USER_CHAR("USER_CHAR");

    private String str;

    NumberType2(String str) {
        this.str = str;
    }

    @Override
    public String str() {
        return str;
    }

    public static NumberType2 fromString(String str) {
        if (str != null) {
            String STR = str.toUpperCase();
            for (NumberType2 item : values()) {
                if (item.str.equals(STR)) {
                    return item;
                }
            }
        }
        return null;
    }
}
