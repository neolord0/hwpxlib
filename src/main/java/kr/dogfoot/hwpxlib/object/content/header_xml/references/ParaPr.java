package kr.dogfoot.hwpxlib.object.content.header_xml.references;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.parapr.*;

/**
 * 문단 모양
 */
public class ParaPr extends SwitchableObject {
    /**
     * 아이디
     */
    private String id;
    /**
     * 탭정의 아이디 참조값
     */
    private String tabPrIDRef;
    /**
     * 공백 최소값(최소 공백), 단위는 %, 0~75
     */
    private Byte condense;
    /**
     * 글꼴에 어울리는 줄 높이 적용 여부
     */
    private Boolean fontLineHeight;
    /**
     * 편집 용지의 줄 격자 사용 여부
     */
    private Boolean snapToGrid;
    /**
     * 줄 번호 건너뜀 여부
     */
    private Boolean suppressLineNumbers;
    /**
     * ??, 선택 글머리표 여부
     */
    private Boolean checked;
    /**
     * 문단 정렬
     */
    private Align align;
    /**
     * 문단 머리 번호/글머리표
     */
    private Heading heading;
    /**
     * 줄나눔 설정
     */
    private BreakSetting breakSetting;
    /**
     * 여백
     */
    private ParaMargin margin;
    /**
     * 줄간격
     */
    private LineSpacing lineSpacing;
    /**
     * 문단 테두리
     */
    private ParaBorder border;
    /**
     * 문단 자동 간격 조정
     */
    private AutoSpacing autoSpacing;

    public ParaPr() {
    }

    @Override
    public ObjectType objectType() {
        return ObjectType.ParaPr;
    }

    @Override
    public HWPXObject createChildWithElementName(String name) {
        if (ObjectType.Align.equalElementName(name)) {
            return new Align();
        } else if (ObjectType.Heading.equalElementName(name)) {
            return new Heading();
        } else if (ObjectType.BreakSetting.equalElementName(name)) {
            return new BreakSetting();
        } else if (ObjectType.ParaMargin.equalElementName(name)) {
            return new ParaMargin();
        } else if (ObjectType.LineSpacing.equalElementName(name)) {
            return new LineSpacing();
        } else if (ObjectType.ParaBorder.equalElementName(name)) {
            return new ParaBorder();
        } else if (ObjectType.AutoSpacing.equalElementName(name)) {
            return new AutoSpacing();
        }
        return null;
    }

    public String id() {
        return id;
    }

    public void id(String id) {
        this.id = id;
    }

    public ParaPr idAnd(String id) {
        this.id = id;
        return this;
    }

    public String tabPrIDRef() {
        return tabPrIDRef;
    }

    public void tabPrIDRef(String tabPrIDRef) {
        this.tabPrIDRef = tabPrIDRef;
    }

    public ParaPr tabPrIDRefAnd(String tabPrIDRef) {
        this.tabPrIDRef = tabPrIDRef;
        return this;
    }

    public Byte condense() {
        return condense;
    }

    public void condense(Byte condense) {
        this.condense = condense;
    }

    public ParaPr condenseAnd(Byte condense) {
        this.condense = condense;
        return this;
    }

    public Boolean fontLineHeight() {
        return fontLineHeight;
    }

    public void fontLineHeight(Boolean fontLineHeight) {
        this.fontLineHeight = fontLineHeight;
    }

    public ParaPr fontLineHeightAnd(Boolean fontLineHeight) {
        this.fontLineHeight = fontLineHeight;
        return this;
    }

    public Boolean snapToGrid() {
        return snapToGrid;
    }

    public void snapToGrid(Boolean snapToGrid) {
        this.snapToGrid = snapToGrid;
    }

    public ParaPr snapToGridAnd(Boolean snapToGrid) {
        this.snapToGrid = snapToGrid;
        return this;
    }

    public Boolean suppressLineNumbers() {
        return suppressLineNumbers;
    }

    public void suppressLineNumbers(Boolean suppressLineNumbers) {
        this.suppressLineNumbers = suppressLineNumbers;
    }

    public ParaPr suppressLineNumbersAnd(Boolean suppressLineNumbers) {
        this.suppressLineNumbers = suppressLineNumbers;
        return this;
    }

    public Boolean checked() {
        return checked;
    }

    public void checked(Boolean checked) {
        this.checked = checked;
    }

    public ParaPr checkedAnd(Boolean checked) {
        this.checked = checked;
        return this;
    }

    public Align align() {
        return align;
    }

    public void createAlign() {
        align = new Align();
    }

    public void removeAlign() {
        align = null;
    }

    public Heading heading() {
        return heading;
    }

    public void createHeading() {
        heading = new Heading();
    }

    public void removeHeading() {
        heading = new Heading();
    }

    public BreakSetting breakSetting() {
        return breakSetting;
    }

    public void createBreakSetting() {
        breakSetting = new BreakSetting();
    }

    public void removeBreakSetting() {
        breakSetting = null;
    }

    public ParaMargin margin() {
        return margin;
    }

    public void createMargin() {
        margin = new ParaMargin();
    }

    public void removeMargin() {
        margin = null;
    }

    public LineSpacing lineSpacing() {
        return lineSpacing;
    }

    public void createLineSpacing() {
        lineSpacing = new LineSpacing();
    }

    public void removeLineSpacing() {
        lineSpacing = null;
    }

    public ParaBorder border() {
        return border;
    }

    public void createBorder() {
        border = new ParaBorder();
    }

    public void removeBorder() {
        border = null;
    }

    public AutoSpacing autoSpacing() {
        return autoSpacing;
    }

    public void createAutoSpacing() {
        autoSpacing = new AutoSpacing();
    }

    public void removeAutoSpacing() {
        autoSpacing = null;
    }
}
