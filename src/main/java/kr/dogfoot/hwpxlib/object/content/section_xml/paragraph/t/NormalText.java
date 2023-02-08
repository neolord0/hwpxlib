package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.t;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.TItem;

public class NormalText extends TItem {
    private String text;

    public NormalText() {
    }

    @Override
    public ObjectType objectType() {
        return null;
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
}
