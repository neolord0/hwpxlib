package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.shapecomponent;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;

/**
 * 뒤집힌 상태
 */
public class Flip extends HWPXObject {
    /**
     * 수평 방향으로 뒤집혔는지 여부
     */
    private Boolean horizontal;
    /**
     * 수직 방향으로 뒤집혔는지 여부
     */
    private Boolean vertical;

    public Flip() {
    }

    @Override
    public ObjectType objectType() {
        return ObjectType.Flip;
    }

    public Boolean horizontal() {
        return horizontal;
    }

    public void horizontal(Boolean horizontal) {
        this.horizontal = horizontal;
    }

    public Flip horizontalAnd(Boolean horizontal) {
        this.horizontal = horizontal;
        return this;
    }

    public Boolean vertical() {
        return vertical;
    }

    public void vertical(Boolean vertical) {
        this.vertical = vertical;
    }

    public Flip verticalAnd(Boolean vertical) {
        this.vertical = vertical;
        return this;
    }
}
