package kr.dogfoot.hwpxlib.object.content.header_xml.references.borderfill;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.SlashType;

/**
 * 대각선 정보
 */
public abstract class SlashCore<ChildType> extends HWPXObject {
    /**
     * 모먕
     */
    private SlashType type;
    /**
     * 꺾인 대각선인지 여부
     */
    private Boolean Crooked;
    /**
     * 역뱡항 여부
     */
    private Boolean isCounter;

    public SlashType type() {
        return type;
    }

    public void type(SlashType type) {
        this.type = type;
    }

    public ChildType typeAnd(SlashType type) {
        this.type = type;
        return (ChildType) this;
    }

    public Boolean Crooked() {
        return Crooked;
    }

    public void Crooked(Boolean Crooked) {
        this.Crooked = Crooked;
    }

    public ChildType CrookedAnd(Boolean Crooked) {
        this.Crooked = Crooked;
        return (ChildType) this;
    }

    public Boolean isCounter() {
        return isCounter;
    }

    public void isCounter(Boolean isCounter) {
        this.isCounter = isCounter;
    }

    public ChildType isCounterAnd(Boolean isCounter) {
        this.isCounter = isCounter;
        return (ChildType) this;
    }
}
