package kr.dogfoot.hwpxlib.tool.finder.section;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.section_xml.SectionXMLFile;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.Para;
import kr.dogfoot.hwpxlib.tool.finder.Parameter;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderBase;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderManager;

public class FromSectionXMLFile extends FinderBase {
    public FromSectionXMLFile(FinderManager finderManager, Parameter parameter) {
        super(finderManager, parameter);
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.hs_sec;
    }

    @Override
    public void find(HWPXObject from) throws Exception {
        SectionXMLFile sectionXMLFile = (SectionXMLFile) from;
        pushPath(sectionXMLFile);
        for (Para para : sectionXMLFile.paras()) {
            checkWithChildren(para);
        }

        checkSwitchList(sectionXMLFile.switchList());
        popPath();
    }
}
