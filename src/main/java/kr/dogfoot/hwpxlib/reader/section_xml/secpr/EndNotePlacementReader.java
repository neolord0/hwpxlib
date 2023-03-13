package kr.dogfoot.hwpxlib.reader.section_xml.secpr;

import kr.dogfoot.hwpxlib.commonstrings.AttributeNames;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.EndNotePlace;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.secpr.notepr.EndNotePlacement;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.reader.util.ValueConvertor;

public class EndNotePlacementReader extends ElementReader {
    private EndNotePlacement endNotePlacement;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.EndNotePlacement;
    }

    public void endNotePlacement(EndNotePlacement endNotePlacement) {
        this.endNotePlacement = endNotePlacement;
    }

    @Override
    protected void setAttribute(String name, String value) {
        switch (name) {
            case AttributeNames.place:
                endNotePlacement.place(EndNotePlace.fromString(value));
                break;
            case AttributeNames.beneathText:
                endNotePlacement.beneathText(ValueConvertor.toBoolean(value));
                break;
        }
    }

    @Override
    public SwitchableObject switchableObject() {
        return null;
    }
}
