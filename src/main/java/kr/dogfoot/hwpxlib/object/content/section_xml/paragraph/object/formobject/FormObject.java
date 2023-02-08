package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.formobject;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapeobject.ShapeObject;

public abstract class FormObject<ChildType> extends ShapeObject<ChildType> {
    /**
     * 이름
     */
    private String name;
    /**
     * 글자색
     */
    private String foreColor;
    /**
     * 배경색
     */
    private String backColor;
    /**
     * 그룹 이름
     */
    private String groupName;
    /**
     * 탭키로 이동할 때 개체에 머물 수 있는지 여부
     */
    private Boolean tabStop;
    /**
     * 탭키 이동 순서
     */
    private Integer tabOrder;
    /**
     * 활성화 여부
     */
    private Boolean enabled;
    /**
     * 테두리 아이디 참조 값
     */
    private String borderTypeIDRef;
    /**
     * 프레임 표시 여부
     */
    private Boolean drawFrame;
    /**
     * 출력 가능 여부
     */
    private Boolean printable;
    /**
     * 편집 가능 여부
     */
    private Boolean editable;
    private String command;
    private FormCharPr formCharPr;

    @Override
    public HWPXObject createChildWithElementName(String name) {
        if (ObjectType.FormCharPr.equalElementName(name)) {
            return new FormCharPr();
        }
        return super.createChildWithElementName(name);
    }


    public String name() {
        return name;
    }

    public void name(String name) {
        this.name = name;
    }

    public FormObject nameAnd(String name) {
        this.name = name;
        return this;
    }

    public String foreColor() {
        return foreColor;
    }

    public void foreColor(String foreColor) {
        this.foreColor = foreColor;
    }

    public FormObject foreColorAnd(String foreColor) {
        this.foreColor = foreColor;
        return this;
    }

    public String backColor() {
        return backColor;
    }

    public void backColor(String backColor) {
        this.backColor = backColor;
    }

    public FormObject backColorAnd(String backColor) {
        this.backColor = backColor;
        return this;
    }

    public String groupName() {
        return groupName;
    }

    public void groupName(String groupName) {
        this.groupName = groupName;
    }

    public FormObject groupNameAnd(String groupName) {
        this.groupName = groupName;
        return this;
    }

    public Boolean tabStop() {
        return tabStop;
    }

    public void tabStop(Boolean tabStop) {
        this.tabStop = tabStop;
    }

    public FormObject tabStopAnd(Boolean tabStop) {
        this.tabStop = tabStop;
        return this;
    }

    public Integer tabOrder() {
        return tabOrder;
    }

    public void tabOrder(Integer tabOrder) {
        this.tabOrder = tabOrder;
    }

    public FormObject tabOrderAnd(Integer tabOrder) {
        this.tabOrder = tabOrder;
        return this;
    }

    public Boolean enabled() {
        return enabled;
    }

    public void enabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public FormObject enabledAnd(Boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    public String borderTypeIDRef() {
        return borderTypeIDRef;
    }

    public void borderTypeIDRef(String borderTypeIDRef) {
        this.borderTypeIDRef = borderTypeIDRef;
    }

    public FormObject borderTypeIDRefAnd(String borderTypeIDRef) {
        this.borderTypeIDRef = borderTypeIDRef;
        return this;
    }

    public Boolean drawFrame() {
        return drawFrame;
    }

    public void drawFrame(Boolean drawFrame) {
        this.drawFrame = drawFrame;
    }

    public FormObject drawFrameAnd(Boolean drawFrame) {
        this.drawFrame = drawFrame;
        return this;
    }

    public Boolean printable() {
        return printable;
    }

    public void printable(Boolean printable) {
        this.printable = printable;
    }

    public FormObject printableAnd(Boolean printable) {
        this.printable = printable;
        return this;
    }

    public Boolean editable() {
        return editable;
    }

    public void editable(Boolean editable) {
        this.editable = editable;
    }

    public FormObject editableAnd(Boolean editable) {
        this.editable = editable;
        return this;
    }

    public String command() {
        return command;
    }

    public void command(String command) {
        this.command = command;
    }

    public FormObject commandAnd(String command) {
        this.command = command;
        return this;
    }

    public FormCharPr formCharPr() {
        return formCharPr;
    }

    public void createFormCharPr() {
        formCharPr = new FormCharPr();
    }

    public void removeFormCharPr() {
        formCharPr = null;
    }
}
