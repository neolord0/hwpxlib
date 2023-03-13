package kr.dogfoot.hwpxlib.writer;

import kr.dogfoot.hwpxlib.commonstrings.AttributeNames;
import kr.dogfoot.hwpxlib.commonstrings.ElementNames;
import kr.dogfoot.hwpxlib.commonstrings.Namespaces;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectList;
import kr.dogfoot.hwpxlib.object.root.CaretPosition;
import kr.dogfoot.hwpxlib.object.root.ConfigItem;
import kr.dogfoot.hwpxlib.object.root.SettingsXMLFile;
import kr.dogfoot.hwpxlib.writer.common.ElementWriter;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterManager;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterSort;
import kr.dogfoot.hwpxlib.writer.util.XMLStringBuilder;

public class SettingsWriter extends ElementWriter {
    protected SettingsWriter(ElementWriterManager elementWriterManager) {
        super(elementWriterManager);
    }

    public static void write(SettingsXMLFile settingsXMLFile, XMLStringBuilder xsb) {
        xsb
                .openElement(ElementNames.ha_HWPApplicationSetting)
                .namespace(Namespaces.ha)
                .namespace(Namespaces.config);

        if (settingsXMLFile.caretPosition() != null) {
            caretPosition(settingsXMLFile.caretPosition(), xsb);
        }
        if (settingsXMLFile.configItemSet() != null) {
            configItemSet(settingsXMLFile.configItemSet(), xsb);
        }
        xsb.closeElement();
    }

    private static void caretPosition(CaretPosition caretPosition, XMLStringBuilder xsb) {
    }

    private static void configItemSet(ObjectList<ConfigItem> configItemSet, XMLStringBuilder xsb) {
        xsb.openElement(ElementNames.config_item_set);
        for (ConfigItem configItem :  configItemSet.items()) {
            xsb
                    .openElement(ElementNames.config_item)
                    .attribute(AttributeNames.name, configItem.name())
                    .attribute(AttributeNames.type, configItem.type())
                    .closeElement();
        }
        xsb.closeElement();
    }

    @Override
    public ElementWriterSort sort() {
        return null;
    }

    @Override
    public void write(HWPXObject object) {

    }
}
