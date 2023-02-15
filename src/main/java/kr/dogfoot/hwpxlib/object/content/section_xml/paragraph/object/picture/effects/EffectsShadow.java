package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.picture.effects;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.AlignStyleType;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.ShadowStyle;

/**
 * 그림자 효과
 */
public class EffectsShadow extends SwitchableObject {
    /**
     * 그림자 스타일
     */
    private ShadowStyle style;
    /**
     * 시작 투명도
     */
    private Float alpha;
    /**
     * 흐릿한 정도, 단위는 hwpunit
     */
    private Float radius;
    /**
     * 방향 각도(0~360)
     */
    private Short direction;
    /**
     * 그림자와의 간격, 단위는 hwpunit
     */
    private Float distance;
    /**
     * 그림자 정렬
     */
    private AlignStyleType alignStyle;
    /**
     * 도형과 함께 회전 여부
     */
    private Boolean rotationStyle;
    /**
     * 기울기
     */
    private Skew skew;
    /**
     * 확대/축소 비율
     */
    private Scale scale;
    /**
     * 그림자 색
     */
    private EffectsColor effectsColor;

    public EffectsShadow() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_shadow_for_effects;
    }

    public ShadowStyle style() {
        return style;
    }

    public void style(ShadowStyle style) {
        this.style = style;
    }

    public EffectsShadow styleAnd(ShadowStyle style) {
        this.style = style;
        return this;
    }

    public Float alpha() {
        return alpha;
    }

    public void alpha(Float alpha) {
        this.alpha = alpha;
    }

    public EffectsShadow alphaAnd(Float alpha) {
        this.alpha = alpha;
        return this;
    }

    public Float radius() {
        return radius;
    }

    public void radius(Float radius) {
        this.radius = radius;
    }

    public EffectsShadow radiusAnd(Float radius) {
        this.radius = radius;
        return this;
    }

    public Short direction() {
        return direction;
    }

    public void direction(Short direction) {
        this.direction = direction;
    }

    public EffectsShadow directionAnd(Short direction) {
        this.direction = direction;
        return this;
    }

    public Float distance() {
        return distance;
    }

    public void distance(Float distance) {
        this.distance = distance;
    }

    public EffectsShadow distanceAnd(Float distance) {
        this.distance = distance;
        return this;
    }

    public AlignStyleType alignStyle() {
        return alignStyle;
    }

    public void alignStyle(AlignStyleType alignStyle) {
        this.alignStyle = alignStyle;
    }

    public EffectsShadow alignStyleAnd(AlignStyleType alignStyle) {
        this.alignStyle = alignStyle;
        return this;
    }

    public Boolean rotationStyle() {
        return rotationStyle;
    }

    public void rotationStyle(Boolean rotationStyle) {
        this.rotationStyle = rotationStyle;
    }

    public EffectsShadow rotationStyleAnd(Boolean rotationStyle) {
        this.rotationStyle = rotationStyle;
        return this;
    }

    public Skew skew() {
        return skew;
    }

    public void createSkew() {
        skew = new Skew();
    }

    public void removeSkew() {
        skew = null;
    }

    public Scale scale() {
        return scale;
    }

    public void createScale() {
        scale = new Scale();
    }

    public void removeScale() {
        scale = null;
    }

    public EffectsColor effectsColor() {
        return effectsColor;
    }

    public void createEffectsColor() {
        effectsColor = new EffectsColor();
    }

    public void removeEffectsColor() {
        effectsColor = null;
    }
}
