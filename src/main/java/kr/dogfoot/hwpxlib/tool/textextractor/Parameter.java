package kr.dogfoot.hwpxlib.tool.textextractor;

import kr.dogfoot.hwpxlib.object.HWPXFile;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.tool.textextractor.comm.TextBuilder;
import kr.dogfoot.hwpxlib.tool.textextractor.paraHead.ParaHeadMaker;

import java.util.ArrayList;

public class Parameter {
    private final TextExtractMethod textExtractMethod;
    private final boolean insertParaHead;
    private final TextBuilder textBuilder;
    private ParaHeadMaker paraHeadMaker;
    private ObjectPosition startPosition;
    private ObjectPosition endPosition;

    public Parameter(HWPXFile hwpxFile,
                     TextExtractMethod textExtractMethod,
                     boolean insertParaHead,
                     TextMarks textMarks) {
        this.textExtractMethod = textExtractMethod;
        this.insertParaHead = insertParaHead;
        if (insertParaHead) {
            paraHeadMaker = new ParaHeadMaker(hwpxFile);
        }
        this.textBuilder = new TextBuilder(textMarks);

        startPosition = null;
        endPosition = null;
    }

    public Parameter(HWPXFile hwpxFile,
                     TextExtractMethod textExtractMethod,
                     boolean insertParaHead,
                     TextMarks textMarks,
                     ObjectPosition startPosition,
                     ObjectPosition endPosition) {
        this.textExtractMethod = textExtractMethod;
        this.insertParaHead = insertParaHead;
        if (insertParaHead) {
            paraHeadMaker = new ParaHeadMaker(hwpxFile);
        }
        this.textBuilder = new TextBuilder(textMarks);
        this.startPosition = startPosition;
        this.endPosition = endPosition;
    }

    public TextExtractMethod textExtractMethod() {
        return textExtractMethod;
    }

    public boolean insertParaHead() {
        return insertParaHead;
    }

    public TextBuilder textBuilder() {
        return textBuilder;
    }

    public String result() {
        return textBuilder.result();
    }

    public ParaHeadMaker paraHeadMaker() {
        return paraHeadMaker;
    }

    public int startParaIndex() {
        if (startPosition == null || startPosition.paraIndex() == -1) {
            return 0;
        }
        return startPosition.paraIndex();
    }

    public int endParaIndex(int paraCount) {
        if (endPosition == null || endPosition.paraIndex() == -1) {
            return paraCount - 1;
        }
        return endPosition.paraIndex();
    }

    public int startRunIndex() {
        if (startPosition == null || startPosition.runIndex() == -1) {
            return 0;
        }
        return startPosition.runIndex();
    }

    public int endRunIndex(int runCount) {
        if (endPosition == null || endPosition.runIndex() == -1) {
            return runCount - 1;
        }
        return endPosition.runIndex();
    }

    public int startRunItemIndex() {
        if (startPosition == null || startPosition.runItemIndex() == -1) {
            return 0;
        }
        return startPosition.runItemIndex();
    }

    public int endRunItemIndex(int runItemCount) {
        if (endPosition == null || endPosition.runItemIndex() == -1) {
            return runItemCount - 1;
        }
        return endPosition.runItemIndex();
    }
}
