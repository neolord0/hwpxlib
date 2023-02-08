package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.ctrl;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.ctrl.inner.HeaderFooterType;

/**
 * 머리말
 */
public class Header extends HeaderFooterType<Header> {
    public Header() {
    }

    @Override
    public ObjectType objectType() {
        return ObjectType.Header;
    }
}
