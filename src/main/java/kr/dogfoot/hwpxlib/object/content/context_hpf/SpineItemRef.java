package kr.dogfoot.hwpxlib.object.content.context_hpf;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;

public class SpineItemRef extends HWPXObject {
    private String idref;
    private String linear;

    public SpineItemRef() {
    }

    public SpineItemRef(String idref, String linear) {
        this.idref = idref;
        this.linear = linear;
    }

    @Override
    public ObjectType objectType() {
        return ObjectType.SpineItemRef;
    }

    public String idref() {
        return idref;
    }

    public void idref(String idref) {
        this.idref = idref;
    }

    public SpineItemRef idrefAnd(String idref) {
        this.idref = idref;
        return this;
    }

    public String linear() {
        return linear;
    }

    public void linear(String linear) {
        this.linear = linear;
    }

    public SpineItemRef linearAnd(String linear) {
        this.linear = linear;
        return this;
    }
}
