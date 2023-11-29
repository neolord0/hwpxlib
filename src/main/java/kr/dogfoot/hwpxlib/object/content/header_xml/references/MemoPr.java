package kr.dogfoot.hwpxlib.object.content.header_xml.references;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.LineType2;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.LineWidth;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.MemoType;

/**
 * 메모 모양
 */
public class MemoPr extends HWPXObject {
    /**
     * 아이디
     */
    private String id;
    /**
     * 메모가 보이는 너비
     */
    private Integer width;
    /**
     * 메모의 선 종류
     */
    private LineType2 lineType;
    /**
     * 메모의 선 색
     */
    private String lineColor;
    /**
     * 메모의 색
     */
    private String fillColor;
    /**
     * 활성화 되었을 때 메모의 색
     */
    private String activeColor;
    /**
     * 메모 변경 추적을 위한 속성
     */
    private MemoType memoType;
    /**
     * 선 두께 인덱스로 저장됨(LineWidth.index)
     */
    private LineWidth lineWidth;

    public MemoPr() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hh_memoPr;
    }

    public String id() {
        return id;
    }

    public void id(String id) {
        this.id = id;
    }

    public MemoPr idAnd(String id) {
        this.id = id;
        return this;
    }

    public Integer width() {
        return width;
    }

    public void width(Integer width) {
        this.width = width;
    }

    public MemoPr widthAnd(Integer width) {
        this.width = width;
        return this;
    }

    public LineType2 lineType() {
        return lineType;
    }

    public void lineType(LineType2 lineType) {
        this.lineType = lineType;
    }

    public MemoPr lineTypeAnd(LineType2 lineType) {
        this.lineType = lineType;
        return this;
    }

    public String lineColor() {
        return lineColor;
    }

    public void lineColor(String lineColor) {
        this.lineColor = lineColor;
    }

    public MemoPr lineColorAnd(String lineColor) {
        this.lineColor = lineColor;
        return this;
    }

    public String fillColor() {
        return fillColor;
    }

    public void fillColor(String fillColor) {
        this.fillColor = fillColor;
    }

    public MemoPr fillColorAnd(String fillColor) {
        this.fillColor = fillColor;
        return this;
    }

    public String activeColor() {
        return activeColor;
    }

    public void activeColor(String activeColor) {
        this.activeColor = activeColor;
    }

    public MemoPr activeColorAnd(String activeColor) {
        this.activeColor = activeColor;
        return this;
    }

    public MemoType memoType() {
        return memoType;
    }

    public void memoType(MemoType memoType) {
        this.memoType = memoType;
    }

    public MemoPr memoTypeAnd(MemoType memoType) {
        this.memoType = memoType;
        return this;
    }

    public LineWidth lineWidth() {
        return lineWidth;
    }

    public void lineWidth(LineWidth lineWidth) {
        this.lineWidth = lineWidth;
    }

    public MemoPr lineWidthAnd(LineWidth lineWidth) {
        this.lineWidth = lineWidth;
        return this;
    }

    @Override
    public MemoPr clone() {
        MemoPr cloned = new MemoPr();
        cloned.copyFrom(this);
        return cloned;
    }

    public void copyFrom(MemoPr from) {
        this.id = from.id;
        this.width = from.width;
        this.lineType = from.lineType;
        this.lineColor = from.lineColor;
        this.fillColor = from.fillColor;
        this.activeColor = from.activeColor;
        this.memoType = from.memoType;
        this.lineWidth = from.lineWidth;
    }
}
