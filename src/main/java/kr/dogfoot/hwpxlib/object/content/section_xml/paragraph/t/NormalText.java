package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.t;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.TItem;

public class NormalText extends TItem {
    private String text;

    public NormalText() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.NormalText;
    }

    public String text() {
        return text;
    }

    public void text(String text) {
        this.text = text;
    }

    public NormalText textAnd(String text) {
        this.text = text;
        return this;
    }

    @Override
    public NormalText clone() {
        NormalText cloned = new NormalText();
        cloned.copyFrom(this);
        return cloned;
    }

    public void copyFrom(NormalText from) {
        this.text = from.text;
    }
}
