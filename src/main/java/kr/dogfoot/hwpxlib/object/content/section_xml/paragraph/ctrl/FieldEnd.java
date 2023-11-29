package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.ctrl;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.CtrlItem;

/**
 * 필드 끝
 */
public class FieldEnd extends CtrlItem {
    /**
     * 짝이 되는 <hp:fieldBegin>의 id
     */
    private String beginIDRef;
    /**
     * 짝이 되는 <hp:fieldBegin>의 fieldid
     */
    private String fieldid;

    public FieldEnd() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_fieldEnd;
    }

    public String beginIDRef() {
        return beginIDRef;
    }

    public void beginIDRef(String beginIDRef) {
        this.beginIDRef = beginIDRef;
    }

    public FieldEnd beginIDRefAnd(String beginIDRef) {
        this.beginIDRef = beginIDRef;
        return this;
    }

    public String fieldid() {
        return fieldid;
    }

    public void fieldid(String fieldid) {
        this.fieldid = fieldid;
    }

    public FieldEnd fieldidAnd(String fieldid) {
        this.fieldid = fieldid;
        return this;
    }

    @Override
    public FieldEnd clone() {
        FieldEnd cloned = new FieldEnd();
        cloned.copyFrom(this);
        return cloned;
    }

    public void copyFrom(FieldEnd from) {
        this.beginIDRef = from.beginIDRef;
        this.fieldid = from.fieldid;

        super.copyFrom(from);
    }
}
