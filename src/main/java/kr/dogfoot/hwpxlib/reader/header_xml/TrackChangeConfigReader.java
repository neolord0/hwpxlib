package kr.dogfoot.hwpxlib.reader.header_xml;

import kr.dogfoot.hwpxlib.commonstrings.AttributeNames;
import kr.dogfoot.hwpxlib.commonstrings.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.header_xml.TrackChangeConfig;
import kr.dogfoot.hwpxlib.object.root.ConfigItemSet;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.settings_xml.ConfigItemSetReader;
import kr.dogfoot.hwpxlib.reader.util.ValueConvertor;
import org.xml.sax.Attributes;

public class TrackChangeConfigReader extends ElementReader {
    private TrackChangeConfig trackChangeConfig;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.TrackChangeConfig;
    }

    @Override
    public void childElement(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.config_item_set:
            case ElementNames.config_item_set2:
                trackChangeConfig.createConfigItemSet();
                configItemSet(trackChangeConfig.configItemSet(), name, attrs);
                break;
        }
    }

    @Override
    public HWPXObject childElementInSwitch(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.config_item_set:
            case ElementNames.config_item_set2:
                ConfigItemSet configItemSet = new ConfigItemSet();
                configItemSet(configItemSet, name, attrs);
                return configItemSet;
        }
        return null;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.flags:
                trackChangeConfig.flags(ValueConvertor.toInteger(value));
                break;
        }
    }

    private void configItemSet(ConfigItemSet configItemSet, String name, Attributes attrs) {
        ((ConfigItemSetReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.ConfigItemSet))
                .configItemSet(configItemSet);

        xmlFileReader().startElement(name, attrs);
    }

    @Override
    public SwitchableObject switchableObject() {
        return trackChangeConfig;
    }

    public void trackChangeConfig(TrackChangeConfig trackChangeConfig) {
        this.trackChangeConfig = trackChangeConfig;
    }
}
