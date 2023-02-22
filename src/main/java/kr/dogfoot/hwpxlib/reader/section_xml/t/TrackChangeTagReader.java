package kr.dogfoot.hwpxlib.reader.section_xml.t;

import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.t.inner.TrackChangeTag;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.util.ValueConvertor;
import kr.dogfoot.hwpxlib.object.names.AttributeNames;

public class TrackChangeTagReader extends ElementReader {
    private TrackChangeTag trackChangeTag;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.TrackChangeTag;
    }

    public void trackChangeTag(TrackChangeTag trackChangeTag) {
        this.trackChangeTag = trackChangeTag;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.Id:
                trackChangeTag.Id(value);
                break;
            case AttributeNames.TcId:
                trackChangeTag.TcId(value);
                break;
            case AttributeNames.paraend:
                trackChangeTag.paraend(ValueConvertor.toBoolean(value));
                break;
        }
    }

    @Override
    public SwitchableObject switchableObject() {
        return null;
    }
}
