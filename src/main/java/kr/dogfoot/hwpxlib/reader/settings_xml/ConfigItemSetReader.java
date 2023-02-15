package kr.dogfoot.hwpxlib.reader.settings_xml;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectList;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.root.ConfigItem;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.util.ElementNames;
import org.xml.sax.Attributes;

public class ConfigItemSetReader extends ElementReader {
    private ObjectList<ConfigItem> configItemSet;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.ConfigItemSet;
    }

    @Override
    public void childElement(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.config_item:
                configItem(configItemSet.addNew(), name, attrs);
                break;
        }
    }

    @Override
    public HWPXObject childElementInSwitch(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.config_item:
                ConfigItem configItem = new ConfigItem();
                configItem(configItem, name, attrs);
                return configItem;
        }
        return null;
    }

    private void configItem(ConfigItem configItem, String name, Attributes attrs) {
        ((ConfigItemReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.ConfigItem))
                .configItem(configItem);

        xmlFileReader().startElement(name, attrs);
    }

    @Override
    public SwitchableObject switchableObject() {
        return configItemSet;
    }

    public void configItemSet(ObjectList<ConfigItem> configItemSet) {
        this.configItemSet = configItemSet;
    }
}
