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
    public ObjectType _objectType() {
        return ObjectType.hp_footNotePr;
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

    @Override
    public FootNotePr clone() {
        FootNotePr cloned = new FootNotePr();
        cloned.copyFrom(this);
        return cloned;
    }

    public void copyFrom(FootNotePr from) {
        if (from.numbering != null) {
            numbering = from.numbering.clone();
        } else {
            numbering = null;
        }

        if (from.placement != null) {
            placement = from.placement.clone();
        } else {
            placement = null;
        }

        super.copyFrom(from);
    }
}
