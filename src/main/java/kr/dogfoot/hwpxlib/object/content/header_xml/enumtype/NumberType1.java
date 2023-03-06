package kr.dogfoot.hwpxlib.object.content.header_xml.enumtype;

import kr.dogfoot.hwpxlib.object.common.EnumGetStr;

public enum NumberType1 implements EnumGetStr {
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
    CIRCLED_IDEOGRAPH("CIRCLED_IDEOGRAPH");

    private String str;

    NumberType1(String str) {
        this.str = str;
    }

    @Override
    public String str() {
        return str;
    }

    public static NumberType1 fromString(String str) {
        if (str != null) {
            String STR = str.toUpperCase();
            for (NumberType1 item : values()) {
                if (item.str.equals(STR)) {
                    return item;
                }
            }
        }
        return null;
    }
}
