package kr.dogfoot.hwpxlib.object.content.header_xml.references.charpr;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.baseobject.NoAttributeNoChild;

/**
 * 아래첨자
 */
public class Subscript extends NoAttributeNoChild<Subscript> {
    public Subscript() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hh_subscript;
    }
}
