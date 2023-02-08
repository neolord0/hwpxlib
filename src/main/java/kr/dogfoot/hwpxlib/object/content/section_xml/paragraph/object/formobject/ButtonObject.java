package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.formobject;

import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.BackStyle;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.ButtonCheckValue;

public abstract class ButtonObject<ChildType> extends FormObject<ChildType> {
    /**
     * 캡션
     */
    private String captionText;
    /**
     * 체크 상태 값
     */
    private ButtonCheckValue value;
    /**
     * 라디오 버튼 그룹 이름
     */
    private String radioGroupName;
    /**
     * 3단 체크 여부
     */
    private Boolean triState;
    /**
     * 배경색 스타일
     */
    private BackStyle backStyle;

    public String captionText() {
        return captionText;
    }

    public void captionText(String captionText) {
        this.captionText = captionText;
    }

    public ButtonObject captionTextAnd(String captionText) {
        this.captionText = captionText;
        return this;
    }

    public ButtonCheckValue value() {
        return value;
    }

    public void value(ButtonCheckValue value) {
        this.value = value;
    }

    public ButtonObject valueAnd(ButtonCheckValue value) {
        this.value = value;
        return this;
    }

    public String radioGroupName() {
        return radioGroupName;
    }

    public void radioGroupName(String radioGroupName) {
        this.radioGroupName = radioGroupName;
    }

    public ButtonObject radioGroupNameAnd(String radioGroupName) {
        this.radioGroupName = radioGroupName;
        return this;
    }

    public Boolean triState() {
        return triState;
    }

    public void triState(Boolean triState) {
        this.triState = triState;
    }

    public ButtonObject triStateAnd(Boolean triState) {
        this.triState = triState;
        return this;
    }

    public BackStyle backStyle() {
        return backStyle;
    }

    public void backStyle(BackStyle backStyle) {
        this.backStyle = backStyle;
    }

    public ButtonObject backStyleAnd(BackStyle backStyle) {
        this.backStyle = backStyle;
        return this;
    }
}
