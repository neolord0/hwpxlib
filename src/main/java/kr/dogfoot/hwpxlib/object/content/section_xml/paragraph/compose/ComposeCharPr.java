package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.compose;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;

/**
 * 글자모양 아이디 참조
 */
public class ComposeCharPr extends HWPXObject {
    /**
     * 글자모양 아이디 참조값
     */
    private String prIDRef;

    public ComposeCharPr() {
    }

    @Override
    public ObjectType objectType() {
        return ObjectType.ComposeCharPr;
    }

    public String prIDRef() {
        return prIDRef;
    }

    public void prIDRef(String prIDRef) {
        this.prIDRef = prIDRef;
    }

    public ComposeCharPr prIDRefAnd(String prIDRef) {
        this.prIDRef = prIDRef;
        return this;
    }
}
