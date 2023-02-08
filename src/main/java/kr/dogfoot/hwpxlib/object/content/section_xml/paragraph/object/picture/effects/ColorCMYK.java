package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.picture.effects;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;

/**
 * CMYK 색상
 */
public class ColorCMYK extends HWPXObject {
    private Short c;
    private Short m;
    private Short y;
    private Short k;

    public ColorCMYK() {
    }

    @Override
    public ObjectType objectType() {
        return ObjectType.ColorCMYK;
    }

    public Short c() {
        return c;
    }

    public void c(Short c) {
        this.c = c;
    }

    public ColorCMYK cAnd(Short c) {
        this.c = c;
        return this;
    }

    public Short m() {
        return m;
    }

    public void m(Short m) {
        this.m = m;
    }

    public ColorCMYK mAnd(Short m) {
        this.m = m;
        return this;
    }

    public Short y() {
        return y;
    }

    public void y(Short y) {
        this.y = y;
    }

    public ColorCMYK yAnd(Short y) {
        this.y = y;
        return this;
    }

    public Short k() {
        return k;
    }

    public void k(Short k) {
        this.k = k;
    }

    public ColorCMYK kAnd(Short k) {
        this.k = k;
        return this;
    }
}
