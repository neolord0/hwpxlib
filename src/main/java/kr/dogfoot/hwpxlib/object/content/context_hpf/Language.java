package kr.dogfoot.hwpxlib.object.content.context_hpf;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.baseobject.HasOnlyText;

public class Language extends HasOnlyText<Language> {
    public Language() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.opf_language;
    }
}
