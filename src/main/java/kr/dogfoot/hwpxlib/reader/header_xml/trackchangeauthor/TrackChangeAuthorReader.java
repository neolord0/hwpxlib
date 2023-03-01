package kr.dogfoot.hwpxlib.reader.header_xml.trackchangeauthor;

import kr.dogfoot.hwpxlib.commonstirngs.AttributeNames;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.TrackChangeAuthor;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.util.ValueConvertor;

public class TrackChangeAuthorReader extends ElementReader  {
    private TrackChangeAuthor trackChangeAuthor;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.TrackChangeAuthor;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.id:
                trackChangeAuthor.id(value);
                break;
            case AttributeNames.name:
                trackChangeAuthor.name(value);
                break;
            case AttributeNames.mark:
                trackChangeAuthor.mark(ValueConvertor.toBoolean(value));
                break;
        }
    }

    @Override
    public SwitchableObject switchableObject() {
        return null;
    }

    public void trackChangeAuthor(TrackChangeAuthor trackChangeAuthor) {
        this.trackChangeAuthor = trackChangeAuthor;
    }
}
