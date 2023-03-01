package kr.dogfoot.hwpxlib.object.content.header_xml;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;

public class DocOption extends SwitchableObject {
    private LinkInfo linkinfo;

    public DocOption() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hh_docOption;
    }

    public LinkInfo linkinfo() {
        return linkinfo;
    }

    public DocOption createLinkinfo() {
        linkinfo = new LinkInfo();
        return this;
    }

    public DocOption removeLinkinfo() {
        linkinfo = null;
        return this;
    }

}
