package kr.dogfoot.hwpxlib.tool.textextractor.section;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.SectionXMLFile;
import kr.dogfoot.hwpxlib.tool.textextractor.Parameter;
import kr.dogfoot.hwpxlib.tool.textextractor.comm.ExtractorBase;
import kr.dogfoot.hwpxlib.tool.textextractor.comm.ExtractorManager;

public class ForSectionXMLFile extends ExtractorBase {
    public ForSectionXMLFile(ExtractorManager extractorManager, Parameter parameter) {
        super(extractorManager, parameter);
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hs_sec;
    }

    @Override
    public void extract(HWPXObject from) throws Exception {
        SectionXMLFile sectionXMLFile = (SectionXMLFile) from;
        if (parameter.insertParaHead()) {
            paraHeadMaker().startSection();
        }

        int count = sectionXMLFile.countOfPara();
        for (int index = 0; index < count; index++) {
            extractChild(sectionXMLFile.getPara(index));

            if(index < count - 1) {
                textBuilder().paraSeparator();
            }
        }

        if (parameter.insertParaHead()) {
            paraHeadMaker().endSection();
        }
    }
}
