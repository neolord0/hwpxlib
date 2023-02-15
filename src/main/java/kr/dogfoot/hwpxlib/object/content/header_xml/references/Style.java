package kr.dogfoot.hwpxlib.object.content.header_xml.references;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.StyleType;

/**
 * 스타일
 */
public class Style extends HWPXObject {
    /**
     * 아이디
     */
    private String id;
    /**
     * 스타일 종류
     */
    private StyleType type;
    /**
     * 로컬 이름(OS 언어에 따라)
     */
    private String name;
    /**
     * 영문 이름
     */
    private String engName;
    /**
     * 문단 모양 아이디 참조값, type이 PARA 이면 반드시 지정해야 함
     */
    private String paraPrIDRef;
    /**
     * 글자 모양 아이디 참조값, type이 CHAR 이면 반드시 지정해야 함
     */
    private String charPrIDRef;
    /**
     * 다음 문단에 적용될 스타일의 아이디 참조값
     */
    private String nextStyleIDRef;
    /**
     * 언어 아이디
     */
    private String langID;
    /**
     * 양식 모드에서 스타일 보호하기 여부
     */
    private Boolean lockForm;

    public Style() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hh_style;
    }

    public String id() {
        return id;
    }

    public void id(String id) {
        this.id = id;
    }

    public Style idAnd(String id) {
        this.id = id;
        return this;
    }

    public StyleType type() {
        return type;
    }

    public void type(StyleType type) {
        this.type = type;
    }

    public Style typeAnd(StyleType type) {
        this.type = type;
        return this;
    }

    public String name() {
        return name;
    }

    public void name(String name) {
        this.name = name;
    }

    public Style nameAnd(String name) {
        this.name = name;
        return this;
    }

    public String engName() {
        return engName;
    }

    public void engName(String engName) {
        this.engName = engName;
    }

    public Style engNameAnd(String engName) {
        this.engName = engName;
        return this;
    }

    public String paraPrIDRef() {
        return paraPrIDRef;
    }

    public void paraPrIDRef(String paraPrIDRef) {
        this.paraPrIDRef = paraPrIDRef;
    }

    public Style paraPrIDRefAnd(String paraPrIDRef) {
        this.paraPrIDRef = paraPrIDRef;
        return this;
    }

    public String charPrIDRef() {
        return charPrIDRef;
    }

    public void charPrIDRef(String charPrIDRef) {
        this.charPrIDRef = charPrIDRef;
    }

    public Style charPrIDRefAnd(String charPrIDRef) {
        this.charPrIDRef = charPrIDRef;
        return this;
    }

    public String nextStyleIDRef() {
        return nextStyleIDRef;
    }

    public void nextStyleIDRef(String nextStyleIDRef) {
        this.nextStyleIDRef = nextStyleIDRef;
    }

    public Style nextStyleIDRefAnd(String nextStyleIDRef) {
        this.nextStyleIDRef = nextStyleIDRef;
        return this;
    }

    public String langID() {
        return langID;
    }

    public void langID(String langID) {
        this.langID = langID;
    }

    public Style langIDAnd(String langID) {
        this.langID = langID;
        return this;
    }

    public Boolean lockForm() {
        return lockForm;
    }

    public void lockForm(Boolean lockForm) {
        this.lockForm = lockForm;
    }

    public Style lockFormAnd(Boolean lockForm) {
        this.lockForm = lockForm;
        return this;
    }
}
