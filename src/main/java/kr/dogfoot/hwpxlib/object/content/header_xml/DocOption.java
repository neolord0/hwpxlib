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

    public LinkInfo linkInfo() {
        return linkinfo;
    }

    public DocOption createLinkInfo() {
        linkinfo = new LinkInfo();
        return this;
    }

    public DocOption removeLinkInfo() {
        linkinfo = null;
        return this;
    }

}
