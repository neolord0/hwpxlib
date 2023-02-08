package kr.dogfoot.hwpxlib.reader.settings_xml;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectList;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.root.CaretPosition;
import kr.dogfoot.hwpxlib.object.root.ConfigItem;
import kr.dogfoot.hwpxlib.object.root.SettingsXMLFile;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.util.ElementNames;
import org.xml.sax.Attributes;

public class SettingsReader extends ElementReader {
    private SettingsXMLFile settingsXMLFile;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.Settings;
    }

    @Override
    public void childElement(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.CaretPosition:
                settingsXMLFile.createCaretPosition();
                caretPosition(settingsXMLFile.caretPosition(), name, attrs);
                break;
            case ElementNames.ConfigItemSet:
                settingsXMLFile.createConfigItemSet();
                configItemSet(settingsXMLFile.configItemSet(), name, attrs);
                break;
        }
    }

    @Override
    public void childElementInSwitch(HWPXObject child, String name, Attributes attrs) {
        if (ObjectType.CaretPosition.equalElementName(name)) {
            caretPosition((CaretPosition) child, name, attrs);
        } else if (ObjectType.ConfigItemSet.equalElementName(name)) {
            configItemSet((ObjectList<ConfigItem>) child, name, attrs);
        }
    }

    private void caretPosition(CaretPosition caretPosition, String name, Attributes attrs) {
        ((CaretPositionReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.CaretPosition))
                .caretPosition(caretPosition);

        xmlFileReader().startElement(name, attrs);
    }

    private void configItemSet(ObjectList<ConfigItem> configItemSet, String name, Attributes attrs) {
        ((ConfigItemSetReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.ConfigItemSet))
                .configItemSet(configItemSet);

        xmlFileReader().startElement(name, attrs);
    }

    @Override
    public SwitchableObject switchableObject() {
        return settingsXMLFile;
    }

    public void settingsXMLFile(SettingsXMLFile settingsXMLFile) {
        this.settingsXMLFile = settingsXMLFile;
    }
}
