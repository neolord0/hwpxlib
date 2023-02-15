package kr.dogfoot.hwpxlib.object.content.header_xml;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.baseobject.HasOnlyText;

/**
 * 금칙어
 */
public class ForbiddenWord extends HasOnlyText<ForbiddenWord> {
    public ForbiddenWord() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hh_forbiddenWord;
    }
}
