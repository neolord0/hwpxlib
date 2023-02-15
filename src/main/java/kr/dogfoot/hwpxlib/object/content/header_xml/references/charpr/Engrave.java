package kr.dogfoot.hwpxlib.object.content.header_xml.references.charpr;


import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.baseobject.NoAttributeNoChild;

/**
 * 음각 문자
 */
public class Engrave extends NoAttributeNoChild<Engrave> {
    public Engrave() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hh_engrave;
    }
}
