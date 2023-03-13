package kr.dogfoot.hwpxlib.writer.header_xml.reflist;

import kr.dogfoot.hwpxlib.commonstrings.AttributeNames;
import kr.dogfoot.hwpxlib.commonstrings.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectList;
import kr.dogfoot.hwpxlib.object.content.header_xml.references.TrackChange;
import kr.dogfoot.hwpxlib.writer.common.ElementWriter;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterManager;
import kr.dogfoot.hwpxlib.writer.common.ElementWriterSort;

public class TrackChangesWriter extends ElementWriter {
    public TrackChangesWriter(ElementWriterManager elementWriterManager) {
        super(elementWriterManager);
    }

    @Override
    public ElementWriterSort sort() {
        return ElementWriterSort.TrackChanges;
    }

    @Override
    public void write(HWPXObject object) {
        ObjectList<TrackChange> trackChanges = (ObjectList<TrackChange>) object;
        switchObject(trackChanges.switchObject());
        if (trackChanges.count() == 0) {
            return;
        }

        xsb()
                .openElement(ElementNames.hh_trackChanges)
                .elementWriter(this)
                .attribute(AttributeNames.itemCnt, trackChanges.count());

        for (TrackChange trackChange : trackChanges.items()) {
            trackChange(trackChange);
        }

        xsb().closeElement();
        releaseMe();
    }

    private void trackChange(TrackChange trackChange) {
        xsb()
                .openElement(ElementNames.hh_trackChange)
                .attribute(AttributeNames.id, trackChange.id())
                .attribute(AttributeNames.type, trackChange.type())
                .attribute(AttributeNames.date, trackChange.date())
                .attribute(AttributeNames.authorID, trackChange.authorID())
                .attribute(AttributeNames.hide, trackChange.hide())
                .attribute(AttributeNames.charshapeID, trackChange.charshapeID())
                .attribute(AttributeNames.parashapeID, trackChange.parashapeID())
                .closeElement();
    }

    @Override
    protected void childInSwitch(HWPXObject child) {
        switch (child._objectType()) {
            case hh_trackChange:
                trackChange((TrackChange) child);
                break;
        }
    }
}
