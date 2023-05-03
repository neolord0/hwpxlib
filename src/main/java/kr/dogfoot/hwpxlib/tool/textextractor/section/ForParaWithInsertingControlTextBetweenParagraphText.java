package kr.dogfoot.hwpxlib.tool.textextractor.section;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.*;
import kr.dogfoot.hwpxlib.tool.textextractor.Parameter;
import kr.dogfoot.hwpxlib.tool.textextractor.comm.ExtractorBase;
import kr.dogfoot.hwpxlib.tool.textextractor.comm.ExtractorManager;

public class ForParaWithInsertingControlTextBetweenParagraphText extends ExtractorBase {
    public ForParaWithInsertingControlTextBetweenParagraphText(ExtractorManager extractorManager, Parameter parameter) {
        super(extractorManager, parameter);
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_p;
    }

    @Override
    public void extract(HWPXObject from) throws Exception {
        Para para = (Para) from;

        if (parameter.insertParaHead()) {
            String paraHead = paraHeadMaker().make(para);
            if (paraHead != null && paraHead.length() > 0) {
                textBuilder().text(paraHead);
                textBuilder().text(" ");
            }

            textBuilder().text(" ");
        }

        for (Run run : para.runs()) {
            run(run);
        }
    }

    private void run(Run run) throws Exception {
        for (RunItem item : run.runItems()) {
            switch (item._objectType()) {
                case hp_t:
                    extractChild(item);
                    break;
                case hp_ctrl:
                    ctrl((Ctrl) item);
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
                    extractChild(item);
                    break;
            }
        }
    }

    private void ctrl(Ctrl ctrl) {
        for (CtrlItem item : ctrl.ctrlItems()) {
            if (item._objectType() == ObjectType.hp_fieldBegin) {
                textBuilder().objectStart(ObjectType.hp_fieldBegin);
            } else if (item._objectType() == ObjectType.hp_fieldEnd) {
                textBuilder().objectEnd(ObjectType.hp_fieldEnd);
            }
        }
    }
}
