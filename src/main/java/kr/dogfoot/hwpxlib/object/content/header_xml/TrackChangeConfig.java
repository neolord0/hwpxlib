package kr.dogfoot.hwpxlib.object.content.header_xml;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.root.ConfigItemSet;


public class TrackChangeConfig extends SwitchableObject {
    private Integer flags;
    /**
     * <config-item-set/>
     */
    private ConfigItemSet configItemSet;

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

    public ConfigItemSet configItemSet() {
        return configItemSet;
    }

    public void createConfigItemSet() {
        configItemSet = new ConfigItemSet();
    }

    public void removeConfigItemSet() {
        configItemSet = null;
    }

    @Override
    public TrackChangeConfig clone() {
        TrackChangeConfig cloned = new TrackChangeConfig();
        cloned.copyFrom(this);
        return cloned;
    }

    public void copyFrom(TrackChangeConfig from) {
        this.flags = from.flags;

        if (from.configItemSet != null) {
            configItemSet = from.configItemSet.clone();
        } else {
            configItemSet = null;
        }

        super.copyFrom(from);
    }
}
