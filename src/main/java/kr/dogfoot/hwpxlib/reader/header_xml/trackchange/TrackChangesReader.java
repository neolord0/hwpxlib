package kr.dogfoot.hwpxlib.reader.header_xml.trackchange;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectList;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.TabPr;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.TrackChange;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.header_xml.tabpr.TabPrReader;
import kr.dogfoot.hwpxlib.util.ElementNames;
import org.xml.sax.Attributes;

public class TrackChangesReader extends ElementReader {
    private ObjectList<TrackChange> trackChanges;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.TrackChanges;
    }

    @Override
    public void childElement(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.TrackChange:
                trackChange(trackChanges.addNew(), name, attrs);
                break;
        }
    }

    @Override
    public void childElementInSwitch(HWPXObject child, String name, Attributes attrs) {
        if (child.objectType() == ObjectType.TrackChange) {
            trackChange((TrackChange) child, name, attrs);
        }
    }

    private void trackChange(TrackChange trackChange, String name, Attributes attrs) {
        ((TrackChangeReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.TrackChange))
                .trackChange(trackChange);

        xmlFileReader().startElement(name, attrs);
    }

    @Override
    public SwitchableObject switchableObject() {
        return trackChanges;
    }

    public void trackChanges(ObjectList<TrackChange> trackChanges) {
        this.trackChanges = trackChanges;
    }
}
