package kr.dogfoot.hwpxlib.object.content.header_xml.references.parapr;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.baseobject.ValueAndUnit;

/**
 * 다음 문단과의 여백
 */
public class NextParaMargin extends ValueAndUnit<NextParaMargin> {
    public NextParaMargin() {
    }

    @Override
    public ObjectType objectType() {
        return ObjectType.Next;
    }
}
