package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.ctrl;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.ctrl.inner.HeaderFooterCore;

/**
 * 꼬리말
 */
public class Footer extends HeaderFooterCore<Footer> {
    public Footer() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_footer;
    }

    @Override
    public Footer clone() {
        Footer cloned = new Footer();
        cloned.copyFrom(this);
        return cloned;
    }

    public void copyFrom(Footer from) {
        super.copyFrom(from);
    }
}
