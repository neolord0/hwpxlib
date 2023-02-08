package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.HorizontalAlign1;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.DisplayScrollBar;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.TabKeyBehavior;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.edit.EditText;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.formobject.FormObject;

/**
 * 에디트
 */
public class Edit extends FormObject<Edit> {
    /**
     * 여러 줄 허용 여부
     */
    private Boolean multiLine;
    /**
     * 패스워드 입력으로 사용할 때, 글자 대신 보이는 문자
     */
    private String passwordChar;
    /**
     * 최대 글자 수
     */
    private Integer maxLength;
    /**
     * 스크롤바 표시 방법
     */
    private DisplayScrollBar scrollBars;
    /**
     * 탭키를 눌렸을 때의 동작
     */
    private TabKeyBehavior tabKeyBehavior;
    /**
     * 숫자만 입력 여부
     */
    private Boolean numOnly;
    /**
     * 읽기 전용 여부
     */
    private Boolean readOnly;
    /**
     * 글자 정렬
     */
    private HorizontalAlign1 alignText;
    /**
     * 문자열
     */
    private EditText text;

    public Edit() {
    }

    @Override
    public ObjectType objectType() {
        return ObjectType.Edit;
    }

    @Override
    public HWPXObject createChildWithElementName(String name) {
        if (ObjectType.EditText.equalElementName(name)) {
            return new EditText();
        }
        return super.createChildWithElementName(name);
    }

    public Boolean multiLine() {
        return multiLine;
    }

    public void multiLine(Boolean multiLine) {
        this.multiLine = multiLine;
    }

    public Edit multiLineAnd(Boolean multiLine) {
        this.multiLine = multiLine;
        return this;
    }

    public String passwordChar() {
        return passwordChar;
    }

    public void passwordChar(String passwordChar) {
        this.passwordChar = passwordChar;
    }

    public Edit passwordCharAnd(String passwordChar) {
        this.passwordChar = passwordChar;
        return this;
    }

    public Integer maxLength() {
        return maxLength;
    }

    public void maxLength(Integer maxLength) {
        this.maxLength = maxLength;
    }

    public Edit maxLengthAnd(Integer maxLength) {
        this.maxLength = maxLength;
        return this;
    }

    public DisplayScrollBar scrollBars() {
        return scrollBars;
    }

    public void scrollBars(DisplayScrollBar scrollBars) {
        this.scrollBars = scrollBars;
    }

    public Edit scrollBarsAnd(DisplayScrollBar scrollBars) {
        this.scrollBars = scrollBars;
        return this;
    }

    public TabKeyBehavior tabKeyBehavior() {
        return tabKeyBehavior;
    }

    public void tabKeyBehavior(TabKeyBehavior tabKeyBehavior) {
        this.tabKeyBehavior = tabKeyBehavior;
    }

    public Edit tabKeyBehaviorAnd(TabKeyBehavior tabKeyBehavior) {
        this.tabKeyBehavior = tabKeyBehavior;
        return this;
    }

    public Boolean numOnly() {
        return numOnly;
    }

    public void numOnly(Boolean numOnly) {
        this.numOnly = numOnly;
    }

    public Edit numOnlyAnd(Boolean numOnly) {
        this.numOnly = numOnly;
        return this;
    }

    public Boolean readOnly() {
        return readOnly;
    }

    public void readOnly(Boolean readOnly) {
        this.readOnly = readOnly;
    }

    public Edit readOnlyAnd(Boolean readOnly) {
        this.readOnly = readOnly;
        return this;
    }

    public HorizontalAlign1 alignText() {
        return alignText;
    }

    public void alignText(HorizontalAlign1 alignText) {
        this.alignText = alignText;
    }

    public Edit alignTextAnd(HorizontalAlign1 alignText) {
        this.alignText = alignText;
        return this;
    }

    public EditText text() {
        return text;
    }

    public void createText() {
        text = new EditText();
    }

    public void removeText() {
        text = null;
    }
}
