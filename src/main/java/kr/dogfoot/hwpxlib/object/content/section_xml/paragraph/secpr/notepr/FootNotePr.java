package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.secpr.notepr;

import kr.dogfoot.hwpxlib.object.common.ObjectType;

/**
 * 각주 모양
 */
public class FootNotePr extends NoteShape {
    /**
     * 번호 매김 방식
     */
    private FootNoteNumbering numbering;
    /**
     * 각주 위치
     */
    private FootNotePlacement placement;

    public FootNotePr() {
    }

    @Override
    public ObjectType objectType() {
        return ObjectType.FootNotePr;
    }

    public FootNoteNumbering numbering() {
        return numbering;
    }

    public void createNumbering() {
        numbering = new FootNoteNumbering();
    }

    public void removeNumbering() {
        numbering = null;
    }

    public FootNotePlacement placement() {
        return placement;
    }

    public void createPlacement() {
        placement = new FootNotePlacement();
    }

    public void removePlacement() {
        placement = null;
    }

}
