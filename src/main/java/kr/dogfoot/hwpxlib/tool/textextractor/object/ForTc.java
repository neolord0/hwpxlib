package kr.dogfoot.hwpxlib.tool.textextractor.object;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.object.table.Tc;
import kr.dogfoot.hwpxlib.tool.textextractor.Parameter;
import kr.dogfoot.hwpxlib.tool.textextractor.comm.ExtractorBase;
import kr.dogfoot.hwpxlib.tool.textextractor.comm.ExtractorManager;

public class ForTc extends ExtractorBase {
    public ForTc(ExtractorManager extractorManager, Parameter parameter) {
        super(extractorManager, parameter);
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_tc;
    }

    @Override
    public void extract(HWPXObject from) throws Exception {
        Tc tc = (Tc) from;

        extractChild(tc.subList());
    }
}
