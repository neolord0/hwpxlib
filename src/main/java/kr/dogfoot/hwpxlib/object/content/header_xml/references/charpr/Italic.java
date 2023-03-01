package kr.dogfoot.hwpxlib.object.content.header_xml.references.charpr;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.baseobject.NoAttributeNoChild;

/**
 * 글자 기울임
 */
public class Italic extends NoAttributeNoChild<Italic> {
    public Italic() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hh_italic;
    }
}
