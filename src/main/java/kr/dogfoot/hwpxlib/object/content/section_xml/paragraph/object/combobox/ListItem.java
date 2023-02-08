package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.combobox;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;

/**
 * 콤보박스, 리스트 박스 아이템
 */
public class ListItem extends HWPXObject {
    /**
     * 출력 텍스트
     */
    private String displayText;
    /**
     * 값
     */
    private String value;

    public ListItem() {
    }

    @Override
    public ObjectType objectType() {
        return ObjectType.ListItem;
    }

    public String displayText() {
        return displayText;
    }

    public void displayText(String displayText) {
        this.displayText = displayText;
    }

    public ListItem displayTextAnd(String displayText) {
        this.displayText = displayText;
        return this;
    }

    public String value() {
        return value;
    }

    public void value(String value) {
        this.value = value;
    }

    public ListItem valueAnd(String value) {
        this.value = value;
        return this;
    }
}
