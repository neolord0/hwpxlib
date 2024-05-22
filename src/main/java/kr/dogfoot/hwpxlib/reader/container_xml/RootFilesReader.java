package kr.dogfoot.hwpxlib.reader.container_xml;

import kr.dogfoot.hwpxlib.commonstrings.ElementNames;
import kr.dogfoot.hwpxlib.object.common.HWPXObject;
import kr.dogfoot.hwpxlib.object.common.ObjectList;
import kr.dogfoot.hwpxlib.object.common.SwitchableObject;
import kr.dogfoot.hwpxlib.object.metainf.RootFile;
import kr.dogfoot.hwpxlib.reader.common.ElementReader;
import kr.dogfoot.hwpxlib.reader.common.ElementReaderSort;
import org.xml.sax.Attributes;

public class RootFilesReader extends ElementReader {
    private ObjectList<RootFile> rootFiles;

    @Override
    public ElementReaderSort sort() {
        return ElementReaderSort.RootFiles;
    }

    @Override
    public void childElement(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.ocf_rootfile:
                rootFile(rootFiles.addNew(), name, attrs);
                break;
        }
    }

    @Override
    public HWPXObject childElementInSwitch(String name, Attributes attrs) {
        switch (name) {
            case ElementNames.ocf_rootfile:
                RootFile rootFile = new RootFile();
                rootFile(rootFile, name, attrs);
                return rootFile;
        }
        return null;
    }

    private void rootFile(RootFile rootFile, String name, Attributes attrs) {
        ((RootFileReader) xmlFileReader().setCurrentElementReader(ElementReaderSort.RootFile))
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
