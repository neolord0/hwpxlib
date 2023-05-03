package kr.dogfoot.hwpxlib.tool.textextractor.object;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.SubList;
import kr.dogfoot.hwpxlib.tool.textextractor.Parameter;
import kr.dogfoot.hwpxlib.tool.textextractor.comm.ExtractorBase;
import kr.dogfoot.hwpxlib.tool.textextractor.comm.ExtractorManager;

public class ForSubList extends ExtractorBase {
    public ForSubList(ExtractorManager extractorManager, Parameter parameter) {
        super(extractorManager, parameter);
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hp_subList;
    }

    @Override
    public void extract(HWPXObject from) throws Exception {
        SubList subList = (SubList) from;

        int count = subList.countOfPara();
        for (int index = 0; index < count; index++) {
            extractChild(subList.getPara(index));

            if(index < count - 1) {
                textBuilder().paraSeparator();
            }
        }
    }
}
