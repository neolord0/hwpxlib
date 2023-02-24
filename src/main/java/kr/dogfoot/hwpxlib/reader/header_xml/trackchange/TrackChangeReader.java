package kr.dogfoot.hwpxlib.reader.header_xml.trackchange;

import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.TrackChangeType;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.TrackChange;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.util.ValueConvertor;
import kr.dogfoot.hwpxlib.commonstirngs.AttributeNames;

public class TrackChangeReader extends ElementReader {
    private TrackChange trackChange;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.TrackChange;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.id:
                trackChange.id(value);
                break;
            case AttributeNames.type:
                trackChange.type(TrackChangeType.fromString(value));
                break;
            case AttributeNames.date:
                trackChange.date(value);
                break;
            case AttributeNames.authorID:
                trackChange.authorID(value);
                break;
            case AttributeNames.hide:
                trackChange.hide(ValueConvertor.toBoolean(value));
                break;
            case AttributeNames.charshapeID:
                trackChange.charshapeID(value);
                break;
            case AttributeNames.parashapeID:
                trackChange.parashapeID(value);
                break;
        }
    }

    @Override
    public SwitchableObject switchableObject() {
        return null;
    }

    public void trackChange(TrackChange trackChange) {
        this.trackChange = trackChange;
    }
}
