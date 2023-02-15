package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.picture.effects;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;

/**
 * 스키마 색상
 */
public class ColorSchema extends HWPXObject {
    private Short r;
    private Short g;
    private Short b;

    public ColorSchema() {
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

    public ColorSchema rAnd(Short r) {
        this.r = r;
        return this;
    }

    public Short g() {
        return g;
    }

    public void g(Short g) {
        this.g = g;
    }

    public ColorSchema gAnd(Short g) {
        this.g = g;
        return this;
    }

    public Short b() {
        return b;
    }

    public void b(Short b) {
        this.b = b;
    }

    public ColorSchema bAnd(Short b) {
        this.b = b;
        return this;
    }
}
