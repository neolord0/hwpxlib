package kr.dogfoot.hwpxlib.object.content.header_xml.references.parapr;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;

/**
 * 문단 테두리
 */
public class ParaBorder extends HWPXObject {
    /**
     * 테두리/채움 아이디 참조값
     */
    private String borderFillIDRef;
    /**
     * 왼쪽 간격, 단위는 hwpunit
     */
    private Integer offsetLeft;
    /**
     * 오른쪽 간격, 단위는 hwpunit
     */
    private Integer offsetRight;
    /**
     * 위쪽 간격, 단위는 hwpunit
     */
    private Integer offsetTop;
    /**
     * 아래쪽 간격, 단위는 hwpunit
     */
    private Integer offsetBottom;
    /**
     * 문단 테두리 연결 여부
     */
    private Boolean connect;
    /**
     * 문단 여백 무시 여부
     */
    private Boolean ignoreMargin;

    public ParaBorder() {
    }

    @Override
    public ObjectType objectType() {
        return ObjectType.ParaBorder;
    }

    public String borderFillIDRef() {
        return borderFillIDRef;
    }

    public void borderFillIDRef(String borderFillIDRef) {
        this.borderFillIDRef = borderFillIDRef;
    }

    public ParaBorder borderFillIDRefAnd(String borderFillIDRef) {
        this.borderFillIDRef = borderFillIDRef;
        return this;
    }

    public Integer offsetLeft() {
        return offsetLeft;
    }

    public void offsetLeft(Integer offsetLeft) {
        this.offsetLeft = offsetLeft;
    }

    public ParaBorder offsetLeftAnd(Integer offsetLeft) {
        this.offsetLeft = offsetLeft;
        return this;
    }

    public Integer offsetRight() {
        return offsetRight;
    }

    public void offsetRight(Integer offsetRight) {
        this.offsetRight = offsetRight;
    }

    public ParaBorder offsetRightAnd(Integer offsetRight) {
        this.offsetRight = offsetRight;
        return this;
    }

    public Integer offsetTop() {
        return offsetTop;
    }

    public void offsetTop(Integer offsetTop) {
        this.offsetTop = offsetTop;
    }

    public ParaBorder offsetTopAnd(Integer offsetTop) {
        this.offsetTop = offsetTop;
        return this;
    }

    public Integer offsetBottom() {
        return offsetBottom;
    }

    public void offsetBottom(Integer offsetBottom) {
        this.offsetBottom = offsetBottom;
    }

    public ParaBorder offsetBottomAnd(Integer offsetBottom) {
        this.offsetBottom = offsetBottom;
        return this;
    }

    public Boolean connect() {
        return connect;
    }

    public void connect(Boolean connect) {
        this.connect = connect;
    }

    public ParaBorder connectAnd(Boolean connect) {
        this.connect = connect;
        return this;
    }

    public Boolean ignoreMargin() {
        return ignoreMargin;
    }

    public void ignoreMargin(Boolean ignoreMargin) {
        this.ignoreMargin = ignoreMargin;
    }

    public ParaBorder ignoreMarginAnd(Boolean ignoreMargin) {
        this.ignoreMargin = ignoreMargin;
        return this;
    }
}
