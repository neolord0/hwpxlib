package kr.dogfoot.hwpxlib.object.root;


import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;

/**
 * <config-item/>
 */
public class ConfigItem extends HWPXObject {
    private String name;
    private String type;
    private String value;

    public ConfigItem() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.config_item;
    }

    public String name() {
        return name;
    }

    public void name(String name) {
        this.name = name;
    }

    public ConfigItem nameAnd(String name) {
        this.name = name;
        return this;
    }

    public String type() {
        return type;
    }

    public void type(String type) {
        this.type = type;
    }

    public ConfigItem typeAnd(String type) {
        this.type = type;
        return this;
    }

    public String value() {
        return value;
    }

    public void value(String value) {
        this.value = value;
    }

    public ConfigItem valueAnd(String value) {
        this.value = value;
        return this;
    }

    @Override
    public ConfigItem clone() {
        ConfigItem cloned = new ConfigItem();
        cloned.copyFrom(this);
        return cloned;
    }

    public void copyFrom(ConfigItem from) {
        this.name = from.name;
        this.type = from.type;
        this.value = from.value;
    }
}
