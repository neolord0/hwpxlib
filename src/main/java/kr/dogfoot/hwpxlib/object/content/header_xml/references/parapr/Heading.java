package kr.dogfoot.hwpxlib.object.content.header_xml.references.parapr;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.ParaHeadingType;

/**
 * 문단 머리 번호/글머리표
 */
public class Heading extends HWPXObject {
    /**
     * 문단 머리 모양 종류
     */
    private ParaHeadingType type;
    /**
     * 문단 번호/글머리표 아이디 참조값
     */
    private String idRef;
    /**
     * 문단 1수준 ~ 7수준(0 ~ 6)
     */
    private Byte level;

    public Heading() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hh_heading;
    }

    public ParaHeadingType type() {
        return type;
    }

    public void type(ParaHeadingType type) {
        this.type = type;
    }

    public Heading typeAnd(ParaHeadingType type) {
        this.type = type;
        return this;
    }

    public String idRef() {
        return idRef;
    }

    public void idRef(String idRef) {
        this.idRef = idRef;
    }

    public Heading idRefAnd(String idRef) {
        this.idRef = idRef;
        return this;
    }

    public Byte level() {
        return level;
    }

    public void level(Byte level) {
        this.level = level;
    }

    public Heading levelAnd(Byte level) {
        this.level = level;
        return this;
    }
}
