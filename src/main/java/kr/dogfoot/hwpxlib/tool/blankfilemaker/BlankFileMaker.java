package kr.dogfoot.hwpxlib.tool.blankfilemaker;

import kr.dogfoot.hwpxlib.object.HWPXFile;
import kr.dogfoot.hwpxlib.object.content.header_xml.enumtype.TargetApplicationSort;
import kr.dogfoot.hwpxlib.object.metainf.ContainerXMLFile;
import kr.dogfoot.hwpxlib.object.root.SettingsXMLFile;
import kr.dogfoot.hwpxlib.object.root.VersionXMLFile;
import kr.dogfoot.hwpxlib.tool.blankfilemaker.header.ForHeaderXMLFile;
import kr.dogfoot.hwpxlib.tool.blankfilemaker.section.ForSection0XMLFile;

public class BlankFileMaker {
    public static HWPXFile make() {
        HWPXFile hwpxFile = new HWPXFile();
        settingsXMLFile(hwpxFile.settingsXMLFile());
        versionXMLFile(hwpxFile.versionXMLFile());
        containerXMLFile(hwpxFile.containerXMLFile());
        ForContentHPFFile.make(hwpxFile.contentHPFFile());
        ForHeaderXMLFile.make(hwpxFile.headerXMLFile());
        ForSection0XMLFile.make(hwpxFile.sectionXMLFileList().addNew());
        return hwpxFile;
    }

    private static void settingsXMLFile(SettingsXMLFile settingsXMLFile) {
        settingsXMLFile.createCaretPosition();
        settingsXMLFile.caretPosition()
                .listIDRefAnd(0)
                .paraIDRefAnd(0)
                .pos(16);
    }

    private static void versionXMLFile(VersionXMLFile versionXMLFile) {
        versionXMLFile
                .targetApplicationAnd(TargetApplicationSort.WordProcessor)
                .applicationAnd("hwpxlib")
                .appVersion("unknown");

        versionXMLFile.version()
                .majorAnd(5)
                .minorAnd(0)
                .microAnd(5)
                .buildNumber(0);
    }

    private static void containerXMLFile(ContainerXMLFile containerXMLFile) {
        containerXMLFile.createRootFiles();

        containerXMLFile.rootFiles().addNew()
                .fullPathAnd("Contents/content.hpf")
                .mediaType("application/hwpml-package+xml");
    }
}

