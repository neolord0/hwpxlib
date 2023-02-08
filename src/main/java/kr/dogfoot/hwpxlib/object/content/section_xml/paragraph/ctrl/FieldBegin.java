package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.ctrl;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectList;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.ctrl.inner.Parameters;
import kr.dogfoot.hwpxlib.object.content.section_xml.SubList;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.FieldType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.CtrlItem;

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

    public FieldBegin() {
    }

    @Override
    public ObjectType objectType() {
        return ObjectType.FieldBegin;
    }

    @Override
    public HWPXObject createChildWithElementName(String name) {
        if (ObjectType.Parameters.equalElementName(name)) {
            return new Parameters();
        } else if (ObjectType.SubList.equalElementName(name)) {
            return new SubList();
        }
        return null;
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
}
