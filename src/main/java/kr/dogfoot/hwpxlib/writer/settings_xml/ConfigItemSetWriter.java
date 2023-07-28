package kr.dogfoot.hwpxlib.writer.settings_xml;

import kr.dogfoot.hwpxlib.commonstrings.AttributeNames;
import kr.dogfoot.hwpxlib.commonstrings.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.root.ConfigItem;
import kr.dogfoot.hwpxlib.object.root.ConfigItemSet;
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
        ConfigItemSet configItemSet = (ConfigItemSet) object;

        switchList(configItemSet.switchList());

        xsb()
                .openElement(ElementNames.config_item_set2)
                .elementWriter(this)
                .attribute(AttributeNames.name, configItemSet.name());

        for (ConfigItem configItem :  configItemSet.configItems()) {
            configItem(configItem);
        }

        xsb().closeElement();
        releaseMe();
    }

    private void configItem(ConfigItem configItem) {
        xsb()
                .openElement(ElementNames.config_item2)
                .attribute(AttributeNames.name, configItem.name())
                .attribute(AttributeNames.type, configItem.type())
                .text(configItem.value())
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
