package kr.dogfoot.hwpxlib.tool.finder;

import kr.dogfoot.hwpxlib.object.HWPXFile;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.masterpage_xml.MasterPageXMLFile;
import kr.dogfoot.hwpxlib.object.content.section_xml.SectionXMLFile;
import kr.dogfoot.hwpxlib.object.dochistory.HistoryXMLFile;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderBase;
import kr.dogfoot.hwpxlib.tool.finder.comm.FinderManager;

public class FromHWPXFile extends FinderBase {
    public FromHWPXFile(FinderManager finderManager, Parameter parameter) {
        super(finderManager, parameter);
    }

    @Override
    public ObjectType _objectType() {
        return ObjectType.HWPXFile;
    }

    @Override
    public void find(HWPXObject from) throws Exception {
        HWPXFile hwpxFile = (HWPXFile) from;
        pushPath(hwpxFile);

        check(hwpxFile.versionXMLFile());
        checkWithChildren(hwpxFile.manifestXMLFile());
        checkWithChildren(hwpxFile.containerXMLFile());
        checkWithChildren(hwpxFile.contentHPFFile());
        checkWithChildren(hwpxFile.headerXMLFile());

        for (MasterPageXMLFile masterPageXMLFile : hwpxFile.masterPageXMLFileList().items()) {
            checkWithChildren(masterPageXMLFile);
        }

        for (SectionXMLFile sectionXMLFile : hwpxFile.sectionXMLFileList().items()) {
            checkWithChildren(sectionXMLFile);
        }

        checkWithChildren(hwpxFile.settingsXMLFile());

        for (HistoryXMLFile historyXMLFile : hwpxFile.historyXMLFileList().items()) {
            checkWithChildren(historyXMLFile);
        }

        popPath();
    }
}
