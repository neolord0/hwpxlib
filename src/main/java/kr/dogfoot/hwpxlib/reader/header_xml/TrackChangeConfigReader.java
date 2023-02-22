package kr.dogfoot.hwpxlib.reader.header_xml;

import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.header_xml.TrackChangeConfig;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.util.ValueConvertor;
import kr.dogfoot.hwpxlib.object.names.AttributeNames;

public class TrackChangeConfigReader extends ElementReader {
    private TrackChangeConfig trackChangeConfig;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.TrackChangeConfig;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.flags:
                trackChangeConfig.flags(ValueConvertor.toInteger(value));
                break;
        }
    }

    @Override
    public SwitchableObject switchableObject() {
        return null;
    }

    public void trackChangeConfig(TrackChangeConfig trackChangeConfig) {
        this.trackChangeConfig = trackChangeConfig;
    }
}
