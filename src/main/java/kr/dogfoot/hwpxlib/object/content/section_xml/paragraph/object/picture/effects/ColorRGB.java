package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.picture.effects;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;

/**
 * RGB 색상
 */
public class ColorRGB extends HWPXObject {
    private Short r;
    private Short g;
    private Short b;

    public ColorRGB() {
    }

    @Override
    public ObjectType objectType() {
        return ObjectType.ColorRGB;
    }

    public Short r() {
        return r;
    }

    public void r(Short r) {
        this.r = r;
    }

    public ColorRGB rAnd(Short r) {
        this.r = r;
        return this;
    }

    public Short g() {
        return g;
    }

    public void g(Short g) {
        this.g = g;
    }

    public ColorRGB gAnd(Short g) {
        this.g = g;
        return this;
    }

    public Short b() {
        return b;
    }

    public void b(Short b) {
        this.b = b;
    }

    public ColorRGB bAnd(Short b) {
        this.b = b;
        return this;
    }
}
