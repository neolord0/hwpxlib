package kr.dogfoot.hwpxlib.object.content.header_xml.references.charpr;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.baseobject.NoAttributeNoChild;

/**
 * 글자 굵게
 */
public class Bold extends NoAttributeNoChild<Bold> {
    public Bold() {
    }

    @Override
    public ObjectType objectType() {
        return ObjectType.Bold;
    }
}
