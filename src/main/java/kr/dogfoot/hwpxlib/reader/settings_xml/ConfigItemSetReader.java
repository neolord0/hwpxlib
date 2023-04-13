package kr.dogfoot.hwpxlib.reader.settings_xml;

import kr.dogfoot.hwpxlib.commonstrings.AttributeNames;
import kr.dogfoot.hwpxlib.commonstrings.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.root.ConfigItem;
import kr.dogfoot.hwpxlib.object.root.ConfigItemSet;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import org.xml.sax.Attributes;

public class ConfigItemSetReader extends ElementReader {
    private ConfigItemSet configItemSet;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.ConfigItemSet;
    }


    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.name:
                configItemSet.name(value);
                break;
        }
    }

    @Override
    public void childElement(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.config_item:
            case ElementNames.config_item2:
                configItem(configItemSet.addNewConfigItem(), name, attrs);
                break;
        }
    }

    @Override
    public HWPXObject childElementInSwitch(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.config_item:
            case ElementNames.config_item2:
                ConfigItem configItem = new ConfigItem();
                configItem(configItem, name, attrs);
                return configItem;
        }
        return null;
    }

    private void configItem(ConfigItem configItem, String name, Attributes attrs) {
        ((ConfigItemReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.ConfigItem))
                .configItem(configItem);

        xmlFileReader().startElement(name, attrs);
    }

    @Override
    public SwitchableObject switchableObject() {
        return configItemSet;
    }

    public void configItemSet(ConfigItemSet configItemSet) {
        this.configItemSet = configItemSet;
    }
}
