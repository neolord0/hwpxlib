package kr.dogfoot.hwpxlib.writer.settings_xml;

import kr.dogfoot.hwpxlib.commonstirngs.AttributeNames;
import kr.dogfoot.hwpxlib.commonstirngs.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectList;
import kr.dogfoot.hwpxlib.object.root.ConfigItem;
import kr.dogfoot.hwpxlib.writer.common.ElementWriter;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterManager;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterSort;

public class ConfigItemSetWriter extends ElementWriter {
    public ConfigItemSetWriter(ElementWriterManager elementWriterManager) {
        super(elementWriterManager);
    }

    @Override
    public ElementWriterSort sort() {
        return ElementWriterSort.ConfigItemSet;
    }

    @Override
    public void write(HWPXObject object) {
        ObjectList<ConfigItem> configItemSet = (ObjectList<ConfigItem>) object;
        storeSwitchObject(configItemSet.switchObject());

        xsb()
                .openElement(ElementNames.config_item_set)
                .elementWriter(this);

        for (ConfigItem configItem :  configItemSet.items()) {
            configItem(configItem);
        }

        xsb().closeElement();
        releaseMe();
    }

    private void configItem(ConfigItem configItem) {
        xsb()
                .openElement(ElementNames.config_item)
                .attribute(AttributeNames.name, configItem.name())
                .attribute(AttributeNames.type, configItem.type())
                .closeElement();
    }

    @Override
    protected void childInSwitch(HWPXObject child) {
        switch (child._objectType()) {
            case config_item:
                configItem((ConfigItem) child);
                break;
        }
    }
}
