package kr.dogfoot.hwpxlib.object.root;

import kr.dogfoot.hwpxlib.object.common.ObjectList;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;

/**
 * /settings.xml 파일
 */
public class SettingsXMLFile extends SwitchableObject {
    /**
     * 캐럿 위치
     */
    private CaretPosition caretPosition;
    /**
     * <config-item-set/>
     */
    private ObjectList<ConfigItem> configItemSet;

    public SettingsXMLFile() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.ha_HWPApplicationSetting;
    }

    public CaretPosition caretPosition() {
        return caretPosition;
    }

    public void createCaretPosition() {
        caretPosition = new CaretPosition();
    }

    public void removeCaretPosition() {
        caretPosition = null;
    }

    public ObjectList<ConfigItem> configItemSet() {
        return configItemSet;
    }

    public void createConfigItemSet() {
        configItemSet = new ObjectList<ConfigItem>(ObjectType.config_item_set, ConfigItem.class);
    }

    public void removeConfigItemSet() {
        configItemSet = null;
    }
}
