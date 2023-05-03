package kr.dogfoot.hwpxlib.tool.textextractor.comm;

import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.tool.textextractor.Parameter;
import kr.dogfoot.hwpxlib.tool.textextractor.TextExtractMethod;
import kr.dogfoot.hwpxlib.tool.textextractor.object.*;
import kr.dogfoot.hwpxlib.tool.textextractor.section.*;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class ExtractorManager {
    private final Map<ObjectType, Queue<ExtractorBase>> storage;
    private final Parameter parameter;
    private final NoWorkingExtractor noWorkingExtractor;

    public ExtractorManager(Parameter parameter) {
        storage = new HashMap<ObjectType, Queue<ExtractorBase>>();
        this.parameter = parameter;

        noWorkingExtractor = new NoWorkingExtractor(this, parameter);
    }

    public ExtractorBase get(ObjectType objectType) {
        Queue<ExtractorBase> queue = queue(objectType);
        ExtractorBase extractor = queue.poll();
        if (extractor != null) {
            return extractor;
        }
        return create(objectType);
    }

    private Queue<ExtractorBase> queue(ObjectType objectType) {
        Queue<ExtractorBase> queue = storage.get(objectType);
        if (queue == null) {
            queue = new LinkedList<ExtractorBase>();
            storage.put(objectType, queue);
        }
        return queue;
    }

    public void release(ExtractorBase extractor) {
        if (extractor._objectType() != ObjectType.Unknown) {
            Queue<ExtractorBase> queue = queue(extractor._objectType());
            queue.offer(extractor);
        }
    }

    private ExtractorBase create(ObjectType objectType) {
        switch (objectType) {
            case HWPXFile:
                return new ForHWPXFile(this, parameter);
            case hs_sec:
                return new ForSectionXMLFile(this, parameter);
            case hp_p:
                if (parameter.textExtractMethod() == TextExtractMethod.InsertControlTextBetweenParagraphText) {
                    return new ForParaWithInsertingControlTextBetweenParagraphText(this, parameter);
                } else {
                    return new ForParaWithAppendingControlTextAfterParagraphText(this, parameter);
                }
            case hp_t:
                return new ForT(this, parameter);
            case hp_tbl:
                return new ForTable(this, parameter);
            case hp_tc:
                return new ForTc(this, parameter);
            case hp_subList:
                return new ForSubList(this, parameter);
            case hp_container:
                return new ForContainer(this, parameter);
            case hp_line:
            case hp_rect:
            case hp_ellipse:
            case hp_arc:
            case hp_polygon:
            case hp_curve:
            case hp_connectLine:
            case hp_textart:
                return new ForDrawingObject(this, parameter, objectType);

        }
        return noWorkingExtractor;
    }
}
