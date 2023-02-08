package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.secpr.notepr;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.EndNotePlace;

/**
 * 미주 위치
 */
public class EndNotePlacement extends HWPXObject {
    /**
     * 미주 위치
     */
    private EndNotePlace place;
    /**
     * 텍스트에 이어 바로 출력할지 여부
     */
    private Boolean beneathText;

    public EndNotePlacement() {
    }

    @Override
    public ObjectType objectType() {
        return ObjectType.EndNotePlacement;
    }

    public EndNotePlace place() {
        return place;
    }

    public void place(EndNotePlace place) {
        this.place = place;
    }

    public EndNotePlacement placeAnd(EndNotePlace place) {
        this.place = place;
        return this;
    }

    public Boolean beneathText() {
        return beneathText;
    }

    public void beneathText(Boolean beneathText) {
        this.beneathText = beneathText;
    }

    public EndNotePlacement beneathTextAnd(Boolean beneathText) {
        this.beneathText = beneathText;
        return this;
    }
}
