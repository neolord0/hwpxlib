package kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.secpr.notepr;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;

public class NoteSpacing extends HWPXObject {
    /**
     * 주석 사이 여백
     */
    private Integer betweenNotes;
    /**
     * 구분선 어래 여백
     */
    private Integer belowLine;
    /**
     * 구분선 위 여백
     */
    private Integer aboveLine;

    public NoteSpacing() {
    }

    @Override
    public ObjectType objectType() {
        return ObjectType.NoteSpacing;
    }

    public Integer betweenNotes() {
        return betweenNotes;
    }

    public void betweenNotes(Integer betweenNotes) {
        this.betweenNotes = betweenNotes;
    }

    public NoteSpacing betweenNotesAnd(Integer betweenNotes) {
        this.betweenNotes = betweenNotes;
        return this;
    }

    public Integer belowLine() {
        return belowLine;
    }

    public void belowLine(Integer belowLine) {
        this.belowLine = belowLine;
    }

    public NoteSpacing belowLineAnd(Integer belowLine) {
        this.belowLine = belowLine;
        return this;
    }

    public Integer aboveLine() {
        return aboveLine;
    }

    public void aboveLine(Integer aboveLine) {
        this.aboveLine = aboveLine;
    }

    public NoteSpacing aboveLineAnd(Integer aboveLine) {
        this.aboveLine = aboveLine;
        return this;
    }
}
