package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.picture.effects;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;

/**
 * 시스템 색상
 */
public class ColorSystem extends HWPXObject {
    private Short h;
    private Short s;
    private Short l;

    public ColorSystem() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_system;
    }

    public Short h() {
        return h;
    }

    public void h(Short h) {
        this.h = h;
    }

    public ColorSystem hAnd(Short h) {
        this.h = h;
        return this;
    }

    public Short s() {
        return s;
    }

    public void s(Short s) {
        this.s = s;
    }

    public ColorSystem sAnd(Short s) {
        this.s = s;
        return this;
    }

    public Short l() {
        return l;
    }

    public void l(Short l) {
        this.l = l;
    }

    public ColorSystem lAnd(Short l) {
        this.l = l;
        return this;
    }

    @Override
    public ColorSystem clone() {
        ColorSystem cloned = new ColorSystem();
        cloned.copyFrom(this);
        return cloned;
    }

    public void copyFrom(ColorSystem from) {
        this.h = from.h;
        this.s = from.s;
        this.l = from.l;
    }
}
