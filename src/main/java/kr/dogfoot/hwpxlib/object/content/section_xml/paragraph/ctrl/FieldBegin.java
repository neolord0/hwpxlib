package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.ctrl;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.baseobject.HasOnlyText;
import kr.dogfoot.hwpxlib.object.content.section_xml.SubList;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.FieldType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.CtrlItem;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.ctrl.inner.Parameters;

/**
 * 필드 시작
 */
public class FieldBegin extends CtrlItem {
    /**
     * 아이디
     */
    private String id;
    /**
     * 필드 타입
     */
    private FieldType type;
    /**
     * 필드 이름
     */
    private String name;
    /**
     * 수정 가능 여부
     */
    private Boolean editable;
    /**
     * 내용이 수정되었는지 여부
     */
    private Boolean dirty;
    /**
     * Z-Order
     */
    private Integer zorder;
    /**
     * 필드 아이디
     */
    private String fieldid;
    /**
     * 파라메터
     */
    private Parameters parameters;
    /**
     * 내부 문단 리스트
     */
    private SubList subList;
    /**
     * 메타 태그
     */
    private HasOnlyText metaTag;

    public FieldBegin() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_fieldBegin;
    }


    public String id() {
        return id;
    }

    public void id(String id) {
        this.id = id;
    }

    public FieldBegin idAnd(String id) {
        this.id = id;
        return this;
    }

    public FieldType type() {
        return type;
    }

    public void type(FieldType type) {
        this.type = type;
    }

    public FieldBegin typeAnd(FieldType type) {
        this.type = type;
        return this;
    }

    public String name() {
        return name;
    }

    public void name(String name) {
        this.name = name;
    }

    public FieldBegin nameAnd(String name) {
        this.name = name;
        return this;
    }

    public Boolean editable() {
        return editable;
    }

    public void editable(Boolean editable) {
        this.editable = editable;
    }

    public FieldBegin editableAnd(Boolean editable) {
        this.editable = editable;
        return this;
    }

    public Boolean dirty() {
        return dirty;
    }

    public void dirty(Boolean dirty) {
        this.dirty = dirty;
    }

    public FieldBegin dirtyAnd(Boolean dirty) {
        this.dirty = dirty;
        return this;
    }

    public Integer zorder() {
        return zorder;
    }

    public void zorder(Integer zorder) {
        this.zorder = zorder;
    }

    public FieldBegin zorderAnd(Integer zorder) {
        this.zorder = zorder;
        return this;
    }

    public String fieldid() {
        return fieldid;
    }

    public void fieldid(String fieldid) {
        this.fieldid = fieldid;
    }

    public FieldBegin fieldidAnd(String fieldid) {
        this.fieldid = fieldid;
        return this;
    }

    public Parameters parameters() {
        return parameters;
    }

    public void createParameters() {
        parameters = new Parameters();
    }

    public void removeParameters() {
        parameters = null;
    }

    public SubList subList() {
        return subList;
    }

    public void createSubList() {
        subList = new SubList();
    }

    public void removeSubList() {
        subList = null;
    }

    public HasOnlyText metaTag() {
        return metaTag;
    }

    public void createMetaTag() {
        metaTag = new HasOnlyText(ObjectType.hp_metaTag);
    }

    public void removeMetaTag() {
        metaTag = null;
    }

    @Override
    public FieldBegin clone() {
        FieldBegin cloned = new FieldBegin();
        cloned.copyFrom(this);
        return cloned;
    }

    public void copyFrom(FieldBegin from) {
        this.id = from.id;
        this.type = from.type;
        this.name = from.name;
        this.editable = from.editable;
        this.dirty = from.dirty;
        this.zorder = from.zorder;
        this.fieldid = from.fieldid;

        if (from.parameters != null) {
            parameters = from.parameters.clone();
        } else {
            parameters = null;
        }

        if (from.subList != null) {
            subList = from.subList.clone();
        } else {
            subList = null;
        }

        super.copyFrom(from);
    }
}


