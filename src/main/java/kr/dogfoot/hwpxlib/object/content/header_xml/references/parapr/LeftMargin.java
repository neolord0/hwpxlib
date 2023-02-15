package kr.dogfoot.hwpxlib.object.content.header_xml.references.parapr;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.baseobject.ValueAndUnit;

/**
 * 왼쪽 여백
 */
public class LeftMargin extends ValueAndUnit<LeftMargin> {
    public LeftMargin() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hc_left;
    }
}
