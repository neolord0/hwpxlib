package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.ctrl;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.ctrl.inner.AutoNumNewNumType;

/**
 * 새 번호
 */
public class NewNum extends AutoNumNewNumType<NewNum> {
    public NewNum() {
    }

    @Override
    public ObjectType objectType() {
        return ObjectType.NewNum;
    }
}
