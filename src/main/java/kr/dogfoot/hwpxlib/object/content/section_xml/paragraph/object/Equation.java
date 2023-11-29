package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.baseobject.HasOnlyText;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.EquationLineMode;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapeobject.ShapeObject;

/**
 * 수식
 */
public class Equation extends ShapeObject<Equation> {
    /**
     * 수식 버전
     */
    private String version;
    /**
     * 수식이 그려질 기본 선의 위치
     */
    private Integer baseLine;
    /**
     * 글자색
     */
    private String textColor;
    /**
     * 수식 글자의 크기, 단위는 hwpunit
     */
    private Integer baseUnit;
    /**
     * 수식이 차지하는 범위
     */
    private EquationLineMode lineMode;
    /**
     * 수식 폰트명
     */
    private String font;
    /**
     * 수식 내용
     */
    private HasOnlyText script;

    public Equation() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_equation;
    }

    public String version() {
        return version;
    }

    public void version(String version) {
        this.version = version;
    }

    public Equation versionAnd(String version) {
        this.version = version;
        return this;
    }

    public Integer baseLine() {
        return baseLine;
    }

    public void baseLine(Integer baseLine) {
        this.baseLine = baseLine;
    }

    public Equation baseLineAnd(Integer baseLine) {
        this.baseLine = baseLine;
        return this;
    }

    public String textColor() {
        return textColor;
    }

    public void textColor(String textColor) {
        this.textColor = textColor;
    }

    public Equation textColorAnd(String textColor) {
        this.textColor = textColor;
        return this;
    }

    public Integer baseUnit() {
        return baseUnit;
    }

    public void baseUnit(Integer baseUnit) {
        this.baseUnit = baseUnit;
    }

    public Equation baseUnitAnd(Integer baseUnit) {
        this.baseUnit = baseUnit;
        return this;
    }

    public EquationLineMode lineMode() {
        return lineMode;
    }

    public void lineMode(EquationLineMode lineMode) {
        this.lineMode = lineMode;
    }

    public Equation lineModeAnd(EquationLineMode lineMode) {
        this.lineMode = lineMode;
        return this;
    }

    public String font() {
        return font;
    }

    public void font(String font) {
        this.font = font;
    }

    public Equation fontAnd(String font) {
        this.font = font;
        return this;
    }

    public HasOnlyText script() {
        return script;
    }

    public void createScript() {
        script = new HasOnlyText(ObjectType.hp_script);
    }

    public void removeScript() {
        script = null;
    }

    @Override
    public Equation clone() {
        Equation cloned = new Equation();
        cloned.copyFrom(this);
        return cloned;
    }

    public void copyFrom(Equation from) {
        this.version = from.version;
        this.baseLine = from.baseLine;
        this.textColor = from.textColor;
        this.baseUnit = from.baseUnit;
        this.lineMode = from.lineMode;
        this.font = from.font;

        if (from.script != null) {
            script = from.script.clone();
        } else {
            script = null;
        }

        super.copyFrom(from);
    }
}
