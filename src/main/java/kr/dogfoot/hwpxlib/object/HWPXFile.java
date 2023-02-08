package kr.dogfoot.hwpxlib.object;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectList;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.content.context_hpf.ContentHPFFile;
import kr.dogfoot.hwpxlib.object.content.header_xml.HeaderXMLFile;
import kr.dogfoot.hwpxlib.object.content.masterpage_xml.MasterPageXMLFile;
import kr.dogfoot.hwpxlib.object.content.section_xml.SectionXMLFile;
import kr.dogfoot.hwpxlib.object.metainf.ContainerXMLFile;
import kr.dogfoot.hwpxlib.object.metainf.ManifestXMLFile;
import kr.dogfoot.hwpxlib.object.root.SettingsXMLFile;
import kr.dogfoot.hwpxlib.object.root.VersionXMLFile;

/**
 * HWPX 파일 전체를 나타내는 객체
 */
public class HWPXFile extends HWPXObject {
    private final VersionXMLFile versionXMLFile;
    private final ManifestXMLFile manifestXMLFile;
    private final ContainerXMLFile containerXMLFile;
    private final ContentHPFFile contentHPFFile;

    private final HeaderXMLFile headerXMLFile;
    private final ObjectList<MasterPageXMLFile> masterPageXMLFileList;
    private final ObjectList<SectionXMLFile> sectionXMLFileList;
    private final SettingsXMLFile settingsXMLFile;


    public HWPXFile() {
        versionXMLFile = new VersionXMLFile();
        manifestXMLFile = new ManifestXMLFile();
        containerXMLFile = new ContainerXMLFile();
        contentHPFFile = new ContentHPFFile();

        headerXMLFile = new HeaderXMLFile();
        masterPageXMLFileList = new ObjectList<MasterPageXMLFile>(MasterPageXMLFile.class);
        sectionXMLFileList = new ObjectList<SectionXMLFile>(SectionXMLFile.class);
        settingsXMLFile = new SettingsXMLFile();
    }

    @Override
    public ObjectType objectType() {
        return ObjectType.HWPXFile;
    }

    public VersionXMLFile versionXMLFile() {
        return versionXMLFile;
    }

    public ManifestXMLFile manifestXMLFile() {
        return manifestXMLFile;
    }

    public ContainerXMLFile containerXMLFile() {
        return containerXMLFile;
    }

    public ContentHPFFile contentHPFFile() {
        return contentHPFFile;
    }

    public HeaderXMLFile headerXMLFile() {
        return headerXMLFile;
    }

    public ObjectList<MasterPageXMLFile> masterPageXMLFileList() {
        return masterPageXMLFileList;
    }

    public ObjectList<SectionXMLFile> sectionXMLFileList() {
        return sectionXMLFileList;
    }

    public SettingsXMLFile settingsXMLFile() {
        return settingsXMLFile;
    }

}
