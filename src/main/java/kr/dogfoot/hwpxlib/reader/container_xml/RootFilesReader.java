package kr.dogfoot.hwpxlib.reader.container_xml;

import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.common.ObjectList;
import kr.dogfoot.hwpxlib.object.common.ObjectType;
import kr.dogfoot.hwpxlib.object.metainf.RootFile;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import kr.dogfoot.hwpxlib.util.ElementNames;
import org.xml.sax.Attributes;

public class RootFilesReader extends ElementReader {
    private ObjectList<RootFile> rootFiles;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.RootFiles;
    }

    @Override
    public void childElement(String name, Attributes attrs) {
        switch(name) {
            case ElementNames.RootFile:
                rootFile(rootFiles.addNew(), name, attrs);
                break;
        }
    }

    @Override
    public void childElementInSwitch(HWPXObject child, String name, Attributes attrs) {
        if (child.objectType() == ObjectType.RootFile) {
            rootFile((RootFile) child, name, attrs);
        }
    }

    private void rootFile(RootFile rootFile, String name, Attributes attrs) {
        ((RootFileReader) xmlFileReader().setCurrentEntryReader(ElementReaderSort.RootFile))
                .rootFile(rootFile);

        xmlFileReader().startElement(name, attrs);
    }

    @Override
    public SwitchableObject switchableObject() {
        return rootFiles;
    }

    public void rootFiles(ObjectList<RootFile> rootFiles) {
        this.rootFiles = rootFiles;
    }
}