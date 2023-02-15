package kr.dogfoot.hwpxlib.object.content.header_xml;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;


public class TrackChangeConfig extends HWPXObject {
    private Integer flags;

    public TrackChangeConfig() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hh_trackchageConfig;
    }

    public Integer flags() {
        return flags;
    }

    public void flags(Integer flags) {
        this.flags = flags;
    }

    public TrackChangeConfig flagsAnd(Integer flags) {
        this.flags = flags;
        return this;
    }
}
