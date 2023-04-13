package kr.dogfoot.hwpxlib.object.root;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;

import java.util.ArrayList;

public class ConfigItemSet extends SwitchableObject {
    private String name;
    private ArrayList<ConfigItem> configItemList;

    public ConfigItemSet() {
        configItemList = new ArrayList<ConfigItem>();
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.config_item_set;
    }

    public String name() {
        return name;
    }

    public void name(String name) {
        this.name = name;
    }

    public ConfigItemSet nameAnd(String name) {
        this.name = name;
        return this;
    }

    public int countOfConfigItem() {
        return configItemList.size();
    }

    public ConfigItem getConfigItem(int index) {
        return configItemList.get(index);
    }

    public void addConfigItem(ConfigItem configItem) {
        configItemList.add(configItem);
    }

    public ConfigItem addNewConfigItem() {
        ConfigItem configItem = new ConfigItem();
        configItemList.add(configItem);
        return configItem;
    }

    public void insertConfigItem(ConfigItem configItem, int position) {
        configItemList.add(position, configItem);
    }

    public void removeConfigItem(int position) {
        configItemList.remove(position);
    }

    public Iterable<ConfigItem> configItems() {
        return configItemList;
    }
}
