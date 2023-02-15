package kr.dogfoot.hwpxlib.object.content.header_xml.references.parapr;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.baseobject.ValueAndUnit;

/**
 * 이전 문단과의 여백
 */
public class PrevParaMargin extends ValueAndUnit<PrevParaMargin> {
    public PrevParaMargin() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hc_prev;
    }
}
