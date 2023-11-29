package kr.dogfoot.hwpxlib.object.content.context_hpf;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;

public class Meta extends HWPXObject {
    private String name;
    private String content;
    private String text;

    public Meta() {
    }

    public Meta(String name, String content, String text) {
        this.name = name;
        this.content = content;
        this.text = text;
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.opf_meta;
    }

    public String name() {
        return name;
    }

    public void name(String name) {
        this.name = name;
    }

    public Meta nameAnd(String name) {
        this.name = name;
        return this;
    }

    public String content() {
        return content;
    }

    public void content(String content) {
        this.content = content;
    }

    public Meta contentAnd(String content) {
        this.content = content;
        return this;
    }

    public String text() {
        return text;
    }

    public void text(String text) {
        this.text = text;
    }

    public Meta textAnd(String text) {
        this.text = text;
        return this;
    }

    @Override
    public Meta clone() {
        Meta cloned = new Meta();
        cloned.copyFrom(this);
        return cloned;
    }

    public void copyFrom(Meta from) {
        this.name = from.name;
        this.content = from.content;
        this.text = from.text;
    }
}

