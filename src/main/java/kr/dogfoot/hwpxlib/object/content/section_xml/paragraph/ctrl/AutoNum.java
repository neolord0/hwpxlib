package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.ctrl;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.ctrl.inner.AutoNumNewNumType;

/**
 * 자동 번호
 */
public class AutoNum extends AutoNumNewNumType<AutoNum> {
    public AutoNum() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_autoNum;
    }
}
