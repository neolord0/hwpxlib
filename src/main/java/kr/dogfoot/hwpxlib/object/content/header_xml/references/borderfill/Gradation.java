package kr.dogfoot.hwpxlib.object.content.header_xml.references.borderfill;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.GradationType;

import java.util.ArrayList;

/**
 * 그라데이션 채우기 정보
 */
public class Gradation extends SwitchableObject {
    /**
     * 그라데이션 유형
     */
    private GradationType type;
    /**
     * 기울임(시작각)
     */
    private Integer angle;
    /**
     * 가로중심
     */
    private Integer centerX;
    /**
     * 세로중심
     */
    private Integer centerY;
    /**
     * 번짐 정도
     */
    private Short step;
    /**
     * 번짐 정도의 중심
     */
    private Short stepCenter;
    /**
     * 투명도
     */
    private Float alpha;
    /**
     * 색상 리스트
     */
    private final ArrayList<Color> colorList;

    public Gradation() {
        colorList = new ArrayList<Color>();
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hc_gradation;
    }

    public GradationType type() {
        return type;
    }

    public void type(GradationType type) {
        this.type = type;
    }

    public Gradation typeAnd(GradationType type) {
        this.type = type;
        return this;
    }

    public Integer angle() {
        return angle;
    }

    public void angle(Integer angle) {
        this.angle = angle;
    }

    public Gradation angleAnd(Integer angle) {
        this.angle = angle;
        return this;
    }

    public Integer centerX() {
        return centerX;
    }

    public void centerX(Integer centerX) {
        this.centerX = centerX;
    }

    public Gradation centerXAnd(Integer centerX) {
        this.centerX = centerX;
        return this;
    }

    public Integer centerY() {
        return centerY;
    }

    public void centerY(Integer centerY) {
        this.centerY = centerY;
    }

    public Gradation centerYAnd(Integer centerY) {
        this.centerY = centerY;
        return this;
    }

    public Short step() {
        return step;
    }

    public void step(Short step) {
        this.step = step;
    }

    public Gradation stepAnd(Short step) {
        this.step = step;
        return this;
    }

    public int colorNum() {
        return colorList.size();
    }

    public Short stepCenter() {
        return stepCenter;
    }

    public void stepCenter(Short stepCenter) {
        this.stepCenter = stepCenter;
    }

    public Gradation stepCenterAnd(Short stepCenter) {
        this.stepCenter = stepCenter;
        return this;
    }

    public Float alpha() {
        return alpha;
    }

    public void alpha(Float alpha) {
        this.alpha = alpha;
    }

    public Gradation alphaAnd(Float alpha) {
        this.alpha = alpha;
        return this;
    }

    public int countOfColor() {
        return colorList.size();
    }

    public Color getColor(int index) {
        return colorList.get(index);
    }

    public int getColorIndex(Color color) {
        int count = colorList.size();
        for (int index = 0; index < count; index++) {
            if (colorList.get(index) == color) {
                return index;
            }
        }
        return -1;
    }

    public void addColor(Color color) {
        colorList.add(color);
    }

    public Color addNewColor() {
        Color color = new Color();
        colorList.add(color);
        return color;
    }

    public void insertColor(Color color, int position) {
        colorList.add(position, color);
    }

    public void removeColor(int position) {
        colorList.remove(position);
    }

    public Iterable<Color> colors() {
        return colorList;
    }
}
