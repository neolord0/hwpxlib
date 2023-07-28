package kr.dogfoot.hwpxlib.writer.settings_xml;

import kr.dogfoot.hwpxlib.commonstrings.AttributeNames;
import kr.dogfoot.hwpxlib.commonstrings.ElementNames;
import kr.dogfoot.hwpxlib.commonstrings.Namespaces;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.root.CaretPosition;
import kr.dogfoot.hwpxlib.object.root.SettingsXMLFile;
import kr.dogfoot.hwpxlib.writer.common.ElementWriter;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterManager;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterSort;

public class SettingsWriter extends ElementWriter {
    public SettingsWriter(ElementWriterManager elementWriterManager) {
        super(elementWriterManager);
    }

    @Override
    public ElementWriterSort sort() {
        return ElementWriterSort.Settings;
    }

    @Override
    public void write(HWPXObject object) {
        SettingsXMLFile settingsXMLFile = (SettingsXMLFile) object;
        switchList(settingsXMLFile.switchList());

        xsb()
                .clear()
                .openElement(ElementNames.ha_HWPApplicationSetting)
                .elementWriter(this)
                .namespace(Namespaces.ha)
                .namespace(Namespaces.config);

        if (settingsXMLFile.caretPosition() != null) {
            caretPosition(settingsXMLFile.caretPosition());
        }

        if (settingsXMLFile.configItemSet() != null) {
            writeChild(ElementWriterSort.ConfigItemSet, settingsXMLFile.configItemSet());
        }

        xsb().closeElement();
        releaseMe();
    }

    private void caretPosition(CaretPosition caretPosition) {
        xsb()
                .openElement(ElementNames.ha_CaretPosition)
                .attribute(AttributeNames.listIDRef, caretPosition.listIDRef())
                .attribute(AttributeNames.paraIDRef, caretPosition.paraIDRef())
                .attribute(AttributeNames.pos, caretPosition.pos())
                .closeElement();

    }

    @Override
    protected void childInSwitch(HWPXObject child) {
        switch (child._objectType()) {
            case ha_CaretPosition:
                caretPosition((CaretPosition) child);
                break;
            case config_item_set:
                writeChild(ElementWriterSort.ConfigItemSet, child);
                break;
        }
    }
}
