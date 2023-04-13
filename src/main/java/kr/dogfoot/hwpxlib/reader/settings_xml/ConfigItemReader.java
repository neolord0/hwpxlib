package kr.dogfoot.hwpxlib.reader.settings_xml;

import kr.dogfoot.hwpxlib.commonstrings.AttributeNames;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.root.ConfigItem;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;

public class ConfigItemReader extends ElementReader {
    private ConfigItem configItem;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.ConfigItem;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.name:
                configItem.name(value);
                break;
            case AttributeNames.type:
                configItem.type(value);
                break;
        }
    }

    @Override
    public void text(String text) {
        if (configItem.value() == null) {
            configItem.value(text);
        } else {
            configItem.value(configItem.value() + text);
        }
    }

    @Override
    public SwitchableObject switchableObject() {
        return null;
    }

    public void configItem(ConfigItem configItem) {
        this.configItem = configItem;
    }
}
