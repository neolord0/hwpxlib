package kr.dogfoot.hwpxlib.object.content.header_xml.references.parapr;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.baseobject.ValueAndUnit;

/**
 * 오른쪽 여백
 */
public class RightMargin extends ValueAndUnit<RightMargin> {
    public RightMargin() {
    }

    @Override
    public ObjectType objectType() {
        return ObjectType.Right;
    }
}
