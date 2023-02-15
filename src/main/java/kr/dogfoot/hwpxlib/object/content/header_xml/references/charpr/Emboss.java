package kr.dogfoot.hwpxlib.object.content.header_xml.references.charpr;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.baseobject.NoAttributeNoChild;

/**
 * 양각 문자
 */
public class Emboss extends NoAttributeNoChild<Emboss> {
    public Emboss() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hh_emboss;
    }
}
