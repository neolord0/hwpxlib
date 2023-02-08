package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.secpr.notepr;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.enumtype.FootNotePlace;

/**
 * 각주 위치
 */
public class FootNotePlacement extends HWPXObject {
    /**
     * 각주 위치
     */
    private FootNotePlace place;
    /**
     * 텍스트에 이어 바로 출력할지 여부
     */
    private Boolean beneathText;

    public FootNotePlacement() {
    }

    @Override
    public ObjectType objectType() {
        return ObjectType.FootNotePlacement;
    }

    public FootNotePlace place() {
        return place;
    }

    public void place(FootNotePlace place) {
        this.place = place;
    }

    public FootNotePlacement placeAnd(FootNotePlace place) {
        this.place = place;
        return this;
    }

    public Boolean beneathText() {
        return beneathText;
    }

    public void beneathText(Boolean beneathText) {
        this.beneathText = beneathText;
    }

    public FootNotePlacement beneathTextAnd(Boolean beneathText) {
        this.beneathText = beneathText;
        return this;
    }
}
