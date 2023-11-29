package kr.dogfoot.hwpxlib.object.content.header_xml.references;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.CenterLineSort;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.borderfill.Border;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.borderfill.FillBrush;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.borderfill.SlashCore;

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
    private SlashCore slash;
    /**
     * 역방향 대각선 정보
     */
    private SlashCore backSlash;
    /**
     * 왼쪽 테두리
     */
    private Border leftBorder;
    /**
     * 오른쪽 테두리
     */
    private Border rightBorder;
    /**
     * 위쪽 테두리
     */
    private Border topBorder;
    /**
     * 아래쪽 테두리
     */
    private Border bottomBorder;
    /**
     * 대각선
     */
    private Border diagonal;
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

    public SlashCore slash() {
        return slash;
    }

    public void createSlash() {
        slash = new SlashCore(ObjectType.hh_slash);
    }

    public void removeSlash() {
        slash = null;
    }

    public SlashCore backSlash() {
        return backSlash;
    }

    public void createBackSlash() {
        backSlash = new SlashCore(ObjectType.hh_backSlash);
    }

    public void removeBackSlash() {
        backSlash = null;
    }

    public Border leftBorder() {
        return leftBorder;
    }

    public void createLeftBorder() {
        leftBorder = new Border(ObjectType.hh_leftBorder);
    }

    public void removeLeftBorder() {
        leftBorder = null;
    }

    public Border rightBorder() {
        return rightBorder;
    }

    public void createRightBorder() {
        rightBorder = new Border(ObjectType.hh_rightBorder);
    }

    public void removeRightBorder() {
        rightBorder = null;
    }

    public Border topBorder() {
        return topBorder;
    }

    public void createTopBorder() {
        topBorder = new Border(ObjectType.hh_topBorder);
    }

    public void removeTopBorder() {
        topBorder = null;
    }

    public Border bottomBorder() {
        return bottomBorder;
    }

    public void createBottomBorder() {
        bottomBorder = new Border(ObjectType.hh_bottomBorder);
    }

    public void removeBottomBorder() {
        bottomBorder = null;
    }

    public Border diagonal() {
        return diagonal;
    }

    public void createDiagonal() {
        diagonal = new Border(ObjectType.hh_diagonal);
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

    @Override
    public BorderFill clone() {
        BorderFill cloned = new BorderFill();
        cloned.copyFrom(this);
        return cloned;
    }


    public void copyFrom(BorderFill from) {
        this.id = from.id;
        this.threeD = from.threeD;
        this.shadow = from.shadow;
        this.centerLine = from.centerLine;
        this.breakCellSeparateLine = from.breakCellSeparateLine;

        if (from.slash != null) {
            slash = from.slash.clone();
        } else {
            slash = null;
        }

        if (from.backSlash != null) {
            backSlash = from.backSlash.clone();
        } else {
            backSlash = null;
        }

        if (from.leftBorder != null) {
            leftBorder = from.leftBorder.clone();
        } else {
            leftBorder = null;
        }

        if (from.rightBorder != null) {
            rightBorder = from.rightBorder.clone();
        } else {
            rightBorder = null;
        }

        if (from.topBorder != null) {
            topBorder = from.topBorder.clone();
        } else {
            topBorder = null;
        }

        if (from.bottomBorder != null) {
            bottomBorder = from.bottomBorder.clone();
        } else {
            bottomBorder = null;
        }

        if (from.diagonal != null) {
            diagonal = from.diagonal.clone();
        } else {
            diagonal = null;
        }

        if (from.fillBrash != null) {
            fillBrash = from.fillBrash.clone();
        } else {
            fillBrash = null;
        }

        super.copyFrom(from);
    }
}
