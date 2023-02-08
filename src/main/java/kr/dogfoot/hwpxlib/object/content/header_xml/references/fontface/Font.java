package kr.dogfoot.hwpxlib.object.content.header_xml.references.fontface;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.FontType;


/**
 * Font
 */
public class Font extends SwitchableObject {
    /**
     * 아이디
     */
    private String id;
    /**
     * 폰트 이름
     */
    private String face;
    /**
     * 폰트 타입
     */
    private FontType type;
    /**
     * 폰트가 파일 내부에 포함되었는지 여부
     */
    private Boolean isEmbedded;
    /**
     * 폰트가 파일에 포함되었을 떄 포함된 폰트 바이너리의 아이디 참조값
     */
    private String binaryItemIDRef;
    /**
     * 대체 폰트 정보
     */
    private SubstFont substFont;
    /**
     * 폰트 상세 정보
     */
    private TypeInfo typeInfo;

    public Font() {
    }

    @Override
    public ObjectType objectType() {
        return ObjectType.Font;
    }

    @Override
    public HWPXObject createChildWithElementName(String name) {
        if (ObjectType.SubstFont.equalElementName(name)) {
            return new SubstFont();
        } else if (ObjectType.TypeInfo.equalElementName(name)) {
            return new TypeInfo();
        }
        return null;
    }

    public String id() {
        return id;
    }

    public void id(String id) {
        this.id = id;
    }

    public Font idAnd(String id) {
        this.id = id;
        return this;
    }

    public String face() {
        return face;
    }

    public void face(String face) {
        this.face = face;
    }

    public Font faceAnd(String face) {
        this.face = face;
        return this;
    }

    public FontType type() {
        return type;
    }

    public void type(FontType type) {
        this.type = type;
    }

    public Font typeAnd(FontType type) {
        this.type = type;
        return this;
    }

    public Boolean isEmbedded() {
        return isEmbedded;
    }

    public void isEmbedded(Boolean isEmbedded) {
        this.isEmbedded = isEmbedded;
    }

    public Font isEmbeddedAnd(Boolean ieEmbedded) {
        this.isEmbedded = ieEmbedded;
        return this;
    }

    public String binaryItemIDRef() {
        return binaryItemIDRef;
    }

    public void binaryItemIDRef(String binaryItemIDRef) {
        this.binaryItemIDRef = binaryItemIDRef;
    }

    public Font binaryItemIDRefAnd(String binaryItemIDRef) {
        this.binaryItemIDRef = binaryItemIDRef;
        return this;
    }

    public SubstFont substFont() {
        return substFont;
    }

    public void createSubstFont() {
        substFont = new SubstFont();
    }

    public void removeSubstFont() {
        substFont = null;
    }

    public TypeInfo typeInfo() {
        return typeInfo;
    }

    public void createTypeInfo() {
        typeInfo = new TypeInfo();
    }

    public void removeTypeInfo() {
        typeInfo = null;
    }
}
