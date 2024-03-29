package kr.dogfoot.hwpxlib.reader.header_xml.trackchangeauthor;

import kr.dogfoot.hwpxlib.commonstrings.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectList;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.TrackChangeAuthor;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import org.xml.sax.Attributes;

public class TrackChangeAuthorsReader extends ElementReader {
    private ObjectList<TrackChangeAuthor> trackChangeAuthors;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.TrackChangeAuthors;
    }

    @Override
    public void childElement(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.hh_trackChangeAuthor:
                trackChangeAuthor(trackChangeAuthors.addNew(), name, attrs);
                break;
        }
    }

    @Override
    public HWPXObject childElementInSwitch(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.hh_trackChangeAuthor:
                TrackChangeAuthor trackChangeAuthor = new TrackChangeAuthor();

                trackChangeAuthor(trackChangeAuthor, name, attrs);
                return trackChangeAuthor;
        }
        return null;
    }

    private void trackChangeAuthor(TrackChangeAuthor trackChangeAuthor, String name, Attributes attrs) {
        ((TrackChangeAuthorReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.TrackChangeAuthor))
                .trackChangeAuthor(trackChangeAuthor);

        xmlFileReader().startElement(name, attrs);
    }

    @Override
    public SwitchableObject switchableObject() {
        return trackChangeAuthors;
    }

    public void trackChangeAuthors(ObjectList<TrackChangeAuthor> trackChangeAuthors) {
        this.trackChangeAuthors = trackChangeAuthors;
    }
}
