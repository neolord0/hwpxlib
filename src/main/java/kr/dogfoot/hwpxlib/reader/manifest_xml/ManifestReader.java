package kr.dogfoot.hwpxlib.reader.manifest_xml;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.metainf.FileEntry;
import kr.dogfoot.hwpxlib.object.metainf.ManifestXMLFile;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.util.ElementNames;
import org.xml.sax.Attributes;

public class ManifestReader extends ElementReader {
    private ManifestXMLFile manifestXMLFile;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.Manifest;
    }

    @Override
    public void childElement(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.FileEntry:
                fileEntry(manifestXMLFile.addNewFileEntry(), name, attrs);
                break;
        }
    }

    @Override
    public void childElementInSwitch(HWPXObject child, String name, Attributes attrs) {
        if (child.objectType() == ObjectType.FileEntry) {
            fileEntry((FileEntry) child, name, attrs);
        }
    }

    private void fileEntry(FileEntry fileEntry, String name, Attributes attrs) {
        ((FileEntryReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.FileEntry))
                .fileEntry(fileEntry);

        xmlFileReader().startElement(name, attrs);
    }

    @Override
    public SwitchableObject switchableObject() {
        return manifestXMLFile;
    }

    public void manifestXMLFile(ManifestXMLFile manifestXMLFile) {
        this.manifestXMLFile = manifestXMLFile;
    }
}
