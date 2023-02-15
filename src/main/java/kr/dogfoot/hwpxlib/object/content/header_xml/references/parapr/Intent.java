package kr.dogfoot.hwpxlib.object.content.header_xml.references.parapr;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.baseobject.ValueAndUnit;

/**
 * 들여쓰기/내여쓰기
 */
public class Intent extends ValueAndUnit<Intent> {
    public Intent() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hc_intent;
    }
}
