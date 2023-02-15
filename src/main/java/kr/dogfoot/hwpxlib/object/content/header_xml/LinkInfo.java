package kr.dogfoot.hwpxlib.object.content.header_xml;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;

public class LinkInfo extends HWPXObject {
    private String path;
    private Boolean pageInherit;
    private Boolean footnoteInherit;

    public LinkInfo() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hh_linkinfo;
    }

    public String path() {
        return path;
    }

    public void path(String path) {
        this.path = path;
    }

    public LinkInfo pathAnd(String path) {
        this.path = path;
        return this;
    }

    public Boolean pageInherit() {
        return pageInherit;
    }

    public void pageInherit(Boolean pageInherit) {
        this.pageInherit = pageInherit;
    }

    public LinkInfo pageInheritAnd(Boolean pageInherit) {
        this.pageInherit = pageInherit;
        return this;
    }

    public Boolean footnoteInherit() {
        return footnoteInherit;
    }

    public void footnoteInherit(Boolean footnoteInherit) {
        this.footnoteInherit = footnoteInherit;
    }

    public LinkInfo footnoteInheritAnd(Boolean footnoteInherit) {
        this.footnoteInherit = footnoteInherit;
        return this;
    }
}
