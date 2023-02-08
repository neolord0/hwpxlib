package kr.dogfoot.hwpxlib.reader.section_xml.secpr;

import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.FootNotePlace;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.secpr.notepr.FootNotePlacement;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.util.ValueConvertor;
import kr.dogfoot.hwpxlib.util.AttributeNames;

public class FootNotePlacementReader extends ElementReader {
    private FootNotePlacement footNotePlacement;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.FootNotePlacement;
    }

    public void footNotePlacement(FootNotePlacement footNotePlacement) {
        this.footNotePlacement = footNotePlacement;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.place:
                footNotePlacement.place(FootNotePlace.fromString(value));
                break;
            case AttributeNames.beneathText:
                footNotePlacement.beneathText(ValueConvertor.toBoolean(value));
                break;
        }
    }

    @Override
    public SwitchableObject switchableObject() {
        return null;
    }
}
