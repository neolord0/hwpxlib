package kr.dogfoot.hwpxlib.writer.settings_xml;

import kr.dogfoot.hwpxlib.CommonString;
import kr.dogfoot.hwpxlib.object.common.ObjectList;
import kr.dogfoot.hwpxlib.object.names.AttributeNames;
import kr.dogfoot.hwpxlib.object.names.ElementNames;
import kr.dogfoot.hwpxlib.object.root.CaretPosition;
import kr.dogfoot.hwpxlib.object.root.ConfigItem;
import kr.dogfoot.hwpxlib.object.root.SettingsXMLFile;
import kr.dogfoot.hwpxlib.writer.util.XMLStringBuilder;

public class SettingsWriter {
    public static void write(SettingsXMLFile settingsXMLFile, XMLStringBuilder xsb) {
        xsb
                .openElement(ElementNames.ha_HWPApplicationSetting)
                .attribute(AttributeNames.xmlns_ha, CommonString.xmlns_ha)
                .attribute(AttributeNames.xmlns_config, CommonString.xmlns_config);
        if (settingsXMLFile.caretPosition() != null) {
            caretPosition(settingsXMLFile.caretPosition(), xsb);
        }
        if (settingsXMLFile.configItemSet() != null) {
            configItemSet(settingsXMLFile.configItemSet(), xsb);
        }
        xsb.closeElement();
    }

    private static void caretPosition(CaretPosition caretPosition, XMLStringBuilder xsb) {
        xsb
                .openElement(ElementNames.ha_CaretPosition)
                .attribute(AttributeNames.listIDRef, caretPosition.listIDRef())
                .attribute(AttributeNames.paraIDRef, caretPosition.paraIDRef())
                .attribute(AttributeNames.pos, caretPosition.pos())
                .closeElement();
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
}
