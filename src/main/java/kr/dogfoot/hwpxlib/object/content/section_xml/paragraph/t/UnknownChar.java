package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.t;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.TItem;

/**
 * 알 수 없는 문자(?)
 */
public class UnknownChar extends TItem {
    private Long unknownChar;

    public UnknownChar() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_unknownch;
    }

    public Long unknownChar() {
        return unknownChar;
    }

    public void unknownChar(Long unknownChar) {
        this.unknownChar = unknownChar;
    }

    public UnknownChar unknownCharAnd(Long unknownChar) {
        this.unknownChar = unknownChar;
        return this;
    }

    @Override
    public HWPXObject clone() {
        UnknownChar cloned = new UnknownChar();
        cloned.copyFrom(this);
        return cloned;
    }

    private void copyFrom(UnknownChar from) {
        this.unknownChar = from.unknownChar;
    }
}
