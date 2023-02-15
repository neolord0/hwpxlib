package kr.dogfoot.hwpxlib.reader.container_xml;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectList;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.metainf.ContainerXMLFile;
import kr.dogfoot.hwpxlib.object.metainf.RootFile;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.util.ElementNames;
import org.xml.sax.Attributes;

public class ContainerReader extends ElementReader {
    private ContainerXMLFile containerXMLFile;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.Container;
    }

    @Override
    public void childElement(String name, Attributes attrs) {
        switch(name) {
            case ElementNames.ocf_rootfiles:
                containerXMLFile.createRootFiles();
                rootFiles(containerXMLFile.rootFiles(), name, attrs);
                break;
        }
    }

    @Override
    public HWPXObject childElementInSwitch(String name, Attributes attrs) {
        switch(name) {
            case ElementNames.ocf_rootfiles:
                ObjectList<RootFile> rootFiles = new ObjectList<RootFile>(ObjectType.ocf_rootfiles, RootFile.class);
                rootFiles(rootFiles, name, attrs);
                return rootFiles;
        }
        return null;
    }

    private void rootFiles(ObjectList<RootFile> rootFileObjectList, String name, Attributes attrs) {
        ((RootFilesReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.RootFiles))
                .rootFiles(rootFileObjectList);

        xmlFileReader().startElement(name, attrs);
    }

    @Override
    public SwitchableObject switchableObject() {
        return containerXMLFile;
    }

    public void containerXMLFile(ContainerXMLFile containerXMLFile) {
        this.containerXMLFile = containerXMLFile;
    }
}
