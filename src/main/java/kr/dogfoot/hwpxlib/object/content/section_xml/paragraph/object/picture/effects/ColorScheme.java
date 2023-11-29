package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.picture.effects;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;

/**
 * 스키마 색상
 */
public class ColorScheme extends HWPXObject {
    private Short r;
    private Short g;
    private Short b;

    public ColorScheme() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_scheme;
    }

    public Short r() {
        return r;
    }

    public void r(Short r) {
        this.r = r;
    }

    public ColorScheme rAnd(Short r) {
        this.r = r;
        return this;
    }

    public Short g() {
        return g;
    }

    public void g(Short g) {
        this.g = g;
    }

    public ColorScheme gAnd(Short g) {
        this.g = g;
        return this;
    }

    public Short b() {
        return b;
    }

    public void b(Short b) {
        this.b = b;
    }

    public ColorScheme bAnd(Short b) {
        this.b = b;
        return this;
    }

    @Override
    public ColorScheme clone() {
        ColorScheme cloned = new ColorScheme();
        cloned.copyFrom(this);
        return cloned;
    }

    public void copyFrom(ColorScheme from) {
        this.r = from.r;
        this.g = from.g;
        this.b = from.b;
    }
}
