package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.secpr.notepr;

import kr.dogfoot.hwpxlib.object.common.ObjectType;

/**
 * 미주 모양
 */
public class EndNotePr extends NoteShape {
    /**
     * 번호 매김 방식
     */
    private EndNoteNumbering numbering;
    /**
     * 미주 위치
     */
    private EndNotePlacement placement;

    public EndNotePr() {
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_endNotePr;
    }

    public EndNoteNumbering numbering() {
        return numbering;
    }

    public void createNumbering() {
        numbering = new EndNoteNumbering();
    }

    public void removeNumbering() {
        numbering = null;
    }

    public EndNotePlacement placement() {
        return placement;
    }

    public void createPlacement() {
        placement = new EndNotePlacement();
    }

    public void removePlacement() {
        placement = null;
    }

    @Override
    public EndNotePr clone() {
        EndNotePr cloned = new EndNotePr();
        cloned.copyFrom(this);
        return cloned;
    }

    public void copyFrom(EndNotePr from) {
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
