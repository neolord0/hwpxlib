package kr.dogfoot.hwpxlib.object.content.header_xml.references.borderfill;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.SlashType;

/**
 * 대각선 정보
 */
public class SlashCore extends HWPXObject {
    private final ObjectType _objectType;
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

    public SlashCore(ObjectType _objectType) {
        this._objectType = _objectType;
    }

    @Override
    public ObjectType _objectType() {
        return _objectType;
    }

    public SlashType type() {
        return type;
    }

    public void type(SlashType type) {
        this.type = type;
    }

    public SlashCore typeAnd(SlashType type) {
        this.type = type;
        return this;
    }

    public Boolean Crooked() {
        return Crooked;
    }

    public void Crooked(Boolean Crooked) {
        this.Crooked = Crooked;
    }

    public SlashCore CrookedAnd(Boolean Crooked) {
        this.Crooked = Crooked;
        return this;
    }

    public Boolean isCounter() {
        return isCounter;
    }

    public void isCounter(Boolean isCounter) {
        this.isCounter = isCounter;
    }

    public SlashCore isCounterAnd(Boolean isCounter) {
        this.isCounter = isCounter;
        return this;
    }

    @Override
    public SlashCore clone() {
        SlashCore cloned = new SlashCore(_objectType);
        cloned.copyFrom(this);
        return cloned;
    }

    public void copyFrom(SlashCore from) {
        this.type = from.type;
        this.Crooked = from.Crooked;
        this.isCounter = from.isCounter;
    }
}
