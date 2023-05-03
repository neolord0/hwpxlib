package kr.dogfoot.hwpxlib.tool.textextractor.comm;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.tool.textextractor.TextMarks;

public class TextBuilder {
    private static final String Space = " ";
    private static final String Hyphen = "_";

    private final StringBuilder sb;
    private final TextMarks textMarks;
    public TextBuilder(TextMarks textMarks) {
        sb = new StringBuilder();

        this.textMarks = textMarks;
    }

    public void text(String str) {
        if (str != null) {
            sb.append(str);
        }
    }

    public void paraSeparator() {
        if (textMarks != null) {
            text(textMarks.paraSeparator());
        }
    }

    public void lineBreak() {
        if (textMarks != null) {
            text(textMarks.lineBreak());
        }
    }

    public void tab() {
        if (textMarks != null) {
            text(textMarks.tab());
        }
    }

    public void objectStart(ObjectType objectType) {
        if (textMarks != null) {
            switch (objectType) {
                case hp_fieldBegin:
                    text(textMarks.fieldStart());
                    break;
                case hp_tbl:
                    text(textMarks.tableStart());
                    break;
                case hp_container:
                    text(textMarks.containerStart());
                    break;
                case hp_line:
                    text(textMarks.lineStart());
                    break;
                case hp_rect:
                    text(textMarks.rectangleStart());
                    break;
                case hp_ellipse:
                    text(textMarks.ellipseStart());
                    break;
                case hp_arc:
                    text(textMarks.arcStart());
                    break;
                case hp_polygon:
                    text(textMarks.polygonStart());
                    break;
                case hp_curve:
                    text(textMarks.curveStart());
                    break;
                case hp_connectLine:
                    text(textMarks.connectLineStart());
                    break;
                case hp_textart:
                    text(textMarks.textArtStart());
                    break;
            }
        }
    }

    public void objectEnd(ObjectType objectType) {
        if (textMarks != null) {
            switch (objectType) {
                case hp_fieldEnd:
                    text(textMarks.fieldEnd());
                    break;
                case hp_tbl:
                    text(textMarks.tableEnd());
                    break;
                case hp_container:
                    text(textMarks.containerEnd());
                    break;
                case hp_line:
                    text(textMarks.lineEnd());
                    break;
                case hp_rect:
                    text(textMarks.rectangleEnd());
                    break;
                case hp_ellipse:
                    text(textMarks.ellipseEnd());
                    break;
                case hp_arc:
                    text(textMarks.arcEnd());
                    break;
                case hp_polygon:
                    text(textMarks.polygonEnd());
                    break;
                case hp_curve:
                    text(textMarks.curveEnd());
                    break;
                case hp_connectLine:
                    text(textMarks.connectLineEnd());
                    break;
                case hp_textart:
                    text(textMarks.textArtEnd());
                    break;
            }
        }
    }

    public void tableRowSeparator() {
        if (textMarks != null) {
            text(textMarks.tableRowSeparator());
        }
    }

    public void tableCellSeparator() {
        if (textMarks != null) {
            text(textMarks.tableCellSeparator());
        }
    }

    public String result() {
        return sb.toString();
    }

    public void space() {
        sb.append(Space);
    }


    public void hyphen() {
        sb.append(Hyphen);
    }
}
