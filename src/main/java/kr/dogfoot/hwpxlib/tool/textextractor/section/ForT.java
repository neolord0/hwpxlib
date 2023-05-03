package kr.dogfoot.hwpxlib.tool.textextractor.section;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.T;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.TItem;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.t.NormalText;
import kr.dogfoot.hwpxlib.tool.textextractor.Parameter;
import kr.dogfoot.hwpxlib.tool.textextractor.comm.ExtractorBase;
import kr.dogfoot.hwpxlib.tool.textextractor.comm.ExtractorManager;

public class ForT extends ExtractorBase {
    public ForT(ExtractorManager extractorManager, Parameter parameter) {
        super(extractorManager, parameter);
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_t;
    }

    @Override
    public void extract(HWPXObject from) throws Exception {
        T t = (T) from;
        if (t.isEmpty()) {
            return;
        }
        if (t.isOnlyText()) {
            textBuilder().text(t.onlyText());
        } else {
            complexText(t);
        }
    }

    private void complexText(T t) {
        for (TItem item : t.items()) {
            switch (item._objectType()) {
                case NormalText:
                    textBuilder().text(((NormalText) item).text());
                    break;
                case hp_fwSpace:
                case hp_nbSpace:
                    textBuilder().space();
                    break;
                case hp_hyphen:
                    textBuilder().hyphen();
                    break;
                case hp_lineBreak:
                    textBuilder().lineBreak();
                    break;
                case hp_tab:
                    textBuilder().tab();
                    break;
            }
        }
    }
}
