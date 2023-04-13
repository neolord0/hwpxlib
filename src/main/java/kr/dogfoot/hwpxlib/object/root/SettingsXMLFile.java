package kr.dogfoot.hwpxlib.object.root;

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
    private ConfigItemSet configItemSet;

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

    public ConfigItemSet configItemSet() {
        return configItemSet;
    }

    public void createConfigItemSet() {
        configItemSet = new ConfigItemSet();
    }

    public void removeConfigItemSet() {
        configItemSet = null;
    }
}
