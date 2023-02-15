package kr.dogfoot.hwpxlib.object.content.context_hpf;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.baseobject.HasOnlyText;

public class Title extends HasOnlyText<Title> {
    public Title() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.opf_title;
    }
}
