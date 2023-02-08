package kr.dogfoot.hwpxlib.object.content.header_xml;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;

public class DocOption extends SwitchableObject {
    private LinkInfo linkinfo;

    public DocOption() {
    }

    @Override
    public ObjectType objectType() {
        return ObjectType.DocOption;
    }

    @Override
    public HWPXObject createChildWithElementName(String name) {
        if (ObjectType.LinkInfo.equalElementName(name))  {
            return new LinkInfo();
        }
        return null;
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
