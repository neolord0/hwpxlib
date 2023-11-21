package kr.dogfoot.hwpxlib.tool.textextractor;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.ParaListCore;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.Para;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.Run;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.RunItem;
import kr.dogfoot.hwpxlib.tool.textextractor.comm.ExtractorBase;
import kr.dogfoot.hwpxlib.tool.textextractor.comm.ExtractorManager;

public class ForScopedParaList extends ExtractorBase {
    public ForScopedParaList(ExtractorManager manager, Parameter parameter) {
        super(manager, parameter);
    }

    @Override
    public ObjectType _objectType() {
        return null;
    }

    @Override
    public void extract(HWPXObject from) throws Exception {
        ParaListCore paraList = (ParaListCore) from;
        int paraCount = paraList.countOfPara();

        int startPosition = parameter.startParaIndex();
        int endPosition = parameter.endParaIndex(paraCount);

        for (int paraIndex = startPosition; paraIndex <= endPosition; paraIndex++) {
            para(paraList.getPara(paraIndex),
                    paraIndex == startPosition,
                    paraIndex == endPosition);

            if (paraIndex < endPosition) {
                textBuilder().paraSeparator();
            }
        }
    }

    private void para(Para para, boolean isStart, boolean isEnd) throws Exception {
        int runCount = para.countOfRun();

        int startPosition = (isStart) ? parameter.startRunIndex() : 0;
        int endPosition = (isEnd) ? parameter.endRunIndex(runCount) : runCount - 1;

        if (parameter.textExtractMethod() == TextExtractMethod.InsertControlTextBetweenParagraphText) {
            for (int runIndex = startPosition; runIndex <= endPosition; runIndex++) {
                run(para.getRun(runIndex),
                        isStart && runIndex == startPosition,
                        isEnd && runIndex == endPosition,
                        RunItemSort.All);
            }
        } else if (parameter.textExtractMethod() == TextExtractMethod.AppendControlTextAfterParagraphText) {
            for (int runIndex = startPosition; runIndex <= endPosition; runIndex++) {
                run(para.getRun(runIndex),
                        isStart && runIndex == startPosition,
                        isEnd && runIndex == endPosition, RunItemSort.Text);
            }

            for (int runIndex = startPosition; runIndex <= endPosition; runIndex++) {
                run(para.getRun(runIndex),
                        isStart && runIndex == startPosition,
                        isEnd && runIndex == endPosition,
                        RunItemSort.Object);
            }
        }
    }

    private void run(Run run, boolean isStart, boolean isEnd, RunItemSort runItemSort) throws Exception {
        int runItemCount = run.countOfRunItem();

        int startPosition = (isStart) ? parameter.startRunItemIndex() : 0;
        int endPosition = (isEnd) ? parameter.endRunItemIndex(runItemCount) : runItemCount - 1;

        for (int runItemIndex = startPosition; runItemIndex <= endPosition; runItemIndex++) {
            RunItem runItem = run.getRunItem(runItemIndex);

            switch (runItemSort) {
                case All:
                    if (extractableText(runItem) || extractableObject(runItem)) {
                        runItem(runItem);
                    }
                    break;
                case Text:
                    if (extractableText(runItem)) {
                        runItem(runItem);
                    }
                    break;
                case Object:
                    if (extractableObject(runItem)) {
                        runItem(runItem);
                    }
                    break;
            }
        }
    }

    private static boolean extractableText(RunItem runItem) {
        return runItem._objectType() == ObjectType.hp_t;
    }

    private boolean extractableObject(RunItem runItem) {
        switch (runItem._objectType()) {
            case hp_tbl:
            case hp_container:
            case hp_line:
            case hp_rect:
            case hp_ellipse:
            case hp_arc:
            case hp_polygon:
            case hp_curve:
            case hp_connectLine:
            case hp_textart:
                return true;
        }
        return false;
    }

    private void runItem(RunItem runItem) throws Exception {
        ExtractorBase extractor = extractorManager.get(runItem._objectType());
        extractor.extract(runItem);
        extractorManager.release(extractor);
    }

    private enum RunItemSort {
        All,
        Text,
        Object
    }
}
