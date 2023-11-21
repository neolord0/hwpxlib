package kr.dogfoot.hwpxlib.tool.textextractor.section;

import kr.dogfoot.hwpxlib.object.HWPXFile;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.SectionXMLFile;
import kr.dogfoot.hwpxlib.tool.textextractor.Parameter;
import kr.dogfoot.hwpxlib.tool.textextractor.comm.ExtractorBase;
import kr.dogfoot.hwpxlib.tool.textextractor.comm.ExtractorManager;

public class ForHWPXFile extends ExtractorBase {
    public ForHWPXFile(ExtractorManager extractorManager, Parameter parameter) {
        super(extractorManager, parameter);
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.HWPXFile;
    }

    @Override
    public void extract(HWPXObject from) throws Exception {
        HWPXFile hwpxFile = (HWPXFile) from;
        for (SectionXMLFile sectionXMLFile : hwpxFile.sectionXMLFileList().items()) {
            extractChild(sectionXMLFile);
        }
    }
}
