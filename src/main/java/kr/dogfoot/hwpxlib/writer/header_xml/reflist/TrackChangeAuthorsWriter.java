package kr.dogfoot.hwpxlib.writer.header_xml.reflist;

import kr.dogfoot.hwpxlib.commonstirngs.AttributeNames;
import kr.dogfoot.hwpxlib.commonstirngs.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectList;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.TrackChangeAuthor;
import kr.dogfoot.hwpxlib.writer.common.ElementWriter;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterManager;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterSort;

public class TrackChangeAuthorsWriter extends ElementWriter {
    public TrackChangeAuthorsWriter(ElementWriterManager elementWriterManager) {
        super(elementWriterManager);
    }

    @Override
    public ElementWriterSort sort() {
        return ElementWriterSort.TrackChangeAuthors;
    }

    @Override
    public void write(HWPXObject object) {
        ObjectList<TrackChangeAuthor> trackChangeAuthors = (ObjectList<TrackChangeAuthor>) object;
        storeSwitchObject(trackChangeAuthors.switchObject());
        if (trackChangeAuthors.count() == 0) {
            return;
        }

        xsb()
                .openElement(ElementNames.hh_trackChangeAuthors)
                .elementWriter(this)
                .attribute(AttributeNames.itemCnt, trackChangeAuthors.count());

        for (TrackChangeAuthor trackChangeAuthor : trackChangeAuthors.items()) {
            trackChangeAuthor(trackChangeAuthor);
        }

        xsb().closeElement();
        releaseMe();
    }

    private void trackChangeAuthor(TrackChangeAuthor trackChangeAuthor) {
        xsb()
                .openElement(ElementNames.hh_trackChangeAuthor)
                .attribute(AttributeNames.id, trackChangeAuthor.id())
                .attribute(AttributeNames.name, trackChangeAuthor.name())
                .attribute(AttributeNames.mark, trackChangeAuthor.mark())
                .closeElement();
    }

    @Override
    protected void childInSwitch(HWPXObject child) {
        switch (child._objectType()) {
            case hh_trackChangeAuthor:
                trackChangeAuthor((TrackChangeAuthor) child);
                break;
        }
    }
}
