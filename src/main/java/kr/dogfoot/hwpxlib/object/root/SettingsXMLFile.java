package kr.dogfoot.hwpxlib.object.root;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectList;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.XMLFile;

/**
 * /settings.xml 파일
 */
public class SettingsXMLFile extends XMLFile {
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
    public ObjectType objectType() {
        return ObjectType.Settings_XMLFile;
    }

    @Override
    public HWPXObject createChildWithElementName(String name) {
        if (ObjectType.CaretPosition.equalElementName(name)) {
            return new CaretPosition();
        } else if (ObjectType.ConfigItemSet.equalElementName(name)) {
            return new ObjectList<ConfigItem>(ObjectType.ConfigItemSet, ConfigItem.class);
        }
        return null;
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
        configItemSet = new ObjectList<ConfigItem>(ObjectType.ConfigItemSet, ConfigItem.class);
    }

    public void removeConfigItemSet() {
        configItemSet = null;
    }
}
