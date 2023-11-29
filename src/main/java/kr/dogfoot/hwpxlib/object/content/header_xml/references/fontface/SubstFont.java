package kr.dogfoot.hwpxlib.object.content.header_xml.references.fontface;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.FontType;

/**
 * 대체 폰트 정보
 */
public class SubstFont extends HWPXObject {
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

    public SubstFont() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hh_substFont;
    }

    public String face() {
        return face;
    }

    public void face(String face) {
        this.face = face;
    }

    public SubstFont faceAnd(String face) {
        this.face = face;
        return this;
    }

    public FontType type() {
        return type;
    }

    public void type(FontType type) {
        this.type = type;
    }

    public SubstFont typeAnd(FontType type) {
        this.type = type;
        return this;
    }

    public Boolean isEmbedded() {
        return isEmbedded;
    }

    public void isEmbedded(Boolean ieEmbedded) {
        this.isEmbedded = ieEmbedded;
    }

    public SubstFont isEmbeddedAnd(Boolean ieEmbedded) {
        this.isEmbedded = ieEmbedded;
        return this;
    }

    public String binaryItemIDRef() {
        return binaryItemIDRef;
    }

    public void binaryItemIDRef(String binaryItemIDRef) {
        this.binaryItemIDRef = binaryItemIDRef;
    }

    public SubstFont binaryItemIDRefAnd(String binaryItemIDRef) {
        this.binaryItemIDRef = binaryItemIDRef;
        return this;
    }

    @Override
    public SubstFont clone() {
        SubstFont cloned = new SubstFont();
        cloned.copyFrom(this);
        return cloned;
    }

    public void copyFrom(SubstFont from) {
        this.face = from.face;
        this.type = from.type;
        this.isEmbedded = from.isEmbedded;
        this.binaryItemIDRef = from.binaryItemIDRef;
    }
}

