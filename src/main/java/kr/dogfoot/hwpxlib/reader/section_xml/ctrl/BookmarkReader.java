package kr.dogfoot.hwpxlib.reader.section_xml.ctrl;

import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.ctrl.Bookmark;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.object.names.AttributeNames;

public class BookmarkReader extends ElementReader {
    private Bookmark bookmark;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.Bookmark;
    }

    public void bookmark(Bookmark bookmark) {
        this.bookmark = bookmark;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.name:
                bookmark.name(value);
                break;
        }
    }

    @Override
    public SwitchableObject switchableObject() {
        return null;
    }
}
