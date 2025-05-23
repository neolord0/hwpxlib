package kr.dogfoot.hwpxlib.writer.header_xml;

import kr.dogfoot.hwpxlib.commonstrings.AttributeNames;
import kr.dogfoot.hwpxlib.commonstrings.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.content.header_xml.TrackChangeConfig;
import kr.dogfoot.hwpxlib.writer.common.ElementWriter;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterManager;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterSort;

public class TrackChangeConfigWriter extends ElementWriter {
    public TrackChangeConfigWriter(ElementWriterManager elementWriterManager) {
        super(elementWriterManager);
    }

    @Override
    public ElementWriterSort sort() {
        return ElementWriterSort.TrackChangeConfig;
    }

    @Override
    public void write(HWPXObject object) {
        TrackChangeConfig trackChangeConfig = (TrackChangeConfig) object;
        switchList(trackChangeConfig.switchList());

        xsb()
                .openElement(ElementNames.hh_trackchageConfig)
                .attribute(AttributeNames.flags, trackChangeConfig.flags());

        if (trackChangeConfig.configItemSet() != null) {
            writeChild(ElementWriterSort.ConfigItemSet, trackChangeConfig.configItemSet());
        }

        xsb().closeElement();
        releaseMe();
    }
}
