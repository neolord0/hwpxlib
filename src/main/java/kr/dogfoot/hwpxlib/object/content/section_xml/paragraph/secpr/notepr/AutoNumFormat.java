package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.secpr.notepr;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.NumberType2;

public class AutoNumFormat extends HWPXObject {
    /**
     * 번호 모양
     */
    private NumberType2 type;
    /**
     * 사용자 글자, type=USER_CHAR 일떄만 적용
     */
    private String userChar;
    /**
     * 앞 장식 글자
     */
    private String prefixChar;
    /**
     * 뒷 장식 글자
     */
    private String suffixChar;
    /**
     * 번호 코드의 모양을 윗 첨자형식으로 할지 여부
     */
    private Boolean supscript;

    @Override
    public ObjectType objectType() {
        return ObjectType.AutoNumFormat;
    }

    public NumberType2 type() {
        return type;
    }

    public void type(NumberType2 type) {
        this.type = type;
    }

    public AutoNumFormat typeAnd(NumberType2 type) {
        this.type = type;
        return this;
    }

    public String userChar() {
        return userChar;
    }

    public void userChar(String userChar) {
        this.userChar = userChar;
    }

    public AutoNumFormat userCharAnd(String userChar) {
        this.userChar = userChar;
        return this;
    }

    public String prefixChar() {
        return prefixChar;
    }

    public void prefixChar(String prefixChar) {
        this.prefixChar = prefixChar;
    }

    public AutoNumFormat prefixCharAnd(String prefixChar) {
        this.prefixChar = prefixChar;
        return this;
    }

    public String suffixChar() {
        return suffixChar;
    }

    public void suffixChar(String suffixChar) {
        this.suffixChar = suffixChar;
    }

    public AutoNumFormat suffixCharAnd(String suffixChar) {
        this.suffixChar = suffixChar;
        return this;
    }

    public Boolean supscript() {
        return supscript;
    }

    public void supscript(Boolean supscript) {
        this.supscript = supscript;
    }

    public AutoNumFormat supscriptAnd(Boolean supscript) {
        this.supscript = supscript;
        return this;
    }
}
