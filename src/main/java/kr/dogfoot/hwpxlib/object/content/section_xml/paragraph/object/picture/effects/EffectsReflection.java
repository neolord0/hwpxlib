package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.picture.effects;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.common.baseobject.StartAndEndFloat;
import kr.dogfoot.hwpxlib.object.common.baseobject.XAndYFloat;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.AlignStyleType;

/**
 * 반사 효과
 */
public class EffectsReflection extends SwitchableObject {
    /**
     * 반사된 그림 위치
     */
    private AlignStyleType alignStyle;
    /**
     * 흐릿한 정도, 단위는 hwpunit
     */
    private Float radius;
    /**
     * 반사된 그림 방향 각도(0~360)
     */
    private Integer direction;
    /**
     * 반사된 그림과의 간격, 단위는 hwpunit
     */
    private Float distance;
    /**
     * 도형과 함께 회전 여부
     */
    private Boolean rotationStyle;
    /**
     * 오프셋 방향 각도(0~360)
     */
    private Integer fadeDirection;
    /**
     * 기울기
     */
    private XAndYFloat skew;
    /**
     * 확대/축소 비율
     */
    private XAndYFloat scale;
    /**
     * 투명도
     */
    private StartAndEndFloat alpha;
    /**
     * 위치
     */
    private StartAndEndFloat pos;

    public EffectsReflection() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_reflection;
    }

    public AlignStyleType alignStyle() {
        return alignStyle;
    }

    public void alignStyle(AlignStyleType alignStyle) {
        this.alignStyle = alignStyle;
    }

    public EffectsReflection alignStyleAnd(AlignStyleType alignStyle) {
        this.alignStyle = alignStyle;
        return this;
    }

    public Float radius() {
        return radius;
    }

    public void radius(Float radius) {
        this.radius = radius;
    }

    public EffectsReflection radiusAnd(Float radius) {
        this.radius = radius;
        return this;
    }

    public Integer direction() {
        return direction;
    }

    public void direction(Integer direction) {
        this.direction = direction;
    }

    public EffectsReflection directionAnd(Integer direction) {
        this.direction = direction;
        return this;
    }

    public Float distance() {
        return distance;
    }

    public void distance(Float distance) {
        this.distance = distance;
    }

    public EffectsReflection distanceAnd(Float distance) {
        this.distance = distance;
        return this;
    }

    public Boolean rotationStyle() {
        return rotationStyle;
    }

    public void rotationStyle(Boolean rotationStyle) {
        this.rotationStyle = rotationStyle;
    }

    public EffectsReflection rotationStyleAnd(Boolean rotationStyle) {
        this.rotationStyle = rotationStyle;
        return this;
    }

    public Integer fadeDirection() {
        return fadeDirection;
    }

    public void fadeDirection(Integer fadeDirection) {
        this.fadeDirection = fadeDirection;
    }

    public EffectsReflection fadeDirectionAnd(Integer fadeDirection) {
        this.fadeDirection = fadeDirection;
        return this;
    }

    public XAndYFloat skew() {
        return skew;
    }

    public void createSkew() {
        skew = new XAndYFloat(ObjectType.hp_skew);
    }

    public void removeSkew() {
        skew = null;
    }

    public XAndYFloat scale() {
        return scale;
    }

    public void createScale() {
        scale = new XAndYFloat(ObjectType.hp_scale);
    }

    public void removeScale() {
        scale = null;
    }

    public StartAndEndFloat alpha() {
        return alpha;
    }

    public void createAlpha() {
        alpha = new StartAndEndFloat(ObjectType.hp_alpha);
    }

    public void removeAlpha() {
        alpha = null;
    }

    public StartAndEndFloat pos() {
        return pos;
    }

    public void createPos() {
        pos = new StartAndEndFloat(ObjectType.hp_pos);
    }

    public void removePos() {
        pos = null;
    }
}
