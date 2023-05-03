package kr.dogfoot.hwpxlib.tool.textextractor;

import kr.dogfoot.hwpxlib.object.HWPXFile;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.tool.textextractor.comm.TextBuilder;
import kr.dogfoot.hwpxlib.tool.textextractor.paraHead.ParaHeadMaker;

import java.util.ArrayList;

public class Parameter {
    private final TextExtractMethod textExtractMethod;
    private final ArrayList<ObjectType> exceptedObjects;
    private final boolean insertParaHead;
    private final TextBuilder textBuilder;
    private ParaHeadMaker paraHeadMaker;

    public Parameter(HWPXFile hwpxFile,
                     TextExtractMethod textExtractMethod,
                     ArrayList<ObjectType> exceptedObjects,
                     boolean insertParaHead,
                     TextMarks textMarks) {
        this.textExtractMethod = textExtractMethod;
        this.exceptedObjects = exceptedObjects;
        this.insertParaHead = insertParaHead;
        if (insertParaHead) {
            paraHeadMaker = new ParaHeadMaker(hwpxFile);
        }
        this.textBuilder = new TextBuilder(textMarks);
    }

    public TextExtractMethod textExtractMethod() {
        return textExtractMethod;
    }

    public boolean exceptedObject(ObjectType objectType) {
        if (exceptedObjects != null) {
            return exceptedObjects.contains(objectType);
        } else {
            return false;
        }
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
}
