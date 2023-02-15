package kr.dogfoot.hwpxlib.object.content.header_xml.references;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.CenterLineSort;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.borderfill.*;

/**
 * BorderFill
 */
public class BorderFill extends SwitchableObject {
    /**
     * 아이디
     */
    private String id;
    /**
     * 3D 효과
     */
    private Boolean threeD;
    /**
     * 그림자 효과
     */
    private Boolean shadow;
    /**
     * 중심선 종류
     */
    private CenterLineSort centerLine;
    /**
     * 자동으로 나뉜 표의 경계선 설정 여부
     */
    private Boolean breakCellSeparateLine;
    /**
     * 대각선 정보
     */
    private Slash slash;
    /**
     * 역방향 대각선 정보
     */
    private BackSlash backSlash;
    /**
     * 왼쪽 테두리
     */
    private LeftBorder leftBorder;
    /**
     * 오른쪽 테두리
     */
    private RightBorder rightBorder;
    /**
     * 위쪽 테두리
     */
    private TopBorder topBorder;
    /**
     * 아래쪽 테두리
     */
    private BottomBorder bottomBorder;
    /**
     * 대각선
     */
    private DiagonalBorder diagonal;
    /**
     * 채우기 정보
     */
    private FillBrush fillBrash;

    public BorderFill() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hh_borderFill;
    }

    public String id() {
        return id;
    }

    public void id(String id) {
        this.id = id;
    }

    public BorderFill idAnd(String id) {
        this.id = id;
        return this;
    }

    public Boolean threeD() {
        return threeD;
    }

    public void threeD(Boolean threeD) {
        this.threeD = threeD;
    }

    public BorderFill threeDAnd(Boolean threeD) {
        this.threeD = threeD;
        return this;
    }

    public Boolean shadow() {
        return shadow;
    }

    public void shadow(Boolean shadow) {
        this.shadow = shadow;
    }

    public BorderFill shadowAnd(Boolean shadow) {
        this.shadow = shadow;
        return this;
    }

    public CenterLineSort centerLine() {
        return centerLine;
    }

    public void centerLine(CenterLineSort centerLine) {
        this.centerLine = centerLine;
    }

    public BorderFill centerLineAnd(CenterLineSort centerLine) {
        this.centerLine = centerLine;
        return this;
    }

    public Boolean breakCellSeparateLine() {
        return breakCellSeparateLine;
    }

    public void breakCellSeparateLine(Boolean breakCellSeparateLine) {
        this.breakCellSeparateLine = breakCellSeparateLine;
    }

    public BorderFill breakCellSeparateLineAnd(Boolean breakCellSeparateLine) {
        this.breakCellSeparateLine = breakCellSeparateLine;
        return this;
    }

    public Slash slash() {
        return slash;
    }

    public void createSlash() {
        slash = new Slash();
    }

    public void removeSlash() {
        slash = null;
    }

    public BackSlash backSlash() {
        return backSlash;
    }

    public void createBackSlash() {
        backSlash = new BackSlash();
    }

    public void removeBackSlash() {
        backSlash = null;
    }

    public LeftBorder leftBorder() {
        return leftBorder;
    }

    public void createLeftBorder() {
        leftBorder = new LeftBorder();
    }

    public void removeLeftBorder() {
        leftBorder = null;
    }

    public RightBorder rightBorder() {
        return rightBorder;
    }

    public void createRightBorder() {
        rightBorder = new RightBorder();
    }

    public void removeRightBorder() {
        rightBorder = null;
    }

    public TopBorder topBorder() {
        return topBorder;
    }

    public void createTopBorder() {
        topBorder = new TopBorder();
    }

    public void removeTopBorder() {
        topBorder = null;
    }

    public BottomBorder bottomBorder() {
        return bottomBorder;
    }

    public void createBottomBorder() {
        bottomBorder = new BottomBorder();
    }

    public void removeBottomBorder() {
        bottomBorder = null;
    }

    public DiagonalBorder diagonal() {
        return diagonal;
    }

    public void createDiagonal() {
        diagonal = new DiagonalBorder();
    }

    public void removeDiagonal() {
        diagonal = null;
    }

    public FillBrush fillBrush() {
        return fillBrash;
    }

    public void createFillBrush() {
        fillBrash = new FillBrush();
    }

    public void removeFillBrush() {
        fillBrash = null;
    }
}
