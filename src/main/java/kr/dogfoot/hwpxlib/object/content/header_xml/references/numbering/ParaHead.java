package kr.dogfoot.hwpxlib.object.content.header_xml.references.numbering;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.HorizontalAlign1;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.NumberType1;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.ValueUnit1;

/**
 * 각 수준의 문단 머리
 */
public class ParaHead extends HWPXObject {
    /**
     * 수준, 1~7
     */
    private Byte level;
    /**
     * 시작 번호
     */
    private Integer start;
    /**
     * 문단 정렬
     */
    private HorizontalAlign1 align;
    /**
     * 번호 너비를 자릿수에 맞춤 여부
     */
    private Boolean useInstWidth;
    /**
     * 자동 내어쓰기 여부
     */
    private Boolean autoIndent;
    /**
     * 번호 너비 보정값, 단위는 hwpunit
     */
    private Integer widthAdjust;
    /**
     * textOffset 값에 단위
     */
    private ValueUnit1 textOffsetType;
    /**
     * 본문과의 간격
     */
    private Integer textOffset;
    /**
     * 번호 포맷
     */
    private NumberType1 numFormat;
    /**
     * 글자 모양 참조 아이디(지정하지 않으려면 4294967295=0xffffffff을 입력)
     */
    private String charPrIDRef;
    /**
     * ??
     */
    private Boolean checkable;

    private String text;

    @Override
    public ObjectType _objectType() {
        return ObjectType.hh_paraHead;
    }

    public Byte level() {
        return level;
    }

    public void level(Byte level) {
        this.level = level;
    }

    public ParaHead levelAnd(Byte level) {
        this.level = level;
        return this;
    }

    public Integer start() {
        return start;
    }

    public void start(Integer start) {
        this.start = start;
    }

    public ParaHead startAnd(Integer start) {
        this.start = start;
        return this;
    }

    public HorizontalAlign1 align() {
        return align;
    }

    public void align(HorizontalAlign1 align) {
        this.align = align;
    }

    public ParaHead alignAnd(HorizontalAlign1 align) {
        this.align = align;
        return this;
    }

    public Boolean useInstWidth() {
        return useInstWidth;
    }

    public void useInstWidth(Boolean useInstWidth) {
        this.useInstWidth = useInstWidth;
    }

    public ParaHead useInstWidthAnd(Boolean useInstWidth) {
        this.useInstWidth = useInstWidth;
        return this;
    }

    public Boolean autoIndent() {
        return autoIndent;
    }

    public void autoIndent(Boolean autoIndent) {
        this.autoIndent = autoIndent;
    }

    public ParaHead autoIndentAnd(Boolean autoIndent) {
        this.autoIndent = autoIndent;
        return this;
    }

    public Integer widthAdjust() {
        return widthAdjust;
    }

    public void widthAdjust(Integer widthAdjust) {
        this.widthAdjust = widthAdjust;
    }

    public ParaHead widthAdjustAnd(Integer widthAdjust) {
        this.widthAdjust = widthAdjust;
        return this;
    }

    public ValueUnit1 textOffsetType() {
        return textOffsetType;
    }

    public void textOffsetType(ValueUnit1 textOffsetType) {
        this.textOffsetType = textOffsetType;
    }

    public ParaHead textOffsetTypeAnd(ValueUnit1 textOffsetType) {
        this.textOffsetType = textOffsetType;
        return this;
    }

    public Integer textOffset() {
        return textOffset;
    }

    public void textOffset(Integer textOffset) {
        this.textOffset = textOffset;
    }

    public ParaHead textOffsetAnd(Integer textOffset) {
        this.textOffset = textOffset;
        return this;
    }

    public NumberType1 numFormat() {
        return numFormat;
    }

    public void numFormat(NumberType1 numFormat) {
        this.numFormat = numFormat;
    }

    public ParaHead numFormatAnd(NumberType1 numFormat) {
        this.numFormat = numFormat;
        return this;
    }

    public String charPrIDRef() {
        return charPrIDRef;
    }

    public void charPrIDRef(String charPrIDRef) {
        this.charPrIDRef = charPrIDRef;
    }

    public ParaHead charPrIDRefAnd(String charPrIDRef) {
        this.charPrIDRef = charPrIDRef;
        return this;
    }

    public Boolean checkable() {
        return checkable;
    }

    public void checkable(Boolean checkable) {
        this.checkable = checkable;
    }

    public ParaHead checkableAnd(Boolean checkable) {
        this.checkable = checkable;
        return this;
    }

    public String text() {
        return text;
    }

    public void text(String text) {
        this.text = text;
    }

    public ParaHead textAnd(String text) {
        this.text = text;
        return this;
    }

    @Override
    public ParaHead clone() {
        ParaHead cloned = new ParaHead();
        cloned.copyFrom(this);
        return cloned;
    }

    public void copyFrom(ParaHead from) {
        this.level = from.level;
        this.start = from.start;
        this.align = from.align;
        this.useInstWidth = from.useInstWidth;
        this.autoIndent = from.autoIndent;
        this.widthAdjust = from.widthAdjust;
        this.textOffsetType = from.textOffsetType;
        this.textOffset = from.textOffset;
        this.numFormat = from.numFormat;
        this.charPrIDRef = from.charPrIDRef;
        this.checkable = from.checkable;
        this.text = from.text;
    }
}
