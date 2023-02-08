package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.equation;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.baseobject.HasOnlyText;

public class Script extends HasOnlyText<Script> {
    public Script() {
    }

    @Override
    public ObjectType objectType() {
        return ObjectType.Script;
    }
}
