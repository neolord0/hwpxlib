package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.connectline;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;

public class Point extends HWPXObject {
    /**
     * x 좌표
     */
    private Long x;
    /**
     * y 좌표
     */
    private Long y;
    private Integer type;

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_point;
    }

    public Long x() {
        return x;
    }

    public void x(Long x) {
        this.x = x;
    }

    public Point xAnd(Long x) {
        this.x = x;
        return this;
    }

    public Long y() {
        return y;
    }

    public void y(Long y) {
        this.y = y;
    }

    public Point yAnd(Long y) {
        this.y = y;
        return this;
    }

    public Integer type() {
        return type;
    }

    public void type(Integer type) {
        this.type = type;
    }

    public Point typeAnd(Integer type) {
        this.type = type;
        return this;
    }
}
