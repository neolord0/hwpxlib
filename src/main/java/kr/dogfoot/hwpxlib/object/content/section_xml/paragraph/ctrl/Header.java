package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.ctrl;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.ctrl.inner.HeaderFooterCore;

/**
 * 머리말
 */
public class Header extends HeaderFooterCore<Header> {
    public Header() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_header;
    }
}
