package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapeobject;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.HorzAlign;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.HorzRelTo;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.VertAlign;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.VertRelTo;

/**
 * 도형 위치
 */
public class ShapePosition extends HWPXObject {
    /**
     * 글자처럼 취급 여부
     */
    private Boolean treatAsChar;
    /**
     * 줄 간격에 영향을 줄지 여부, 글자처럼 취급 일떄만 처리됨
     */
    private Boolean affectLSpacing;
    /**
     * 객체의 세로 위치를 쪽 영역 안으로 제한 여부
     */
    private Boolean flowWithText;
    /**
     * 서로 겹침 허용
     */
    private Boolean allowOverlap;
    /**
     * 객체와 조판부호를 항상 같은 쪽에 놓을지 여부
     */
    private Boolean holdAnchorAndSO;
    /**
     * 세로 위치 기준
     */
    private VertRelTo vertRelTo;
    /**
     * 가로 위치 기준
     */
    private HorzRelTo horzRelTo;
    /**
     * 세로 배열 방식
     */
    private VertAlign vertAlign;
    /**
     * 가로 배열 방식
     */
    private HorzAlign horzAlign;
    /**
     * 세로 오프셋, 단위는 hwpunit
     */
    private Integer vertOffset;
    /**
     * 가로 오프셋, 단위는 hwpunit
     */
    private Integer horzOffset;

    public ShapePosition() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_pos_for_shapeObject;
    }

    public Boolean treatAsChar() {
        return treatAsChar;
    }

    public void treatAsChar(Boolean treatAsChar) {
        this.treatAsChar = treatAsChar;
    }

    public ShapePosition treatAsCharAnd(Boolean treatAsChar) {
        this.treatAsChar = treatAsChar;
        return this;
    }

    public Boolean affectLSpacing() {
        return affectLSpacing;
    }

    public void affectLSpacing(Boolean affectLSpacing) {
        this.affectLSpacing = affectLSpacing;
    }

    public ShapePosition affectLSpacingAnd(Boolean affectLSpacing) {
        this.affectLSpacing = affectLSpacing;
        return this;
    }

    public Boolean flowWithText() {
        return flowWithText;
    }

    public void flowWithText(Boolean flowWithText) {
        this.flowWithText = flowWithText;
    }

    public ShapePosition flowWithTextAnd(Boolean flowWithText) {
        this.flowWithText = flowWithText;
        return this;
    }

    public Boolean allowOverlap() {
        return allowOverlap;
    }

    public void allowOverlap(Boolean allowOverlap) {
        this.allowOverlap = allowOverlap;
    }

    public ShapePosition allowOverlapAnd(Boolean allowOverlap) {
        this.allowOverlap = allowOverlap;
        return this;
    }

    public Boolean holdAnchorAndSO() {
        return holdAnchorAndSO;
    }

    public void holdAnchorAndSO(Boolean holdAnchorAndSO) {
        this.holdAnchorAndSO = holdAnchorAndSO;
    }

    public ShapePosition holdAnchorAndSOAnd(Boolean holdAnchorAndSO) {
        this.holdAnchorAndSO = holdAnchorAndSO;
        return this;
    }

    public VertRelTo vertRelTo() {
        return vertRelTo;
    }

    public void vertRelTo(VertRelTo vertRelTo) {
        this.vertRelTo = vertRelTo;
    }

    public ShapePosition vertRelToAnd(VertRelTo vertRelTo) {
        this.vertRelTo = vertRelTo;
        return this;
    }

    public HorzRelTo horzRelTo() {
        return horzRelTo;
    }

    public void horzRelTo(HorzRelTo horzRelTo) {
        this.horzRelTo = horzRelTo;
    }

    public ShapePosition horzRelToAnd(HorzRelTo horzRelTo) {
        this.horzRelTo = horzRelTo;
        return this;
    }

    public VertAlign vertAlign() {
        return vertAlign;
    }

    public void vertAlign(VertAlign vertAlign) {
        this.vertAlign = vertAlign;
    }

    public ShapePosition vertAlignAnd(VertAlign vertAlign) {
        this.vertAlign = vertAlign;
        return this;
    }

    public HorzAlign horzAlign() {
        return horzAlign;
    }

    public void horzAlign(HorzAlign horzAlign) {
        this.horzAlign = horzAlign;
    }

    public ShapePosition horzAlignAnd(HorzAlign horzAlign) {
        this.horzAlign = horzAlign;
        return this;
    }

    public Integer vertOffset() {
        return vertOffset;
    }

    public void vertOffset(Integer vertOffset) {
        this.vertOffset = vertOffset;
    }

    public ShapePosition vertOffsetAnd(Integer vertOffset) {
        this.vertOffset = vertOffset;
        return this;
    }

    public Integer horzOffset() {
        return horzOffset;
    }

    public void horzOffset(Integer horzOffset) {
        this.horzOffset = horzOffset;
    }

    public ShapePosition horzOffsetAnd(Integer horzOffset) {
        this.horzOffset = horzOffset;
        return this;
    }
}
