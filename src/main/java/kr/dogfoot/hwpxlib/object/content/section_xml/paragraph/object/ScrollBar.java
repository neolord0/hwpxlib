package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.ScrollBarType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.formobject.FormObject;

/**
 * 스크롤바
 */
public class ScrollBar extends FormObject<ScrollBar> {
    /**
     * 마우스 버튼 다운 후 스크롤이 연속적으로 일어날 때까지 걸리는 시간
     */
    private Integer delay;
    /**
     * Page Up/Down 시 변화량
     */
    private Integer largeChange;
    /**
     * Line Up/Down 시 변화량
     */
    private Integer smallChange;
    /**
     * 최소값
     */
    private Integer min;
    /**
     * 최대값
     */
    private Integer max;
    /**
     * 스크롤 한 페이지의 크기
     */
    private Integer page;
    /**
     * 현재 위치
     */
    private Integer value;
    /**
     * 스크롤바 종류
     */
    private ScrollBarType type;

    public ScrollBar() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_scrollBar;
    }

    public Integer delay() {
        return delay;
    }

    public void delay(Integer delay) {
        this.delay = delay;
    }

    public ScrollBar delayAnd(Integer delay) {
        this.delay = delay;
        return this;
    }

    public Integer largeChange() {
        return largeChange;
    }

    public void largeChange(Integer largeChange) {
        this.largeChange = largeChange;
    }

    public ScrollBar largeChangeAnd(Integer largeChange) {
        this.largeChange = largeChange;
        return this;
    }

    public Integer smallChange() {
        return smallChange;
    }

    public void smallChange(Integer smallChange) {
        this.smallChange = smallChange;
    }

    public ScrollBar smallChangeAnd(Integer smallChange) {
        this.smallChange = smallChange;
        return this;
    }

    public Integer min() {
        return min;
    }

    public void min(Integer min) {
        this.min = min;
    }

    public ScrollBar minAnd(Integer min) {
        this.min = min;
        return this;
    }

    public Integer max() {
        return max;
    }

    public void max(Integer max) {
        this.max = max;
    }

    public ScrollBar maxAnd(Integer max) {
        this.max = max;
        return this;
    }

    public Integer page() {
        return page;
    }

    public void page(Integer page) {
        this.page = page;
    }

    public ScrollBar pageAnd(Integer page) {
        this.page = page;
        return this;
    }

    public Integer value() {
        return value;
    }

    public void value(Integer value) {
        this.value = value;
    }

    public ScrollBar valueAnd(Integer value) {
        this.value = value;
        return this;
    }

    public ScrollBarType type() {
        return type;
    }

    public void type(ScrollBarType type) {
        this.type = type;
    }

    public ScrollBar typeAnd(ScrollBarType type) {
        this.type = type;
        return this;
    }
}
